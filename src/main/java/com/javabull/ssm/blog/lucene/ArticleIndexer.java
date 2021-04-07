package com.javabull.ssm.blog.lucene;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.http.HtmlUtil;
import com.github.pagehelper.util.StringUtil;
import com.javabull.ssm.blog.bean.Article;
import com.javabull.ssm.blog.entity.LucenePageInfo;
import com.javabull.ssm.blog.util.MyUtil;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleIndexer {

    private final ServletContext servletContext;

    private final RedisTemplate<String, Object> redisTemplate;

    public ArticleIndexer(ServletContext servletContext, RedisTemplate<String, Object> redisTemplate) {
        this.servletContext = servletContext;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 获取写入索引文件书写器
     *
     * @return
     */
    private IndexWriter getWriter() {
        String luceneIndexPath = servletContext.getInitParameter("luceneIndexPath");
        IndexWriter writer = null;
        try {
            Directory dir = FSDirectory.open(Paths.get(luceneIndexPath));
            SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
            IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
            writer = new IndexWriter(dir, iwc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return writer;
    }

    /**
     * @param article
     * @return
     */
    private Document getDocument(Article article) {
        Document doc = new Document();
        doc.add(new StringField("articleId", String.valueOf(article.getArticleId()), Field.Store.YES));
        doc.add(new TextField("articleTitle", article.getArticleTitle(), Field.Store.YES));
        doc.add(new StringField("articleCreateTime", MyUtil.formatDate(article.getArticleCreateTime(),
                "yyyy-MM-dd"), Field.Store.YES));
        doc.add(new TextField("articleContent", HtmlUtil.cleanHtmlTag(article.getArticleContent()), Field.Store.YES));
        return doc;
    }

    /**
     * 将Blog属性写入索引
     *
     * @param article
     */
    public void addIndex(Article article) {
        IndexWriter writer = getWriter();
        Document doc = this.getDocument(article);
        try {
            writer.addDocument(doc);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 用lucene对博客标题和内容进行全文检索
     *
     * @param input
     * @return
     */
    public LucenePageInfo<Article> searchArticle(String input, Integer pageIndex, Integer pageSize) {
        String luceneIndexPath = servletContext.getInitParameter("luceneIndexPath");
        List<Article> articles = new ArrayList<>();
        LucenePageInfo<Article> pageInfo = new LucenePageInfo<>();
        pageInfo.setList(articles);
        try {
            Directory dir = FSDirectory.open(Paths.get(luceneIndexPath));
            IndexReader reader = DirectoryReader.open(dir);
            IndexSearcher is = new IndexSearcher(reader);
            BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
            SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();

            QueryParser titleParser = new QueryParser("articleTitle", analyzer);
            Query query = titleParser.parse(input);

            QueryParser contentParser = new QueryParser("articleContent", analyzer);
            Query queryContent = contentParser.parse(input);

            booleanQuery.add(query, BooleanClause.Occur.SHOULD);
            booleanQuery.add(queryContent, BooleanClause.Occur.SHOULD);

            TopDocs hits = is.search(booleanQuery.build(), 100);
            QueryScorer scorer = new QueryScorer(query);

            Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
            SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<font color='red'>", "</font>");
            Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
            highlighter.setTextFragmenter(fragmenter);

            //分页处理
            int length = hits.scoreDocs.length;
            int pageNum = length / pageSize;
            int tmp = pageNum * pageSize;
            if (tmp < length) {
                pageNum += 1;
            }
            //页码导航
            pageInfo.setNavigatepageNums(ArrayUtil.range(1, pageNum + 1, 1));
            //当前页面
            pageInfo.setPageNum(pageIndex);
            //是否有上一页
            pageInfo.setHasNextPage((pageIndex + 1) * pageSize <= length);
            //是否有下一页
            pageInfo.setHasPreviousPage(((pageIndex - 1) * pageSize <= length) && (pageIndex - 1 > 0));
            //设置总页数
            pageInfo.setPages(pageNum);

            for (int i = (pageIndex - 1) * pageSize; (i < pageIndex * pageSize) && (i < length); i++) {
                ScoreDoc scoreDoc = hits.scoreDocs[i];
                Document doc = is.doc(scoreDoc.doc);
                Article article = new Article();
                article.setArticleId(Integer.parseInt(doc.get("articleId")));
                article.setArticleCreateTime(MyUtil.parse(doc.get("articleCreateTime"), "yyyy-MM-dd"));
                //用apache.commons.lang组件对标签进行转义过滤
                String title = StringEscapeUtils.escapeHtml(doc.get("articleTitle"));
                String content = StringEscapeUtils.escapeHtml(doc.get("articleContent"));
                if (title != null) {
                    //获取最佳片段
                    TokenStream tokenStream = analyzer.tokenStream("articleTitle", new StringReader(title));
                    String bestTitle = highlighter.getBestFragment(tokenStream, title);
                    //如果搜索不到结果就设置原标题
                    if (StringUtil.isEmpty(bestTitle)) {
                        article.setArticleTitle(title);
                    } else {
                        article.setArticleTitle(bestTitle);
                    }
                }

                if (content != null) {
                    TokenStream tokenStream = analyzer.tokenStream("articleContent", new StringReader(content));
                    String bestContent = highlighter.getBestFragment(tokenStream, content);
                    //如果搜不到内容就将原在内容中截取前250个字符
                    if (StringUtil.isEmpty(bestContent)) {
                        if (content.length() <= 200) {
                            article.setArticleContent(content);
                        } else {
                            article.setArticleContent(content.substring(0, 200));
                        }
                    } else {
                        article.setArticleContent(bestContent);
                    }
                }
                articles.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        pageInfo.setList(articles);
        return pageInfo;
    }

    /**
     * 删除blogId对应的索引
     *
     * @param articleId
     */
    public void deleteIndex(String articleId) {
        IndexWriter writer = getWriter();
        try {
            writer.deleteDocuments(new Term("articleId", articleId));
            writer.forceMergeDeletes(); // 强制删除
            writer.commit();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新索引
     *
     * @param article
     */
    public void updateIndex(Article article) {
        IndexWriter writer = getWriter();
        Document doc = this.getDocument(article);
        try {
            writer.updateDocument(new Term("articleId", String.valueOf(article.getArticleId())), doc);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

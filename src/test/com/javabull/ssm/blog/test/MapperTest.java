package com.javabull.ssm.blog.test;

import com.javabull.ssm.blog.bean.*;
import com.javabull.ssm.blog.dao.*;
import com.javabull.ssm.blog.entity.ArticleParam;
import com.javabull.ssm.blog.entity.CategoryParam;
import com.javabull.ssm.blog.util.MyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
public class MapperTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;

    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Autowired
    private UserMapper userMapper;

    private SqlSessionTemplate sqlSessionTemplate;

    @Transactional(rollbackFor = Exception.class)
    @Test
    public void testArticleMapper01() {
        Article article = new Article();
        article.setArticleStatus(1);
        articleMapper.insert(article);
        System.out.println(article.getArticleId());
        Category category = new Category();
        category.setCategoryName("hello");
        categoryMapper.insert(category);
        System.out.println(category.getCategoryId());
    }

    @Test
    public void testCategoryMapper() {
        Category category = new Category();
        category.setCategoryName("hello");
        categoryMapper.insert(category);
        System.out.println(category.getCategoryId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Test
    public void testArticleMapper02() {
        List<Article> articles = articleCategoryMapper.getArticlesWithCategory();
        System.out.println(articles);
    }

    @Test
    public void testArticleCategoryMapper01() {
        Category category = articleCategoryMapper.getByArticleIdWithCategorys(33);
        System.out.println(category);
    }

    /**
     * articleTagMapper.deleteTagRef(articleId);
     * articleCategoryMapper.deleteCategoryRef(articleId);
     */
    @Test
    public void testArticleTagMapper() {
        Integer articleId = 35;
        articleTagMapper.deleteTagRef(articleId);
    }

    @Test
    public void testUserMapper01() {
        User user = new User();
        user.setUserEmail("");
        user.setUserId(0);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(1);
        User ret = userMapper.selectSelectiveWithReturnSelective(user, userExample);
        System.out.println(ret);
    }

    @Test
    public void testUserMapper02() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(1);
        List<User> users = userMapper.selectByExample(userExample);
        System.out.println(users);
    }

    @Test
    public void testArticleTagMapper01() {
        List<Article> articles = articleTagMapper.getArticlesByTagId(1);
        System.out.println(articles.size());
    }

    @Test
    public void testarticleCategoryMapper01() {
        List<CategoryParam> categoryParams = articleCategoryMapper.selectAllCategoryArticleCount();
        System.out.println(categoryParams);
    }

    /**
     * 批量插入数据
     */
    public void testSqlSessionTemplate() {
        long start = System.currentTimeMillis();
        ArticleTagMapper articleTagMapper1 = sqlSessionTemplate.getMapper(ArticleTagMapper.class);
        ArticleMapper articleMapper1 = sqlSessionTemplate.getMapper(ArticleMapper.class);
        ArticleCategoryMapper articleCategoryMapper1 = sqlSessionTemplate.getMapper(ArticleCategoryMapper.class);
        Integer[] category = {1, 2, 3, 5, 6, 8, 14, 15, 17, 18, 19, 28};
        System.out.println("开始批量插入====================");
        for (int i = 0; i < 100000; i++) {
            Random random = new Random(500 + i);
            int index = random.nextInt(12);
            //分类
            Integer articleParentCategoryId = category[index];
            //文章标签
            Integer[] articleTagIds = {1, 2, 3, 4, 5, 6};
            Article article = new Article();
            String substring = UUID.randomUUID().toString().substring(0, 7);
            article.setArticleTitle(substring);
            article.setArticleImageUrl("/uploads/2020/7/课表(2).png");
            article.setArticleStatus(1);
            article.setArticleContent("\n" + substring +
                    "SQLite - PHP\n" +
                    "\n" +
                    "\n" +
                    "安装\n" +
                    "\n" +
                    "自 PHP 5.3.0 起默认启用 SQLite3 扩展。可以在编译时使用 --without-sqlite3 禁用 SQLite3 扩展。\n" +
                    "\n" +
                    "Windows 用户必须启用 php_sqlite3.dll 才能使用该扩展。自 PHP 5.3.0 起，这个 DLL 被包含在 PHP 的 Windows 分发版中。\n" +
                    "\n" +
                    "如需了解详细的安装指导，建议查看我们的 PHP 教程和它的官方网站。\n" +
                    "\n" +
                    "PHP 接口 API\n" +
                    "\n" +
                    "以下是重要的 PHP 程序，可以满足您在 PHP 程序中使用 SQLite 数据库的需求。如果您需要了解更多细节，请查看 PHP 官方文档。\n" +
                    "\n" +
                    "\n" +
                    "序号\n" +
                    "\n" +
                    "API & 描述\n" +
                    "\n" +
                    "1 public void SQLite3::open ( filename, flags, encryption_key )\n" +
                    "\n" +
                    "打开一个 SQLite 3 数据库。如果构建包括加密，那么它将尝试使用的密钥。\n" +
                    "\n" +
                    "如果文件名 filename 赋值为 ':memory:'，那么 SQLite3::open() 将会在 RAM 中创建一个内存数据库，这只会在 session 的有效时间内持续。\n" +
                    "\n" +
                    "如果文件名 filename 为实际的设备文件名称，那么 SQLite3::open() 将使用这个参数值尝试打开数据库文件。如果该名称的文件不存在，那么将创建一个新的命名为该名称的数据库文件。\n" +
                    "\n" +
                    "可选的 flags 用于判断是否打开 SQLite 数据库。默认情况下，当使用 SQLITE3_OPEN_READWRITE | SQLITE3_OPEN_CREATE 时打开。\n" +
                    " \n" +
                    "2 public bool SQLite3::exec ( string $query )\n" +
                    "\n" +
                    "该例程提供了一个执行 SQL 命令的快捷方式，SQL 命令由 sql 参数提供，可以由多个 SQL 命令组成。该程序用于对给定的数据库执行一个无结果的查询。\n" +
                    " \n" +
                    "3 public SQLite3Result SQLite3::query ( string $query )\n" +
                    "\n" +
                    "该例程执行一个 SQL 查询，如果查询到返回结果则返回一个 SQLite3Result 对象。\n" +
                    " \n" +
                    "4 public int SQLite3::lastErrorCode ( void )\n" +
                    "\n" +
                    "该例程返回最近一次失败的 SQLite 请求的数值结果代码。\n" +
                    " \n" +
                    "5 public string SQLite3::lastErrorMsg ( void )\n" +
                    "\n" +
                    "该例程返回最近一次失败的 SQLite 请求的英语文本描述。\n" +
                    " \n" +
                    "6 public int SQLite3::changes ( void )\n" +
                    "\n" +
                    "该例程返回最近一次的 SQL 语句更新或插入或删除的数据库行数。\n" +
                    " \n" +
                    "7 public bool SQLite3::close ( void )\n" +
                    "\n" +
                    "该例程关闭之前调用 SQLite3::open() 打开的数据库连接。\n" +
                    " \n" +
                    "8 public string SQLite3::escapeString ( string $value )\n" +
                    "\n" +
                    "该例程返回一个字符串，在 SQL 语句中，出于安全考虑，该字符串已被正确地转义。\n" +
                    " \n" +
                    "\n" +
                    "连接数据库\n" +
                    "\n" +
                    "下面的 PHP 代码显示了如何连接到一个现有的数据库。如果数据库不存在，那么它就会被创建，最后将返回一个数据库对象。\n" +
                    "1.<?php\n" +
                    "2.   class MyDB extends SQLite3\n" +
                    "3.   {\n" +
                    "4.      function __construct()\n" +
                    "5.      {\n" +
                    "6.         $this->open('test.db');\n" +
                    "7.      }\n" +
                    "8.   }\n" +
                    "9.   $db = new MyDB();\n" +
                    "10.   if(!$db){\n" +
                    "11.      echo $db->lastErrorMsg();\n" +
                    "12.   } else {\n" +
                    "13.      echo \"Opened database successfully\\n\";\n" +
                    "14.   }\n" +
                    "15.?>\n" +
                    "\n" +
                    "\n" +
                    "现在，让我们来运行上面的程序，在当前目录中创建我们的数据库 test.db。您可以根据需要改变路径。如果数据库成功创建，那么会显示下面所示的消息：\n" +
                    "1.Open database successfully\n" +
                    "\n" +
                    "\n" +
                    "创建表\n" +
                    "\n" +
                    "下面的 PHP 代码段将用于在先前创建的数据库中创建一个表：\n" +
                    "1.<?php\n" +
                    "2.   class MyDB extends SQLite3\n" +
                    "3.   {\n" +
                    "4.      function __construct()\n" +
                    "5.      {\n" +
                    "6.         $this->open('test.db');\n" +
                    "7.      }\n" +
                    "8.   }\n" +
                    "9.   $db = new MyDB();\n" +
                    "10.   if(!$db){\n" +
                    "11.      echo $db->lastErrorMsg();\n" +
                    "12.   } else {\n" +
                    "13.      echo \"Opened database successfully\\n\";\n" +
                    "14.   }\n" +
                    "15. \n" +
                    "16.   $sql =<<<EOF\n" +
                    "23.      INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)\n" +
                    "24.      VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );\n" +
                    "25. \n" +
                    "4.      function __construct()\n" +
                    "5.      {\n" +
                    "6.         $this->open('test.db');\n" +
                    "7.      }\n" +
                    "8.   }\n" +
                    "9.   $db = new MyDB();\n" +
                    "10.   if(!$db){\n" +
                    "11.      echo $db->lastErrorMsg();\n" +
                    "12.   } else {\n" +
                    "13.      echo \"Opened database successfully\\n\";\n" +
                    "14.   }\n" +
                    "15. \n" +
                    "16.   $sql =<<<EOF\n" +
                    "17.      SELECT * from COMPANY;\n" +
                    "18.EOF;\n" +
                    "19. \n" +
                    "20.   $ret = $db->query($sql);\n" +
                    "21.   while($row = $ret->fetchArray(SQLITE3_ASSOC) ){\n" +
                    "22.      echo \"ID = \". $row['ID'] . \"\\n\";\n" +
                    "23.      echo \"NAME = \". $row['NAME'] .\"\\n\";\n" +
                    "24.      echo \"ADDRESS = \". $row['ADDRESS'] .\"\\n\";\n" +
                    "25.      echo \"SALARY =  \".$row['SALARY'] .\"\\n\\n\";\n" +
                    "26.   }\n" +
                    "27.   echo \"Operation done successfully\\n\";\n" +
                    "8.NAME = Allen\n" +
                    "9.ADDRESS = Texas\n" +
                    "10.SALARY =  15000\n" +
                    "3.   {\n" +
                    "4.      function __construct()\n" +
                    "5.      {\n" +
                    "6.         $this->open('test.db');\n" +
                    "7.      }\n" +
                    "8.   }\n" +
                    "9.   $db = new MyDB();\n" +
                    "10.   if(!$db){\n" +
                    "11.      echo $db->lastErrorMsg();\n" +
                    "12.   } else {\n" +
                    "13.      echo \"Opened database successfully\\n\";\n" +
                    "14.   }\n" +
                    "15.   $sql =<<<EOF\n" +
                    "16.      UPDATE COMPANY set SALARY = 25000.00 where ID=1;\n" +
                    "30.      echo \"ID = \". $row['ID'] . \"\\n\";\n" +
                    "31.      echo \"NAME = \". $row['NAME'] .\"\\n\";\n" +
                    "32.      echo \"ADDRESS = \". $row['ADDRESS'] .\"\\n\";\n" +
                    "33.      echo \"SALARY =  \".$row['SALARY'] .\"\\n\\n\";\n" +
                    "34.   }\n" +
                    "35.   echo \"Operation done successfully\\n\";\n" +
                    "36.   $db->close();\n" +
                    "37.?>\n" +
                    "\n" +
                    "\n" +
                    "上述程序执行时，它会产生以下结果：\n" +
                    "1.Opened database successfully\n" +
                    "2.1 Record updated successfully\n" +
                    "3.ID = 1\n" +
                    "4.NAME = Paul\n" +
                    "5.ADDRESS = California\n" +
                    "6.SALARY =  25000\n" +
                    "7. \n" +
                    "8.ID = 2\n" +
                    "9.NAME = Allen\n" +
                    "10.ADDRESS = Texas\n" +
                    "11.SALARY =  15000\n" +
                    "12. \n" +
                    "13.ID = 3\n" +
                    "14.NAME = Teddy\n" +
                    "15.ADDRESS = Norway\n" +
                    "16.SALARY =  20000\n" +
                    "17. \n" +
                    "18.ID = 4\n" +
                    "19.NAME = Mark\n" +
                    "20.ADDRESS = Rich-Mond\n" +
                    "21.SALARY =  65000\n" +
                    "22. \n" +
                    "23.Operation done successfully\n" +
                    "\n" +
                    "\n" +
                    "DELETE 操作\n" +
                    "\n" +
                    "下面的 PHP 代码显示了如何使用 DELETE 语句删除任何记录，然后从 COMPANY 表中获取并显示剩余的记录：\n" +
                    "1.<?php\n" +
                    "2.   class MyDB extends SQLite3\n" +
                    "3.   {\n" +
                    "4.      function __construct()\n" +
                    "5.      {\n" +
                    "6.         $this->open('test.db');\n" +
                    "7.      }\n" +
                    "8.   }\n" +
                    "9.   $db = new MyDB();\n" +
                    "10.   if(!$db){\n" +
                    "11.      echo $db->lastErrorMsg();\n" +
                    "12.   } else {\n" +
                    "13.      echo \"Opened database successfully\\n\";\n" +
                    "14.   }\n" +
                    "15.   $sql =<<<EOF\n" +
                    "16.      DELETE from COMPANY where ID=2;\n" +
                    "17.EOF;\n" +
                    "18.   $ret = $db->exec($sql);\n" +
                    "19.   if(!$ret){\n" +
                    "36.   $db->close();\n" +
                    "37.?>\n" +
                    "\n" +
                    "\n" +
                    "上述程序执行时，它会产生以下结果：\n" +
                    "1.Opened database successfully\n" +
                    "2.1 Record deleted successfully\n" +
                    "3.ID = 1\n" +
                    "4.NAME = Paul\n" +
                    "5.ADDRESS = California\n" +
                    "6.SALARY =  25000\n" +
                    "7. \n" +
                    "8.ID = 3\n" +
                    "9.NAME = Teddy\n" +
                    "10.ADDRESS = Norway\n" +
                    "11.SALARY =  20000\n" +
                    "12. \n" +
                    "13.ID = 4\n" +
                    "14.NAME = Mark\n" +
                    "15.ADDRESS = Rich-Mond\n" +
                    "16.SALARY =  65000\n" +
                    "17. \n" +
                    "18.Operation done successfully\n"
            );
            article.setArticleOrder(6);
            article.setArticleReadAmount(0);
            Date date = new Date();
            article.setArticleCreateTime(date);
            article.setArticleUpdateTime(date);
            article.setArticleSummary(MyUtil.createSummaryText(article.getArticleContent()));
            articleMapper1.insert(article);
            Integer articleId = article.getArticleId();
            articleCategoryMapper1.insert(new ArticleCategory(articleId, articleParentCategoryId));
            //多个标签
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("articleId", articleId);
            map.put("articleTagIds", articleTagIds);
            articleTagMapper1.insertBatch(map);

        }
        System.out.println("批量插入结束====================");
        long end = System.currentTimeMillis();
        System.out.println("耗时: {" + (end - start) / 1000 / 60 + "}分钟");
    }

    public void testarticleTagMapper02() {
        System.out.println("开始批量插入============");
        ItemDao mapper = sqlSessionTemplate.getMapper(ItemDao.class);
        for (int i = 0; i < 100000; i++) {
            mapper.batchInsert(null, UUID.randomUUID().toString().substring(0, 7));
        }
        System.out.println("结束批量插入==============");
    }

    public void test() {
        System.out.println("开始批量插入=================");
        ArticleFullContentMapper mapper = sqlSessionTemplate.getMapper(ArticleFullContentMapper.class);
        ArticleMapper mapper1 = sqlSessionTemplate.getMapper(ArticleMapper.class);
        int index = 0;
        ArticleParam articleParam = mapper1.selectArticleParam(index);
        while (articleParam != null) {
            index++;
            mapper.insert(articleParam);
            articleParam = mapper1.selectArticleParam(index);
        }
        System.out.println("结束批量插入==============");
    }
}

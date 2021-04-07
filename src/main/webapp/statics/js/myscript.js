function keyword_btn_click() {
    ("#keyword-btn").click(function () {
        var val = (this).val();
        if (val.trim().empty()) {
            alert("搜索内容为空!");
            return false;
        }
        return true;
    });
}

function format_timestamp(timestamp) {
    var dateObj = new Date(timestamp);
    var year = dateObj.getYear() + 1900;
    var month = dateObj.getMonth() + 1;
    var theDate = dateObj.getDate();
    var hour = dateObj.getHours();
    var minute = dateObj.getMinutes();
    var second = dateObj.getSeconds();
    return year + "-" + month + "-" + theDate + " " + hour + ":" + minute + ":" + second;
}

function get_aticle_list(articleId) {
    var loadingIndex = null;
    //不安全 todo
    $.ajax({
        url: "/home/getArticle",
        type: "POST",
        data: {'articleId': articleId},
        beforeSend: function () {
            loadingIndex = layer.msg('正在加载数据', {icon: 16});
        },
        success: function (result) {
            if (result.code == 100) {
                var articles = result.extend.articles;
                var articleHtml = '';
                $.each(articles, function (i, a) {
                    articleHtml += '<div class="media panel panel-background" style="margin-top: 20px;min-height: 180px">';
                    articleHtml += '<div class="media-left media-middle media-head">';
                    articleHtml += '<img class="media-object" src="' + a.articleImageUrl + '" alt=""';
                    articleHtml += 'style="height: 100px;width: 166px">';
                    articleHtml += '</div>';
                    articleHtml += '<div class="media-body">';
                    articleHtml += '<div class="media-body-style">';
                    articleHtml += '<b>';
                    articleHtml += '<span class="glyphicon glyphicon-calendar"></span>';
                    articleHtml += format_timestamp(a.articleCreateTime) + '</b>';
                    articleHtml += '<b><span class="glyphicon glyphicon-eye-open"></span>' + a.articleReadAmount + '</b>';
                    var tagblock = '<b><span class="glyphicon glyphicon-tag"></span>';
                    $.each(a.tags, function (i, item) {
                        tagblock += item.tagContent + '  ';
                    });
                    tagblock += '</b>';
                    articleHtml += tagblock;
                    articleHtml += '<h4 class="media-heading"><a href="/article/' + a.articleId + '">' + a.articleTitle + '</a></h4>';
                    articleHtml += '<p style="margin-right: 5px">' + a.articleSummary + ' ...</p>';
                    articleHtml += '</div>';
                    articleHtml += '</div>';
                    articleHtml += '</div>';
                });
                $("#art").append(articleHtml);
                layer.close(loadingIndex);
            } else {
                layer.close(loadingIndex);
                layer.msg("数据加载失败,请刷新浏览器重试!", {time: 2000, icon: 5, shift: 6}, function () {
                });
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            layer.msg("数据加载失败,请刷新浏览器重试!", {time: 2000, icon: 5, shift: 6}, function () {
            });
        }
    });
}

function get_article_category(index, categoryId) {
    var loadingIndex = null;
    $.ajax({
        url: "/category/" + categoryId + "/getArticle",
        type: "POST",
        data: "index=" + index,
        beforeSend: function () {
            loadingIndex = layer.msg('正在加载数据', {icon: 16});
        },
        success: function (result) {
            if (result.code == 100) {
                var articleHtml = '';
                var pageInfo = result.extend.pageInfo;
                $.each(pageInfo.list, function (i, a) {
                    articleHtml += '<div class="media panel panel-background" style="margin-top: 20px;min-height: 180px">';
                    articleHtml += '<div class="media-left media-middle media-head">';
                    articleHtml += '<img class="media-object" src="' + a.articleImageUrl + '" alt=""';
                    articleHtml += 'style="height: 100px;width: 166px">';
                    articleHtml += '</div>';
                    articleHtml += '<div class="media-body">';
                    articleHtml += '<div class="media-body-style">';
                    articleHtml += '<b>';
                    articleHtml += '<span class="glyphicon glyphicon-calendar"></span>';
                    articleHtml += format_timestamp(a.articleCreateTime);
                    articleHtml += '</b>';
                    articleHtml += '<b>';
                    articleHtml += '<span class="glyphicon glyphicon-eye-open"></span>' + a.articleReadAmount + '</b>';
                    articleHtml += '<h4 class="media-heading"><a href="/article/' + a.articleId + '">' + a.articleTitle + '</a></h4>';
                    articleHtml += '<p style="margin-right: 5px">' + a.articleSummary + ' ...</p>';
                    articleHtml += '</div>';
                    articleHtml += '</div>';
                    articleHtml += '</div>';
                });
                var titleHtml = '';
                titleHtml += '<div class="media-left media-middle"></div>';
                titleHtml += '<div class="media-body">';
                titleHtml += '<h5>文章所属类别:';
                if ($.isEmptyObject(pageInfo.list)) {
                    titleHtml += '无';
                } else {
                    titleHtml += pageInfo.list[0].categories[0].categoryName;
                }
                titleHtml += '</h5>';
                titleHtml += '</div>';
                $("#articlelist").html(articleHtml);
                $("#title").html(titleHtml);
                layer.close(loadingIndex);
            } else {
                layer.close(loadingIndex);
                layer.msg("数据加载失败,请刷新浏览器重试!", {time: 2000, icon: 5, shift: 6}, function () {
                });
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            layer.msg("数据加载失败,请刷新浏览器重试!", {time: 2000, icon: 5, shift: 6}, function () {
            });
        }
    });
}



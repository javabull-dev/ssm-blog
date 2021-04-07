<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../Common/head.jsp" %>
<body>
<%@include file="../Common/nav.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <!--文章内容-->
            <div class="panel panel-article">
                <!--文章标题-->
                <h3>${article.articleTitle}</h3>
                <hr/>
                <!--文章阅读量-->
                <div class="article-tag-show">
                    <b><span class="glyphicon glyphicon-calendar"></span>
                        <fmt:formatDate value="${article.articleCreateTime}" pattern="yyyy-MM-dd"/>
                    </b>&nbsp;&nbsp;
                    <b><span class="glyphicon glyphicon-eye-open"></span> ${article.articleReadAmount}</b>
                </div>
                <!--文章的主题内容-->
                <div style="margin: 30px">${article.articleContent}</div>
            </div>
            <!--导航-->
            <%--            <ul class="pager">--%>
            <%--                <li class="previous"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span>PUT请求引发的一次血案</a>--%>
            <%--                </li>--%>
            <%--                <li class="next"><a href="#">ajax怎么写<span class="glyphicon glyphicon-chevron-right"></span></a></li>--%>
            <%--            </ul>--%>
            <!--文章评论-->
            <div class="panel">

            </div>
        </div>
    </div>
</div>
<%@ include file="../Common/footer.jsp"%>
</body>
<script type="text/javascript" src="/statics/js/myscript.js"></script>
</html>

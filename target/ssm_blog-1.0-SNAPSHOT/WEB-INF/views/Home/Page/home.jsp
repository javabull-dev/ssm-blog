<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../Common/head.jsp" %>
<body>
<%@include file="../Common/nav.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <!--轮播图-->
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="statics/images/docker.png" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="statics/images/linux.jpg" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="statics/images/爬虫.jpg" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

            <!--文章列表-->
            <div id="art"></div>
            <!--分页-->
            <%--            <nav id="page" aria-label="Page navigation" class="text-center"></nav>--%>
        </div>
        <%@include file="../Common/right_page.jsp" %>
    </div>
</div>
<%@ include file="../Common/footer.jsp" %>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/plugin/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/myscript.js"></script>
<script type="text/javascript">
    get_aticle_list("-1");
    $(window).scroll(function () {
        var totalHeight = parseInt($(document).scrollTop()) + 1 + $(window).height();
        if (totalHeight >= $(document).height()) {
            var href = $("#art div").last().find("h4 a").attr("href");
            var string = href.split("/");
            var articleId = string[string.length - 1];
            get_aticle_list(articleId);
        }
    });
</script>
</html>

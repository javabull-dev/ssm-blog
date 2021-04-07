<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="../Common/head.jsp" %>
<body>
<%@include file="../Common/nav.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <div class="media panel">
                <div class="media-left media-middle"></div>
                <div class="media-body">
                    <h5>搜索"${keyword}"的结果</h5>
                </div>
            </div>
            <c:if test="${lucenePageInfo==null}">
                <div class="media panel">
                    <div class="media-left media-middle"></div>
                    <div class="media-body">
                        <h4>未找到内容:(.....</h4>
                    </div>
                </div>
            </c:if>
            <div>
                <c:forEach items="${lucenePageInfo.list}" var="article">
                    <div class="media panel panel-background" style="min-height: 180px">
                        <div class="media-left media-middle media-head"></div>
                        <div class="media-body">
                            <div class="media-body-style">
                                <b>
                                    <span class="glyphicon glyphicon-calendar"></span>
                                    <fmt:formatDate value="${article.articleCreateTime}" pattern="yyyy-MM-dd"/>
                                </b>
                                <h4 class="media-heading"><a
                                        href="/article/${article.articleId}">${article.articleTitle}</a></h4>
                                <p style="margin-right: 5px">${article.articleContent} ...</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <!--分页-->
            <nav aria-label="Page navigation" class="text-center">
                <ul class="pagination">
                    <c:if test="${lucenePageInfo.pageNum ne 1 && lucenePageInfo.hasPreviousPage}">
                        <li>
                            <a href="home/search?keyword=${keyword}&pageIndex=${lucenePageInfo.pageNum-1}"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach items="${lucenePageInfo.navigatepageNums}" var="n">
                        <li class="${lucenePageInfo.pageNum==n?'active':''}"><a
                                href="${pageContext.request.contextPath}/home/search?keyword=${keyword}&pageIndex=${n}">${n}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${lucenePageInfo.hasNextPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/home/search?keyword=${keyword}&pageIndex=${lucenePageInfo.pageNum+1}"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>
        <%@include file="../Common/right_page.jsp" %>
    </div>
</div>
<%@ include file="../Common/footer.jsp" %>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/myscript.js"></script>
<script type="text/javascript">

</script>
</html>

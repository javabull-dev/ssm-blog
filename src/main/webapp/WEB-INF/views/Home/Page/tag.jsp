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
                    <h5>文章所属标签:
                        <c:if test="${pageInfo.list[0].tags[0].tagContent!=null}">
                            ${pageInfo.list[0].tags[0].tagContent}
                        </c:if>
                        <c:if test="${pageInfo.list[0].tags[0].tagContent==null}">
                            无
                        </c:if>
                    </h5>
                </div>
            </div>
            <!--文章列表-->
            <div>
                <c:forEach items="${pageInfo.list}" var="a">
                    <div class="media panel panel-background" style="margin-top: 20px;min-height: 180px">
                        <div class="media-left media-middle media-head">
                            <img class="media-object" src="${a.articleImageUrl}" alt=""
                                 style="height: 100px;width: 166px">
                        </div>
                        <div class="media-body">
                            <div class="media-body-style">
                                <b>
                                    <span class="glyphicon glyphicon-calendar"></span>
                                    <fmt:formatDate value="${a.articleCreateTime}" pattern="yyyy-MM-dd"/>
                                </b>
                                <b><span
                                        class="glyphicon glyphicon-eye-open"></span>${a.articleReadAmount}</b>
                                <c:forEach items="${a.tags}" var="t">
                                    <b><span class="glyphicon glyphicon-tag"></span>${t.tagContent}</b>
                                </c:forEach>
                                <h4 class="media-heading"><a href="/article/${a.articleId}">${a.articleTitle}</a></h4>
                                <p style="margin-right: 5px">${a.articleSummary} ...</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <!--分页-->
            <nav aria-label="Page navigation" class="text-center">
                <ul class="pagination">
                    <c:if test="${pageInfo.pageNum ne 1}">
                        <li>
                            <a href="/tag/${tagId}?index=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="n">
                        <li class="${pageInfo.pageNum==n?'active':''}"><a href="/category/${tagId}?index=${n}">${n}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="/category/${tagId}?index=${pageInfo.pageNum+1}" aria-label="Next">
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
<script type="text/javascript" src="/statics/js/myscript.js"></script>
</html>

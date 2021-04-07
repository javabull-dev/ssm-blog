<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
<%--静态包含--%>
<%@include file="../Common/head.jsp" %>
<body>
<%@include file="../Common/nav.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <!--归档内容-->
            <div class="panel">
                <div class="panel-body panel-achieve">
                    <h2>${pageToken=='achieve'?'文章归档':''}</h2>
                    <ul><hr/>
                        <c:forEach items="${articles}" var="article" >
                            <li>
                                <a href="/article/${article.articleId}" style="font-family: 'Tempus Sans ITC';font-size: 16px"><fmt:formatDate
                                        value="${article.articleCreateTime}" pattern="yyyy-MM-dd"/>
                                    &nbsp;${article.articleTitle}</a>
                            </li>
                        </c:forEach>
                        <%--                        <li>2019年--%>
                        <%--                            <hr/>--%>
                        <%--                            <ul>--%>
                        <%--                                <li>12月--%>
                        <%--                                    <ul>--%>
                        <%--                                        <li>--%>
                        <%--                                            <a href="#">12-23 PUT请求引发的一次血案</a>--%>
                        <%--                                        </li>--%>
                        <%--                                        <li>--%>
                        <%--                                            <a href="#">12-13 ajax怎么写</a>--%>
                        <%--                                        </li>--%>
                        <%--                                        <li>--%>
                        <%--                                            <a href="#">12-05 Java书单推荐</a>--%>
                        <%--                                        </li>--%>
                        <%--                                        <li>--%>
                        <%--                                            <a href="#">12-01 啊，狗剩，你再说这个bug是我写的信不信我抽你!</a>--%>
                        <%--                                        </li>--%>
                        <%--                                    </ul>--%>
                        <%--                                </li>--%>
                        <%--                            </ul>--%>
                        <%--                        </li>--%>
                    </ul>
                </div>
            </div>
        </div>
        <%@include file="../Common/right_page.jsp" %>
    </div>
</div>
<%@ include file="../Common/footer.jsp" %>
</body>
<script type="text/javascript" src="/statics/js/myscript.js"></script>
</html>

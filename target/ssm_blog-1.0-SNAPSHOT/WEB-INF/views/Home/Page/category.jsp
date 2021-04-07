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
            <!--文章列表-->
            <div class="media panel" id="title"></div>
            <div id="articlelist"></div>
            <!--分页-->
            <nav aria-label="Page navigation" class="text-center" id="page"></nav>
        </div>
        <%@include file="../Common/right_page.jsp" %>
    </div>
</div>
<%@ include file="../Common/footer.jsp" %>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/plugin/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/myscript.js"></script>
<script type="text/javascript">
    get_article_category(1, ${categoryId});
</script>
</html>

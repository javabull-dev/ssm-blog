<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jacker
  Date: 2020/6/24
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" language="java" %>
<div class="col-md-4">
    <div class="panel panel-default">
        <div class="panel-body panel-body-font">
            <span class="glyphicon glyphicon-send"></span> 我的踪迹
        </div>
        <div class="panel-footer panel-footer-background">
            <c:forEach items="${links}" var="l" varStatus="status">
                <c:if test="${status.index%3==0}">
                    <div class="col">
                </c:if>
                <a href="${l.linkUrl}" target="_blank">
                    <img src="${l.linkAvatarUrl}" style="width: 40px;height: 40px;"/>
                    <p>${l.linkTitle}</p>
                </a>
                <c:if test="${status.index%3==2 || status.last}">
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-body panel-body-font">
            <span class="glyphicon glyphicon-file"></span> 文章分类
        </div>
        <div class="panel-footer panel-footer-background">
            <ul class="list-group">
                <c:forEach items="${categoryParams}" var="c">
                    <li class="list-group-item li-content box">
                        <a href="/category/${c.category.categoryId}">
                            <span class="glyphicon glyphicon-book"></span> ${c.category.categoryName}
                        </a>
                        <span class="badge" style="background: #28A4C9;">${c.articleCount}</span>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="panel panel-default ">
        <div class="panel-body panel-body-font">
            <span class="glyphicon glyphicon-tag"></span> 标签云
        </div>
        <div class="panel-footer panel-footer-background">
            <c:forEach items="${tags}" var="t" varStatus="status">
                <c:if test="${status.index%6==0}">
                    <div class="tag-cloud">
                </c:if>
                <a href="/tag/${t.tagId}">${t.tagContent}</a>
                <c:if test="${status.index%6==5 || status.last}">
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="panel panel-default ">
        <div class="panel-body panel-body-font">
            <span class="glyphicon glyphicon-link"></span> 友情链接
        </div>
        <div class="panel-footer panel-footer-background friend-link">
            <c:forEach items="${friendLinks}" var="f">
                <a href="${f.linkUrl}" target="_blank">${f.linkName}</a>
            </c:forEach>
        </div>
    </div>
</div>
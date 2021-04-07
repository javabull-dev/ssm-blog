<%--
  Created by IntelliJ IDEA.
  User: Jacker
  Date: 2020/6/24
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-collapse nav-color">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">${option.optionTitle}</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right nav-item">
                <li><a href="${pageContext.request.contextPath}/goto">登录</a></li>
                <li><a href="#">注册</a></li>
            </ul>
            <form class="navbar-form navbar-right" method="post"
                  action="${pageContext.request.contextPath}/home/search">
                <div class="form-group">
                    <input type="text" name="keyword" required id="keyword-btn" class="form-control"
                           placeholder="站内搜索" style="width: 300px;">
                </div>
                <button type="submit" class="btn btn-group-sm btn-info">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                </button>
            </form>
            <ul class="nav navbar-nav navbar-right nav-item">
                <li>
                    <a href="${pageContext.request.contextPath}/about"
                       class="${requestScope.get("pageToken")=='about'?'active-a':''}">
                        <span class="glyphicon glyphicon-object-align-vertical"></span>关于
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right nav-item">
                <li>
                    <a href="${pageContext.request.contextPath}/achieve"
                       class="${requestScope.get("pageToken")=='achieve'?'active-a':''}">
                        <span class="glyphicon glyphicon-th-list"></span>归档
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right nav-item">
                <li>
                    <a href="${pageContext.request.contextPath}/home"
                       class="${requestScope.get("pageToken")=='home'?'active-a':''}">
                        <span class="glyphicon glyphicon-home"></span>首页
                    </a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
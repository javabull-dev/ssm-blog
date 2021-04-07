<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<%--    <link rel="shortcut icon" href="/img/logo.png">--%>
    <title>
        ${options.optionTitle}后台系统
            <rapid:block name="title"></rapid:block>
    </title>
    <link rel="stylesheet" href="/statics/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="/statics/css/back.css">
    <link rel="stylesheet" href="/statics/plugin/font-awesome/css/font-awesome.min.css">
    <rapid:block name="header-style"></rapid:block>
    <rapid:block name="header-script"></rapid:block>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><a href="/admin" style="color:#009688;">
        超级博客管理系统
        </a>
        </div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="/" target="_blank">跳转至前台</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">添加</a>
                <dl class="layui-nav-child">
                    <dd><a href="/admin/article/insert">文章</a></dd>
<%--                    <dd><a href="/admin/">页面</a></dd>--%>
                    <dd><a href="/admin/friendlink/insert">友链</a></dd>
                    <dd><a href="/admin/category">分类</a></dd>
                    <dd><a href="/admin/notice/insert">公告</a></dd>
                    <dd><a href="/admin/link/insert">链接</a></dd>
                    <dd><a href="/admin/tag">标签</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${sessionScope.userAvatarUrl}" class="layui-nav-img">
                    ${sessionScope.userName}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="/admin/user/profile">基本资料</a></dd>
                    <dd><a href="/admin/logout">登出</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">文章</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/article">全部文章</a></dd>
                        <dd><a href="/admin/article/insert">添加文章</a></dd>
                        <dd><a href="/admin/category">全部分类</a></dd>
                        <dd><a href="/admin/tag">全部标签</a></dd>
                        <dd><a href="/admin/screen">全部大幕</a></dd>
                    </dl>
                </li>
<%--                <li class="layui-nav-item">--%>
<%--                    <a href="javascript:;">页面</a>--%>
<%--                    <dl class="layui-nav-child">--%>
<%--                        <dd><a href="/admin/page">全部页面</a></dd>--%>
<%--                        <dd><a href="/admin/page/insert">添加页面</a></dd>--%>
<%--                    </dl>--%>
<%--                </li>--%>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">
                        友链
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/friendlink">全部友链</a></dd>
                        <dd><a href="/admin/friendlink/insert">添加友链</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">公告</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/notice">全部公告</a></dd>
                        <dd><a href="/admin/notice/insert">添加公告</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="/admin/comment">
                        评论
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">
                        用户
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/user">全部用户</a></dd>
                        <dd><a href="/admin/user/insert">添加用户</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">
                        链接
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/link">全部链接</a></dd>
                        <dd><a href="/admin/link/insert">添加链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">设置</a>
                    <dl class="layui-nav-child">
<%--                        <dd><a href="/admin/menu">菜单</a></dd>--%>
                        <dd><a href="/admin/options">主要选项</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <rapid:block name="content">

            </rapid:block>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 2020 All Rights Reserved.
    </div>
</div>

<script src="/statics/js/jquery.min.js"></script>
<script src="/statics/plugin/layui/layui.all.js"></script>
<script src="/statics/js/back.js"></script>
<rapid:block name="footer-script">

</rapid:block>
<script>
    //给文本编辑器的iframe引入代码高亮的css
    $("iframe").contents().find("head").append("<link rel=\"stylesheet\" href=\"/statics/css/highlight.css\">\n");

</script>

</body>
</html>

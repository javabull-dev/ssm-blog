<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

    <rapid:override name="title">
        - 编辑标签
    </rapid:override>
<rapid:override name="header-style">
    <style>
        /*覆盖 layui*/
        .layui-input-block {
            margin:0px 10px;
        }
        .layui-table {
            margin-top: 0;
        }
        .layui-col-md4 {
            padding:10px;
        }
        .layui-col-md8 {
            padding:10px;
        }
        .layui-btn {
            margin: 2px 0!important;
        }
    </style>
</rapid:override>

<rapid:override name="content">

    <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
              <a href="/admin">首页</a>
              <a href="/admin/tag">标签列表</a>
              <a><cite>编辑标签</cite></a>
        </span>
    </blockquote>
    <div class="layui-row">
        <div class="layui-col-md4" >
            <form class="layui-form" method="post" id="myForm">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <strong>编辑标签</strong>
                    </div>
                    <input type="hidden" name="tagId" value="${tag.tagId}">
                    <div class="layui-input-block">
                        名称 <span style="color: #FF5722; ">*</span>
                        <input type="hidden" name="copyTagContent" value="${tag.tagContent}"/>
                        <input type="text" name="tagName" value="${tag.tagContent}" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-filter="formDemo" type="submit">保存</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="layui-col-md8">

            <table class="layui-table">
                <colgroup>
                    <col width="300">
                    <col width="50">
                    <col width="100">
                    <col width="50">
                </colgroup>
                <thead>
                <tr>
                    <th>名称</th>
                    <th>文章数</th>
                    <th>操作</th>
                    <th>ID</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${tagWarps}" var="tagWarp">
                    <tr>
                        <td>
                            <a href="/tag/${tagWarp.tag.tagId}" target="_blank">${tagWarp.tag.tagContent}</a>
                        </td>
                        <td>
                            <a href="/tag/${tagWarp.tag.tagId}" target="_blank" lay-data="{sort:true}">${tagWarp.articleCount}</a>
                        </td>
                        <td>
                            <a href="/admin/tag/edit/${tagWarp.tag.tagId}" class="layui-btn layui-btn-xs">编辑</a>
                            <c:if test="${tagWarp.articleCount==0}">
                                <a href="/admin/tag/delete/${tagWarp.tag.tagId}" class="layui-btn layui-btn-danger layui-btn-xs"
                                   onclick="return confirmDelete()">删除</a>
                            </c:if>
                        </td>
                        <td>${tagWarp.tag.tagId}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>如果该标签包含文章，将不可删除</li>
                </ul>
            </blockquote>
        </div>
    </div>
</rapid:override>
<rapid:override name="footer-script">
    <script>
        layui.use(['form', 'layedit', 'laydate'], function () {
            var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate;

            $(":submit").click(function () {
                $.ajax({
                    async: true,
                    type:"POST",
                    url:"/admin/tag/editSubmit",
                    data:$("#myForm").serialize(),
                    success:function (result) {
                        alert(result.msg);
                        if (result.code==100){
                            window.location.href="/admin/category";
                        }
                    }
                });
                return false;
            });
        });
    </script>
</rapid:override>

<%@ include file="../common/framework.jsp"%>

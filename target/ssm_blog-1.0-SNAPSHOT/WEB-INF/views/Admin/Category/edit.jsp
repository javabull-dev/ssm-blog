<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="title">
    - 分类列表
</rapid:override>
<rapid:override name="header-style">
    <style>
        .layui-input-block {
            margin: 0px 10px;
        }
    </style>
</rapid:override>

<rapid:override name="content">


    <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
              <a href="/admin">首页</a>
              <a href="/admin/category">分类列表</a>
              <a><cite>编辑分类</cite></a>
        </span>
    </blockquote>
    <div class="layui-row">
        <div class="layui-col-md4">
            <form class="layui-form" method="post" id="myForm">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <strong>修改分类</strong>
                    </div>
                    <div class="layui-input-block">
                        名称 <span style="color: #FF5722; ">*</span>
                        <input type="hidden" name="categoryId" value="${category.categoryId}">
                        <input type="text" name="categoryName" placeholder="请输入分类名称" autocomplete="off"
                               value="${category.categoryName}"
                               class="layui-input" required>
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
                    <col width="100">
                    <col width="100">
                    <col width="100">
                    <col width="50">
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
                <c:forEach items="${allCategoryWarps}" var="categoryWarp">
                    <tr>
                        <td>
                            <a href="/category/${categoryWarp.category.categoryId}"
                               target="_blank">${categoryWarp.category.categoryName}</a>
                        </td>
                        <td>
                            <a href="/category/${categoryWarp.category.categoryId}"
                               target="_blank">${categoryWarp.articleCount}</a>
                        </td>
                        <td>
                            <a href="/admin/category/edit/${categoryWarp.category.categoryId}"
                               class="layui-btn layui-btn-xs">编辑</a>
                            <c:if test="${categoryWarp.articleCount==0}">
                                <a href="/admin/category/delete/${categoryWarp.category.categoryId}"
                                   class="layui-btn layui-btn-danger layui-btn-xs"
                                   onclick="return confirmDelete()">删除</a>
                            </c:if>
                        </td>
                        <td>${categoryWarp.category.categoryId}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>如果该分类包含文章，将不可删除</li>
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
                    url:"/admin/category/editSubmit",
                    data:$("#myForm").serialize(),
                    success:function (result) {
                        var str = "更新失败,请重试!";
                        if (result.code==100){
                            str = "更新成功!";
                        }
                        alert(str);
                        window.location.href="/admin/category";
                    }
                });
                return false;
            });
        });
    </script>
</rapid:override>

<%@ include file="../common/framework.jsp" %>

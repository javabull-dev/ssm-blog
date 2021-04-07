<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

    <rapid:override name="title">
        - 链接列表
    </rapid:override>
<rapid:override name="header-style">
    <style>
        /*覆盖 layui*/

        .layui-table {
            margin-top: 0;
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
              <a><cite>链接列表</cite></a>
        </span>
    </blockquote>

    <table class="layui-table" >
        <colgroup>
            <col width="100">
            <col width=50">
            <col width="100">
            <col width="100">
            <col width="50">
            <col width="50">
            <col width="100">
            <col width="50">
        </colgroup>
        <thead>
        <tr>
            <th>名称</th>
            <th>URL</th>
            <th>内容</th>
            <th>创建时间</th>
            <th>Order</th>
            <th>状态</th>
            <th>操作</th>
            <th>ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${links}" var="l">
            <tr>
                <td>
                    <img src="${l.linkAvatarUrl}" width="48" height="48">
                    <strong><a href="/admin/user/edit/${l.linkId}">${l.linkTitle}</a></strong>
                </td>
                <td >
                    <a href="${l.linkUrl}" target="_blank">${l.linkUrl}</a>
                </td>
                <td>
                    ${l.linkContent}
                </td>
                <td>
                      <fmt:formatDate value="${l.linkCreateTime}" pattern="yyyy-MM-dd"/>
                </td>
                <td>
                    ${l.linkOrder}
                </td>
                <td>
                    <c:choose>
                        <c:when test="${l.linkStatus==1}">
                            显示
                        </c:when>
                        <c:otherwise>
                            <span style="color:#FF5722;">隐藏</span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="/admin/link/edit/${l.linkId}" class="layui-btn layui-btn-xs">编辑</a>
                    <a linkId="${l.linkId}" class="layui-btn layui-btn-danger layui-btn-xs">删除</a>
                </td>
                <td>${l.linkId}</td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

</rapid:override>
<rapid:override name="footer-script">
    <script>
        layui.use(['form', 'layedit', 'laydate'], function () {
            var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate;

            $(".layui-btn-danger").click(function (index) {
                var linkId = $(this).attr("linkId");
                layer.confirm('是否要将id为' + linkId + '的链接刪除?', {
                    title: '提示'
                }, function (index) {
                    layer.close(index);
                    $.ajax({
                        async: true,
                        type:"POST",
                        url:"/admin/link/delete/"+linkId,
                        success:function (result) {
                            alert(result.msg);
                            if (result.code==100){
                                window.location.href="/admin/link";
                            }
                        }
                    });
                });
            });
        });
    </script>
</rapid:override>

<%@ include file="../common/framework.jsp"%>



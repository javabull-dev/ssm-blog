<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

    <rapid:override name="title">
        - 编辑友链
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
              <a href="/admin/friendlink">友链列表</a>
              <a><cite>编辑友链</cite></a>
        </span>
    </blockquote>
    <div class="layui-row">
        <div class="layui-col-md4">
            <form class="layui-form" method="post" id="myForm">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <strong>编辑</strong>
                    </div>
                    <input type="hidden" name="linkId" value="${friendLink.linkId}">
                    <div class="layui-input-block">
                        名称 <span style="color: #FF5722; ">*</span>
                        <input type="hidden" name="copyLinkName" value="${friendLink.linkName}">
                        <input type="text" name="linkName" value="${friendLink.linkName}" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        URL  <span style="color: #FF5722; ">*</span>
                        <input type="text" name="linkUrl" value="${friendLink.linkUrl}" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        联系方式
                        <input type="text" name="linkEmail" value="${friendLink.linkEmail}" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        描述
                        <input type="text" name="linkDescription" value="${friendLink.linkDescription}" autocomplete="off" class="layui-input" >
                    </div>

                    <br>
                    <div class="layui-input-block">
                         Order
                        <input type="number" name="linkOrder" value="${friendLink.linkOrder}" autocomplete="off" class="layui-input" min="0" max="10">
                    </div>
                    <br>
                    <div class="layui-input-block">
                        状态 <br>
                        <input type="radio" name="linkStatus" value="1" title="显示" <c:if test="${friendLink.linkStatus==1}">checked</c:if>>
                        <input type="radio" name="linkStatus" value="0" title="隐藏" <c:if test="${friendLink.linkStatus==0}">checked</c:if>>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-filter="formDemo" type="submit">保存</button>
                    </div>
                </div>
            </form>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>URL：如 http://example.com</li>
                    <li>Order：默认是0，Order越大排名越靠前</li>
                </ul>
            </blockquote>
        </div>
        <div class="layui-col-md8">
            <table class="layui-table" >
                <colgroup>
                    <col width="50">
                    <col width="300">
                    <col width="100">
                    <col width="50">
                    <col width="100">
                </colgroup>
                <thead>
                <tr>
                    <th>id</th>
                    <th>名称</th>
                    <th>URL</th>
                    <th>Order</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${friendLinks}" var="l">
                    <tr>
                        <td>${l.linkId}</td>
                        <td>
                            ${l.linkName}
                        </td>
                        <td>
                             ${l.linkUrl}
                        </td>
                        <td>
                            ${l.linkOrder}
                        </td>
                        <td>
                            <a href="/admin/friendlink/edit/${l.linkId}" class="layui-btn layui-btn-xs">编辑</a>
                            <a linkId="${l.linkId}" class="layui-btn layui-btn-danger layui-btn-xs">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

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

            $(".layui-btn-danger").click(function (index) {
                var linkId = $(this).attr("linkId");
                layer.confirm('是否要将id为' + linkId + '的友链刪除?', {
                    title: '提示'
                }, function (index) {
                    layer.close(index);
                    $.ajax({
                        async: true,
                        type:"POST",
                        url:"/admin/friendlink/delete/"+linkId,
                        success:function (result) {
                            alert(result.msg);
                            if (result.code==100){
                                window.location.href="/admin/friendlink";
                            }
                        }
                    });
                });
            });

            $(":submit").click(function () {
                $.ajax({
                    url:"/admin/friendlink/editSubmit",
                    type:"POST",
                    data: $("#myForm").serialize(),
                    success:function (result) {
                        alert(result.msg);
                    }
                });
                return false;
            });
        });
    </script>
</rapid:override>

<%@ include file="../common/framework.jsp"%>

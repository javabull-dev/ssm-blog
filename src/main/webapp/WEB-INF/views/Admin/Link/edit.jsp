<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="title">
    - 编辑链接
</rapid:override>
<rapid:override name="header-style">
    <style>
        .layui-form-item .layui-input-inline {
            width: 300px;
        }

        .layui-word-aux {
            color: #FF5722 !important;
        }
    </style>
</rapid:override>

<rapid:override name="content">

    <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
              <a href="/admin">首页</a>
              <a href="/admin/link">链接列表</a>
              <a><cite>编辑链接</cite></a>
        </span>
    </blockquote>
    <form class="layui-form" id="linkForm">
        <input type="hidden" name="linkId" id="linkId" value="${link.linkId}">
        <div class="layui-form-item">
            <label class="layui-form-label">图标</label>
            <div class="layui-input-inline">
                <div class="layui-upload">
                    <div class="layui-upload-list" style="">
                        <img class="layui-upload-img" src="${link.linkAvatarUrl}" id="demo1" width="100"
                             height="100">
                        <p id="demoText"></p>
                    </div>
                    <button type="button" class="layui-btn" id="test1">上传图片</button>
                    <input type="hidden" name="linkAvatarUrl" id="linkAvatarUrl" value="${link.linkAvatarUrl}">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">链接名 <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-inline">
                <input type="hidden" value="${link.linkTitle}" name="copyLinkTitle">
                <input type="text" value="${link.linkTitle}" name="linkTitle" id="linkTitle" required
                       lay-verify="userName"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux" id="linkTitleTips"></div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">描述 <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-inline">
                <input type="text" value="${link.linkContent}" name="linkContent" id="linkContent" required
                       lay-verify="userName"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux" id="linkContentTips"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">URL <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-inline">
                <input type="text" name="linkUrl" value="${link.linkUrl}" id="linkUrl" required
                       autocomplete="off" class="layui-input" min="3" max="20" lay-verify="linkUrl">
            </div>
            <div class="layui-form-mid layui-word-aux"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">Order </label>
            <div class="layui-input-inline">
                <input type="number" name="linkOrder" value="${link.linkOrder}" autocomplete="off"
                       min="0" max="10" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <input type="radio" name="linkStatus" value="1" title="正常"
                       <c:if test="${link.linkStatus==1}">checked</c:if>  >
                <input type="radio" name="linkStatus" value="0" title="禁用"
                       <c:if test="${link.linkStatus==0}">checked</c:if>  >
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="demo1" id="submit-btn">保存</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

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
                        type: "POST",
                        url: "/admin/link/delete/" + linkId,
                        success: function (result) {
                            alert(result.msg);
                            if (result.code == 100) {
                                window.location.href = "/admin/link";
                            }
                        }
                    });
                });
            });

            $("#submit-btn").click(function () {
                $.ajax({
                    url: "/admin/link/editSubmit",
                    type: "POST",
                    data: $("#linkForm").serialize(),
                    success: function (result) {
                        alert(result.msg);
                        if (result.code == 100) {
                            window.location.reload();
                        }
                    }
                });
                return false;
            });
        });
    </script>
</rapid:override>

<%@ include file="../common/framework.jsp" %>

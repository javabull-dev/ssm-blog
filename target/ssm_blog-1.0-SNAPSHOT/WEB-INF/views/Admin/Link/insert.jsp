<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="title">
    - 添加链接
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
              <a><cite>添加链接</cite></a>
        </span>
    </blockquote>
    <form class="layui-form" id="linkForm" method="post" action="/admin/link/insertSubmit">
        <div class="layui-form-item">
            <input type="hidden" id="linkId" value="0">
            <label class="layui-form-label">图标</label>
            <div class="layui-input-inline">
                <div class="layui-upload">
                    <div class="layui-upload-list" style="">
                        <img class="layui-upload-img" src="" id="demo1" width="100"
                             height="100">
                        <p id="demoText"></p>
                    </div>
                    <button type="button" class="layui-btn" id="test1">上传图片</button>
                </div>
            </div>
            <input type="hidden" name="linkAvatarUrl" id="linkAvatarUrl" value="">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">链接名 <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-inline">
                <input type="text" name="linkTitle" id="linkTitle" required
                       autocomplete="off" class="layui-input" lay-verify="linkTitle">
            </div>
            <div class="layui-form-mid layui-word-aux" id="linkNameTips"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">描述 <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-inline">
                <input type="text" name="linkContent" id="linkContent" required class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">URL </label>
            <div class="layui-input-inline">
                <input type="url" name="linkUrl" placeholder="" id="linkUrl"
                       class="layui-input" onblur="checkInputUrl(this)" lay-verify="linkUrl">
                <div class="layui-form-mid layui-word-aux"></div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <input type="radio" name="linkStatus" value="1" title="正常" checked="checked">
                <input type="radio" name="linkStatus" value="0" title="禁用">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">Order </label>
            <div class="layui-input-inline">
                <input type="number" name="linkOrder" value="" autocomplete="off"
                       min="0" max="10" class="layui-input">
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
        //上传图片
        layui.use('upload', function () {
            var $ = layui.jquery,
                upload = layui.upload;
            var uploadInst = upload.render({
                elem: '#test1',
                url: '/admin/upload/img',
                before: function (obj) {
                    obj.preview(function (index, file, result) {
                        //本地预览
                        $('#demo1').attr('src', result);
                    });
                },
                done: function (result) {
                    $("#linkAvatarUrl").attr("value", result.extend.fileUrl);
                    if (result.code != 100) {
                        return layer.msg(result.msg);
                    }
                },
                error: function () {
                    var demoText = $('#demoText');
                    demoText.html('' +
                        '<span style="color: #FF5722;">上传失败</span>' +
                        ' <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                    demoText.find('.demo-reload').on('click', function () {
                        uploadInst.upload();
                    });
                }
            });

            // $("#submit-btn").click(function () {
            //     //校验数据
            //     var linkTitle = $("#linkTitle").val();
            //     var regTitle = /^[a-z0-9A-Z\u2E80-\u9FFF]{2,16}$/;
            //     var linkUrl = $("#linkUrl").val();
            //     if (!regUrl.test(linkUrl)){
            //         alert("输入URL不合法!");
            //         return false;
            //     }
            //     $.ajax({
            //         url: "/admin/link/insertSubmit",
            //         type: "POST",
            //         data: $("#linkForm").serialize(),
            //         success: function (result) {
            //             alert(result.msg);
            //             if (result.code == 100) {
            //                 window.location.reload();
            //             }
            //         }
            //     });
            //     return false;
            // });
        });
    </script>
</rapid:override>

<%@ include file="../common/framework.jsp" %>

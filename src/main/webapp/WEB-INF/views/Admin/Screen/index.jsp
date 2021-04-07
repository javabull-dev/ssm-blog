<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="title">
    - 标签列表
</rapid:override>
<rapid:override name="header-style">
    <style>
        /*覆盖 layui*/
        .layui-input-block {
            margin: 0px 10px;
        }

        .layui-table {
            margin-top: 0;
        }

        .layui-col-md4 {
            padding: 10px;
        }

        .layui-col-md8 {
            padding: 10px;
        }

        .layui-btn {
            margin: 2px 0 !important;
        }
    </style>
</rapid:override>

<rapid:override name="content">

    <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
              <a href="/admin">首页</a>
              <a><cite>大幕列表</cite></a>
        </span>
    </blockquote>
    <div class="layui-row">
        <div class="layui-col-md4">
            <form class="layui-form" method="post" id="myForm" action="/admin/screen/insertSubmit">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <strong>添加大幕</strong>
                    </div>
                    <div class="layui-input-block">
                        名称 <span style="color: #FF5722; ">*</span>
                        <input type="text" name="screenImgName" autocomplete="off" class="layui-input" required>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        图片 <span style="color: #FF5722; ">*</span>
                        <div class="layui-upload">
                            <div class="layui-upload-list" style="">
                                <img class="layui-upload-img" src="" id="demo1"
                                     height="100">
                                <p id="demoText"></p>
                            </div>
                            <button type="button" class="layui-btn" id="test1">上传图片</button>
                        </div>
                    </div>
                    <input type="hidden" name="screenImgUrl" id="screenImgUrl" value="">
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        order<span style="color: #FF5722; ">*</span>
                        <input type="number" name="screenOrder" value="5" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        关联文章ID<span style="color: #FF5722;">*</span>
                        <input type="number" name="articleId" value="5" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        状态<span style="color: #FF5722; ">*</span>
                        <input type="radio" name="screenStatus" value="1" title="显示" checked>
                        <input type="radio" name="screenStatus" value="0" title="隐藏">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="demo1" id="submit-btn">保存</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>1、大幕名勿重复</li>
                    <li>2、Order越大，大幕显示越靠前</li>
                </ul>
            </blockquote>
        </div>
        <div class="layui-col-md8">

            <table class="layui-table">
                <colgroup>
                    <col width="150">
                    <col width="200">
                    <col width="100">
                    <col width="50">
                </colgroup>
                <thead>
                <tr>
                    <th>大幕名称</th>
                    <th>URL</th>
                    <th>操作</th>
                    <th>对应文章ID</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${tagWarps}" var="tagWarp">
                    <tr>
                        <td>
                            <a href="/tag/${tagWarp.tag.tagId}" target="_blank">${tagWarp.tag.tagContent}</a>
                        </td>
                        <td>
                            <a href="/tag/${tagWarp.tag.tagId}" target="_blank"
                               lay-data="{sort:true}">${tagWarp.articleCount}</a>
                        </td>
                        <td>
                            <a href="/admin/tag/edit/${tagWarp.tag.tagId}" class="layui-btn layui-btn-xs">编辑</a>
                            <c:if test="${tagWarp.articleCount==0}">
                                <a href="/admin/tag/delete/${tagWarp.tag.tagId}"
                                   class="layui-btn layui-btn-danger layui-btn-xs"
                                   onclick="return confirmDelete()">删除</a>
                            </c:if>
                        </td>
                        <td>${tagWarp.tag.tagId}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <blockquote class="layui-elem-quote layui-quote-nm">
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

            $("#submit-btn").click(function () {
                $.ajax({
                    async: true,
                    type: "POST",
                    url: "/admin/screen/insertSubmit",
                    data: $("#myForm").serialize(),
                    success: function (result) {
                        var str = "更新失败,请重试!";
                        if (result.code == 100) {
                            str = "更新成功!";
                        }
                        alert(str);
                        window.location.href = "/admin/category";
                    }
                });
                return false;
            });
        });

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
                    $("#screenImgUrl").attr("value", result.extend.fileUrl);
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
        });
    </script>
</rapid:override>

<%@ include file="../common/framework.jsp" %>

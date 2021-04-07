function DoCheck() {
    var ch = document.getElementsByName("ids");
    if (document.getElementById("allSelect").checked == true) {
        for (var i = 0; i < ch.length; i++) {
            ch[i].checked = true;
        }
    } else {
        for (var i = 0; i < ch.length; i++) {
            ch[i].checked = false;
        }
    }
}

function confirmDelete() {
    var msg = "您确定要删除吗？";
    if (confirm(msg) == true) {
        return true;
    } else {
        return false;
    }
}

//获取相对路径
function getPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0, index + 1);
    return result;
}

//显示和隐藏row-actions
$(".dashboard-comment-wrap").mouseenter(function () {
    $(this).find(".row-actions").show();
});
$(".dashboard-comment-wrap").mouseleave(function () {
    $(this).find(".row-actions").hide();
});

//删除评论
function deleteComment(id) {
    if (confirmDelete() == true) {
        $.ajax({
            async: false,
            type: "POST",
            url: '/admin/comment/delete/' + id,
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            dataType: "text",
            complete: function () {
                window.location.reload();
            }
        })
    }
}

//添加草稿
function insertDraft() {
    if ($("#articleContent").val != "" && $("#articleTitle").val() != "") {
        $.ajax({
            async: false,
            type: "POST",
            url: '/admin/article/insert',
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            dataType: "text",
            complete: function () {
                window.location.reload();
            }
        })
    }

}


//查询文章
function queryArticle() {
    //提交form
    $("#articleForm").attr("action", "/admin/article/search");
    $("#articleForm").submit();
}

function checkUrl(url) {
    var regUrl = /^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/;
    return regUrl.test(url);
}

function checkInputUrl(elem) {
    var value = $(elem).val();
    if (!checkUrl(value)) {
        $(elem).next().html("非法URL!");
    } else {
        $(elem).next().empty();
    }
}

function verifyUrl() {
    var url = $("#linkUrl").val();
    return checkUrl(url);
}

function checkLinkTitle() {
    var result;
    var title = $("#linkTitle").val().trim();
    $.ajax({
        url: "/admin/link/checkLinkTitle",
        type: "POST",
        data: "title=" + title,
        success: function (data) {
            result = data;
            if (data.code != 100) {
                $("#linkTitle").next().html(data.msg);
            } else {
                $("#linkTitle").next().empty();
            }
        }
    });
    return result;
}

//添加用户检查用户名是否存在
function checkUserName() {
    var result;
    $.ajax({
        async: false,//同步，待请求完毕后再执行后面的代码
        type: "POST",
        url: '/admin/user/checkUserName',
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: {"username": $("#userName").val(), "id": $("#userId").val()},
        dataType: "json",
        success: function (data) {
            //用户名存在
            if (data.code == 1) {
                $("#userNameTips").html(data.msg);
                result = 1;
            }
            //用户名不存在
            if (data.code == 0) {
                $("#userNameTips").html(data.msg);
                result = 0;
            }
        },
        error: function () {
            // alert("数据获取失败")
        }
    });
    return result;
}

//添加用户检查电子邮箱是否存在
function checkUserEmail() {
    var result;
    $.ajax({
        async: false,//同步，待请求完毕后再执行后面的代码
        type: "POST",
        url: '/admin/user/checkUserEmail',
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: {"email": $("#userEmail").val(), "id": $("#userId").val()},
        dataType: "json",
        success: function (data) {
            //用户名存在
            if (data.code == 1) {
                $("#userEmailTips").html(data.msg);
                result = 1;
            }
            //用户名不存在
            if (data.code == 0) {
                $("#userEmailTips").html(data.msg);
                result = 0;
            }
        },
        error: function () {
            //alert("数据获取失败")
        }
    });
    return result;
}

//添加用户验证和编辑用户验证
layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form, layer = layui.layer;
    form.verify({
        userName: function (value) {
            if (value.length > 12 || value.length < 4) {
                return "用户名必须4到12位";
            }
            if (checkUserName() == 1) {
                return "用户名已存在";
            }
        },
        userEmail: function () {
            if (checkUserEmail() == 1) {
                return "电子邮箱已存在";
            }
        },
        linkUrl: function () {
            if (!verifyUrl()) {
                return "输入的URL非法!";
            }
        },
        linkTitle: function () {
            var resutl = checkLinkTitle();
            if (resutl.code != 100) {
                return resutl.msg;
            }
        }
    });

    form.on('submit(demo1)', function (data) {
        return true;
    });
});
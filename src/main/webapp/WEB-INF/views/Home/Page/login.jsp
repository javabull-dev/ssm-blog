<%--
  Created by IntelliJ IDEA.
  User: Jacker
  Date: 2020/5/23
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>博客登入</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="statics/plugin/bootstrap-3.3.7/css/bootstrap-theme.css" />
    <link rel="stylesheet" type="text/css" href="statics/plugin/bootstrap-3.3.7/css/bootstrap.css" />
    <script type="text/javascript" src="statics/plugin/jQuery/jquery-3.5.1.js"></script>
    <script src="statics/plugin/bootstrap-3.3.7/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        $(function() {
            $(":submit").click(function() {
                var username = $(":text").val();
                var passwd = $(":password").val();
                if (username == "") {
                    createAtip("用户名不能为空");
                    return false;
                }
                if (passwd == "") {
                    createAtip("密码不能为空");
                    return false;
                }

                //在网络不通畅的情况下,用户可能多次提交表单
                // 使submit按钮禁止再次按下
                $(":submit").disable();
                return true;
            });
            //监听enter事件
            $(document).keydown(function(event) {
                if (event.keyCode == 13) {
                    $(":submit").trigger("click");
                }
            });

            //提示错误信息
            <%
                String errorMsg = (String)request.getAttribute("errorMsg");
                if (errorMsg!=null){
            %>
            createAtip("用户名或密码错误");
            <%
                }
            %>
            function createAtip(str) {
                $("<div class='alert alert-dismissible in fade box'><a class='close' data-dismiss='alert'>×</a><strong>"
                    + str
                    + "</strong></div>").appendTo($("#tip"));
            }
        })
    </script>
    <style type="text/css">
        body {
            background: url(statics/images/background/login-background.png) no-repeat center center fixed;
            font-family: Helvetica;
            background-size: cover;
            /*transition: background-image .5s linear .5s;*/
        }

        .login form {
            background: rgba(255, 255, 255, 0.4);
            border-radius: 10px;
            border: 1px solid #fff;
            height: 270px;
            width: 500px;
            margin-top: 200px;
        }

        .copyright {
            margin-left: 38%;
            margin-top: 240px;
        }

        .copyright label {
            font-family: "edwardian script itc";
            font-size: 18px;
        }

        #tip {
            position: fixed;
            opacity: 0.8;
            margin: 0 40%;
            width: 300px;
        }

        #tip .box {
            font-weight: bold;
            color: red;
            background-color: #FFFFFF;
        }
    </style>
</head>
<body class="login">
<div class="container">
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">欢迎</h4>
                </div>
                <div class="modal-body">
                    <p>来了，客官 ^_^</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">朕知道了</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container" id="tip"></div>
<div class="container">
    <form class="form-horizontal center-block" action="/goto" method="post">
        <h2 align="center">登入界面</h2>
        <div class="form-group has-feedback">
            <label for="userName" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-8">
                <input type="text" class="form-control"  name="userName" value="${requestScope.get("userName")}" id="userName" placeholder="用户名" required="true">
            </div>
        </div>
        <div class="form-group has-feedback">
            <label for="userPassword" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" name="userPassword" id="userPassword" placeholder="密码" required="true">
            </div>
        </div>
        <div class="form-group ">
            <div class="col-sm-offset-8 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox">记住我
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-8 col-sm-10">
                <button type="submit" class="btn btn-primary">走你</button>
            </div>
        </div>
    </form>
    <div class="copyright">
        <label>Copyright 2019-2020 .All Rights Reserved.</label>
    </div>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: chene
  Date: 6/23/2017
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    System.out.println(basePath);
%>

<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-Hans">
<head>
    <script src="<%=basePath%>js/wbi8ikb.js"></script>
    <script>try {
        Typekit.load({async: true});
    } catch (e) {
    }</script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>登录</title>
    <meta name="keywords" content="login">
    <meta name="description" content="login page">
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="<%=basePath%>css/animate.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/style.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/login.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->
    <link href="<%=basePath%>css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/cheney.css" rel="stylesheet">
</head>
<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-7">
            <div class="signin-info">
                <div class="logopanel m-b">
                    <h1>物资管理系统</h1>
                </div>
                <div class="m-b"></div>
                <h4>欢迎使用 <strong>物资管理系统</strong></h4>
            </div>
        </div>
        <div class="col-sm-5">
            <form id="login-form">
                <h4 class="no-margins">登录：</h4>
                <p class="m-t-md">登录到物资管理系统</p>
                <input id="id" name="id" type="text" class="form-control uname" placeholder="用户名"/>
                <input id="passwd" name="passwd" type="password" class="form-control pword m-b" placeholder="密码"/>
                <a href="javascript:void(0);">忘记密码了？</a>
                <a id="login-sub" class="btn btn-success btn-block" href="javascript:void(0);"><i
                        class="fa fa-sign-in"></i>
                    <span class="nav-label">登录</span></a>
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            &copy; 2018 All Rights Reserved. AkelahZ
        </div>
    </div>
</div>
<script src="<%=basePath%>js/jquery.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/plugins/toastr/toastr.min.js"></script>
<script src="<%=basePath%>js/cheney-toast.js?v=1.0.1"></script>
<script>
    if (window.top !== window.self) {
        window.top.location = window.location
    }
</script>

<script>
    $(function () {
        $("#id").focus();

        $("#id").bind('keypress', function (event) {
            if (event.keyCode === 13)
                login();
        });

        $("#passwd").bind('keypress', function (event) {
            if (event.keyCode === 13)
                login();
        });

        $("#login-sub").click(function () {
            login();
        });
    });

    function login() {
        var url = "account-login";
        var args = {
            "staffTel": $("input[name='id']").val(),
            "staffPassword": $("input[name='passwd']").val()
        };
        $.post(url, args, function (data) {
            if (data === "1") {
                location.href = "account-home";
            } else {
                if ($("#veri1").length <= 0) {
                    $("input[name='passwd']").after("<p id=\"veri1\" class=\"m-t-md\" style=\"color:#ed5565\">帐号或密码错误</p>");
                }
            }
        });
        return false;
    }
</script>
</body>
</html>

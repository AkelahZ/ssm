<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<script src="https://use.typekit.net/wbi8ikb.js"></script>
<script>try{Typekit.load({ async: true });}catch(e){}</script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404</title>
    <meta name="keywords" content="404">
    <meta name="description" content="404">
    <link href="<%=basePath%>css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>css/font-awesome.css?v=4.7.0" rel="stylesheet">
    <link href="<%=basePath%>css/animate.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="<%=basePath%>css/cheney.css" rel="stylesheet">
  </head>
  <body class="gray-bg">
    <div class="middle-box text-center animated fadeInDown">
      <h1>404</h1>
      <h3 >页面未找到！</h3>
      <div >
        抱歉，页面好像去火星了~
      </div>
    </div>
    <script src="<%=basePath%>js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=basePath%>js/bootstrap.min.js?v=3.3.6"></script>
  </body>
</html>

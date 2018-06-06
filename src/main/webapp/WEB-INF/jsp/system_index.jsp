<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/10
  Time: 6:37
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    User_Result user=(User_Result)session.getAttribute("user");
    List<Role_Result> list=(List)session.getAttribute("userPowerName");
    List<String> listp =new ArrayList<>();
    for(Role_Result s:list){
        listp.add(s.getPowerName());
    }
    HashSet h = new HashSet(listp);
    listp.clear();
    listp.addAll(h);
%>

<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.soecode.lyf.entity.Role_Result" %>
<%@ page import="com.soecode.lyf.entity.User_Result" %>
<html>
<head>
    <script src="https://use.typekit.net/wbi8ikb.js"></script>
    <script>try{Typekit.load({ async: true });}catch(e){}</script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<%=basePath%>css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>css/font-awesome.css?v=4.7.0" rel="stylesheet">
    <link href="<%=basePath%>css/animate.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="<%=basePath%>css/cheney.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="middle-box text-center animated fadeInDown">
    <h2>欢迎进入物资管理系统</h2>
    <br><br>
    <h3 >您的身份为:<%=user.getRoleName()%></h3>
    <br><br>
    <div >
        您可以使用以下功能:<%for(String s:listp){%>
        <%=s%>&nbsp;

        <%}%>
    </div>
</div>
<script src="<%=basePath%>js/jquery.min.js?v=2.1.4"></script>
<script src="<%=basePath%>js/bootstrap.min.js?v=3.3.6"></script>
</body>
</html>

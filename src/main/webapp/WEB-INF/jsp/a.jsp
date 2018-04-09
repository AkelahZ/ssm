<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";
    System.out.println(basePath);
%>

<%@include file="common/bootstrap.jsp" %>
<html>
<body>
Hello World!!!!
<br>
</body>
</html>
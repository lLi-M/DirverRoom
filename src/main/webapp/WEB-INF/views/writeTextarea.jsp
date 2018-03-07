<%--
  Created by IntelliJ IDEA.
  User: Li
  Date: 2017/12/22
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>  <br>
<center><h1 style="color: purple">${message}</h1></center>
<form action="${pageContext.request.contextPath}/message" method="post">
    <br><br>

   <center> 标题：<input type="text" name="messageTitle"> </center>
    <br><br>  <br><br>

    <center>内容：<textarea cols="100" rows="20" name="messageInfo">

    </textarea></center>
    <br>
<center><button type="submit" >提交发布信息</button></center>
</form>
</body>
</html>

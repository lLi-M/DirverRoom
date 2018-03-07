<%--
  Created by IntelliJ IDEA.
  User: Li
  Date: 2017/10/29
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8" >
    <title>Title</title>
    <link
            href="../../static/bootstrap-3.3.7-dist/css/bootstrap.min.css  "
            rel="stylesheet">
    <style type="text/css">
        #message{
            color: #2b669a;
        }
        #ex{
            color: crimson;
        }
    </style>
</head>
<body>
<div align="center">
    <img  src="${pageContext.request.contextPath}/image/error.png" >
    <h1 id="message" >哎呀，页面出错了，请检查您输入的信息</h1>
          <p id="ex">错误信息为： ${error}</p>
    <br><br><br>
    <form action="forward">
        <div class="form-group">
            <button type="submit" class="btn btn-lg btn btn-primary glyphicon glyphicon-repeat">&nbsp;回到登录页面</button>

    </div>
    </form>
</div>
</body>
</html>

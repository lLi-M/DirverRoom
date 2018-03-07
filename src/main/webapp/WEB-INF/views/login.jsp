<%--
  Created by IntelliJ IDEA.
  User: Li
  Date: 2017/10/29
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>管理员登录</title>
    <meta charset="UTF-8">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
    <link
            href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css  "
            rel="stylesheet">
    <script
            src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" >

    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
        <li data-target="#carousel-example-generic" data-slide-to="4"></li>
    </ol>


    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="${pageContext.request.contextPath}/image/1.jpg" width="100%" height="25%"/>
            <div class="carousel-caption">
                ...
            </div>
        </div>

        <div class="item">
            <img src="${pageContext.request.contextPath}/image/2.jpg" width="100%" height="25%"/>
            <div class="carousel-caption">
                <h3>...</h3>
                <p>...</p>
            </div>
        </div>

        <div class="item">
            <img src="${pageContext.request.contextPath}/image/3.jpg" width="100%" height="25%"/>
            <div class="carousel-caption">
                <h3>...</h3>
                <p>...</p>
            </div>
        </div>

        <div class="item">
            <img src="${pageContext.request.contextPath}/image/4.jpg" width="100%" height="25%"/>
            <div class="carousel-caption">
                <h3>...</h3>
                <p>...</p>
            </div>
        </div>
    </div>

    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<br><br>
<script language="JavaScript">
    $('.carousel').carousel({
        interval: 2500
    })
</script>

<div class="container">
    <div class="row" >
        <div class="col-md-6 col-xs-9 col-md-offset-3 col-xs-offset-5">
            <form class="form-horizontal" action="login" method="post">
                <div class="form-group">
                    <div align="center"><h2 >帐号密码登录</h2></div>
                    <br>
                    <label for="inputEmail3" class="col-sm-2 control-label">用户名：</label>
                    <div class="col-sm-10">
                        <input type="text" name="name" class="form-control" id="inputEmail3" placeholder="用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
                    <div class="col-sm-10">
                        <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="vaild" class="col-sm-2 control-label">验证码：</label>
                    <div class="col-sm-10 col-md-4">
                    <input class=" form-control" name="vaildcode" id="vaild" placeholder="验证码 "/>
                    </div>
                    <label for="vaild">
                        <img id="loginform:vCode" src="${pageContext.request.contextPath }/validatecode.jsp"
                         onclick="javascript:document.getElementById('loginform:vCode').src='${pageContext.request.contextPath }/validatecode.jsp?'+Math.random();" />
                    </label>
                    <p align="center"style="color: red">${error}</p>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> 记住我
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-group">

                    <div class="row">
                        <div class="col-md-4 col-md-offset-3">
                            <button type="submit" class="btn btn-default btn btn-primary glyphicon glyphicon-ok">&nbsp;登录</button>
                        </div >
                        <div class="col-md-4"><button type="reset" class="btn btn-default btn btn-danger glyphicon glyphicon-trash">&nbsp;重置</button></div>

                    </div>

                </div>

            </form>

        </div>
    </div>
</div>
<div class="foot col-md-offset-10" >
    <br>
    <div  style="color:purple;float:right; " ><small><b>&copy;2017 Enter cloud Software, Inc. All Rights Reserved. Terms of Use, 入云科技软件公司</b></small>
        <small style="color: red;"><b>侵权必究</b></small></div>

</div>
</body>
</html>

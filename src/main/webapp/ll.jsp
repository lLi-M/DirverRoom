<%--
  Created by IntelliJ IDEA.
  User: 李 雷
  Date: 2018/1/14
  Time: 17:01
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>练车预约</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- <link rel="stylesheet" href="css/bootstrap.min.css"> -->
    <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css">
    <style type="text/css">
        .header{width: 100%; height: 4rem; margin-top: 1rem;}
        .time{width: 100%; height: 5rem; background-color: #F8F8F8; margin:0; }
        .time ul li{width: 20%; height:5rem; float: left; text-align: center;color: black; padding: 10px 0 10px 0 !important;}
        .time ul li.a1{color: white;  background-color: #337ab7 !important; }
        .media img{width: 6rem; height: 6rem; float: left;border-radius: 50%;}
        .dirver{margin-top: 0.5rem;}
        .dirver ul li{margin: 0; padding: 1rem; width: 100%; height: 8rem; }
        .amORpm{width: 100%; height: 4rem; padding-top: 0.5rem; background-color: #F8F8F8;border-top: 3px solid white; }
        .dirver img{width: 6rem; height: 6rem; float: left;border-radius: 50%;border: 1px solid gray; }
    </style>
</head>
<body>
<div class="container">
    <div class="row header">
        <div class="col-xs-3">
            <a href="index.html" class="btn btn-success btn-sm btn-block">
                返回
                <span class="glyphicon glyphicon-menu-left"></span>
            </a>
        </div>

        <div class="col-xs-7">
            <h4 class="text-center">
                科目三练车预约
            </h4>
        </div>
    </div>

    <div class="time">
        <ul class="nav nav-tabs" id="timeUL">
            <li role="presentation"  class="a1"><br><span></span></li>
            <li role="presentation"><br/><span></span></li>
            <li role="presentation"><br><span></span></li>
            <li role="presentation"><br><span></span></li>
            <li role="presentation"><br><span></span></li>
        </ul>
    </div>
<input type=" text" id="1">


    <div class="dirver">
        <ul class="list-group" id="dirverUL">

        </ul>

    </div>

</div>

<script src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<!-- <script src="js/bootstrap.min.js"></script> -->
<script type="text/javascript">



    //先进行ajax请求，获取到日期列表
    var date = null;

    var dirverULLI=null;


    var nowDate;//当前选中的日期







    function getDriverName(obj){
        return $(obj).parent().prev().children('span').html();
    }


    //点击改变教练名单的ajax函数，如(点击日期，点击上午和下午)
    function selectAmorpm(data0){
        $.ajax({
            type: "GET",
            data:{"day":data0,"subject":"3"},
            url: "${pageContext.request.contextPath }/show/trainerinfo",
            statusCode : {
                200 : function(dataList){
                    //var dirverList = JSON.parse(dataList);
                    var dirverList = dataList;

                    $('#dirverUL').empty();

                    for (var i = 0; i < dirverList.length; i++) {
                        appendDirver(dirverList[i].trainerName, dirverList[i].trainerCard, dirverList[i].trainerStatuspm);


                    }
                    ;
                },

                404 : function(dataList){

                    $('#dirverUL').empty();
                    alert(data0+"无可预约教练，请选择其他时间！");

                },
                500 : function(dataList){
                    alert("服务器忙，请重试!");
                }
            }

         })
    }
    //点击预约教练的ajax函数
    function setPractice(data0,dirverName){
        window.location.href="${pageContext.request.contextPath }/show/trainerinfoone?day="+data0+"&subject=3&trainerName="+dirverName+""
        <%--$.ajax({--%>
        <%--type: "POST",--%>
        <%--data:{"day":data0,"ap":ap,"trainerName":dirverName},--%>
        <%--url: "${pageContext.request.contextPath }/appointemnt/yuyue",--%>
        <%--statusCode : {--%>
        <%--200 : function(dataList){--%>
        <%--//  var dirverList = JSON.parse(dataList.paramData);--%>
        <%--var dirverList =dataList;--%>
        <%--alert(dirverList.message);--%>
        <%--selectAmorpm(data0);--%>
        <%--},--%>
        <%--500 : function(dataList){--%>
        <%--alert("请先登录!");--%>

        <%--window.location.href="${pageContext.request.contextPath }/login";--%>

        <%--}--%>
        <%--}--%>
        <%--}) --%>
    }


    function appendDirver(name,carCode,nownum){
        var li='<li class="list-group-item"> <div class="row"> <div class="col-xs-3"> <img src="img/driver.jpg" alt=""> </div> <div class="col-xs-6"> <label>教练名：</label><span class="media-heading">'+name+'</span><br> <label>车牌号：</label><span class="media-heading">'+carCode+'</span><br> <label>剩余人数：</label><span>'+nownum+'</span> </div> <div class="col-xs-3"> <button class="btn btn-success fat-btn" data-loading-text="查看">查看</button> </div> </div> </li>';

        $('#dirverUL').append(li);
        if (nownum<=0) {
            $('#dirverUL>li:last button').attr("disabled","disabled")
        };
    }


    $(function(){






//将接收到的信息填入日期列表中的函数
        function setDateUL(date0){
            for (var i = 0; i<date0.length; i++) {
                date0[i].date=date0[i].date.substr(2);
            };

            for (var i = 0; i <date0.length;i++) {
                $("#timeUL li:nth-child("+(i+1)+")").html(date0[i].week+"<br/><span>"+date0[i].date+"</span>");

            };
        }


//将接收到的信息填入日期列表中

        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath }/show/daysinfo",
            statusCode : {
                200 : function(dataList){
                    date =dataList;
                    date.reverse();
                    setDateUL(date);
                },
                404 :function(dataList){
                    alert("无法获取当前时间");
                },
                500 : function(dataList){
                    alert("服务器忙，请重试!");
                }
            }
        })



//选择练车日期的事件
        /* $("#timeUL").click(function(ev){
              APM = "am";
                var nodeName0=ev.target.nodeName;
                alert(nodeName0);
                if (nodeName0=="LI") {

                     $("#timeUL li").attr("class","");
                   $(ev.target).attr("class","a1");
                  nowDate = "20"+$(ev.target).children("span").text();
                  selectAmorpm(nowDate,APM);
                };
                if (nodeName0=="SPAN") {
                     $("#timeUL li").attr("class","");
                   $(ev.target).parent().attr("class","a1");
                  nowDate = "20"+$(ev.target).text();
                  selectAmorpm(nowDate,APM);

                };



          });*/


        function a(){
            for (var i = 0; i < $("#timeUL>li").length; i++) {
                $("#timeUL>li:nth-child("+(i+1)+")").click(function(ev){
                    $("#timeUL li").attr("class","");
                    $(ev.currentTarget).attr("class","a1");
                    nowDate = "20"+$(ev.currentTarget).children("span").text();

                    selectAmorpm(nowDate);
                })
            };
        }
        a();




//预约练车的事件
        $("#dirverUL").click(function(ev){
            // alert(ev.target.nodeName);
            if (ev.target.nodeName=="BUTTON") {
                $(ev.target).button('loading').delay(1000).queue(function() {
                    // $(this).addClass("btn-info");
                    // $(this).text("已预约");
                    // 编写进行ajax请求
                    setPractice(nowDate,getDriverName(ev.target));
                });
            };
        });








    })

</script>
</body>
</html>

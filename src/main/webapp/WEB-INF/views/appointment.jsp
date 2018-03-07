<%--
  Created by IntelliJ IDEA.
  User: Li
  Date: 2017/12/21
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/ztree/zTreeStyle.css" type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/ztree/jquery.ztree.all-3.5.js"></script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
<div region="center" border="false">
    <table id="trainer">
    </table>
</div>
<script type="text/javascript">

//    function doDblClickRow(rowIndex, rowData) {
//        //打开修改学生窗口
//        $('#editstudent').window("open");
//        //使用form表单对象的load方法回显数据
//        $("#editForm").form("load", rowData);
//    }

//    function doAdd() {
//        $('#addstudent').window("open");
//    }

    function doSearch() {
        $('#search').window('open');


    }

    var toolbar = [
//        {
//            id: 'button-add',
//            text: '录入',
//            iconCls: 'icon-add',
//            handler: doAdd,
//        },

        {
            id: 'button-search',
            text: '查询',
            iconCls: 'icon-search',
            handler: doSearch,
        }
    ];

    var columns = [[
        {
            field: "id",
            checkbox: true,
        },
        {//todo
            field: "trainerName",
            title: "教练姓名",
            width: 150,
            align: "center",
        },
        {
            field: "appointmentTime",
            title: "练车日期",
            width: 150,
            align: "center",
        },
        {
            field: "appointmentAp",
            title: "上下午",
            width: 120,
            align: "center",
            formatter:function (data,index,dd) {
                if(data=="pm"){
                    return "下午";
                }else {
                    return "上午";
                }

            }
        },
        {
            field: "studentName",
            title: "学员名",
            width: 150,
            align: "center",
        },
        {
            field: "studentPhone",
            title: "学生电话",
            width: 200,
            align: "center",
        },

    ]
    ];


    $(function () {
        $("body").css({visibility: "visible"});

        $('#trainer').datagrid({
            iconCls: 'icon-forward',
            fit: true,
            border: false,
            rownumbers: true,
            striped: true,
            pageList: [30, 50, 100],
            pagination: true,
            toolbar: toolbar,
            url: "${pageContext.request.contextPath}/getappointment",
            idField: 'id',
            columns: columns,
            method: "get",
//            onDblClickRow: doDblClickRow

        })


//        $('#editstudent').window({
//            title: '录入教练信息',
//            width: 800,
//            modal: true, //遮罩效果
//            shadow: true, //阴影效果
//            closed: true, //关闭
//            height: 500,
//            resizable: false
//        });
//        $('#addstudent').window({
//            title: '录入学生信息',
//            width: 800,
//            modal: true, //遮罩效果
//            shadow: true, //阴影效果
//            closed: true, //关闭
//            height: 500,
//            resizable: false
//        });

        $('#search').window({
            title: '查询',
            width: 500,
            modal: true,
            shadow: true,
            closed: true,
            height: 400,
            resizable: false
        });

        $("#btn").click(function () {
            //将指定的form表单中所有的输入项转为json数据{key:value,key:value}
            var p = $("#searchForm").serializeJson();
            console.info(p);
            //调用数据表格的load方法，重新发送一次ajax请求，并且提交参数
            $("#trainer").datagrid("load", p);
            //关闭查询窗口
            $("#search").window("close");
        });

    });

    $.fn.serializeJson = function () {
        var serializeObj = {};
        var array = this.serializeArray();
        $(array).each(function () {
            if (serializeObj[this.name]) {
                if ($.isArray(serializeObj[this.name])) {
                    serializeObj[this.name].push(this.value);
                } else {
                    serializeObj[this.name] = [serializeObj[this.name], this.value];
                }
            } else {
                serializeObj[this.name] = this.value;
            }
        });
        return serializeObj;
    };



</script>




//新增
<%--<div class="easyui-window" title="录入学生信息" id="addstudent"--%>
     <%--collapsible="false" minimizable="false" maximizable="false"--%>
     <%--style="top:20px;left:200px">--%>
    <%--<div region="north" style="height:31px;overflow:hidden;" split="false"--%>
         <%--border="false">--%>
        <%--<div class="datagrid-toolbar">--%>
            <%--<a id="save" icon="icon-save" href="#" class="easyui-linkbutton"--%>
               <%--plain="true">保存</a>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<div region="center" style="overflow:auto;padding:5px;" border="false">--%>
        <%--<form id="addForm">--%>
            <%--<table class="table-edit" width="80%" align="center">--%>
                <%--<tr class="title">--%>
                    <%--<td colspan="4">基本信息</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>学生姓名</td>--%>
                    <%--<td><input type="text" class="easyui-validatebox"--%>
                               <%--name="studentName" required="true"/></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>身份证号</td>--%>
                    <%--<td><input type="text" class="easyui-validatebox" name="studentIdcard"--%>
                               <%--required="true"/></td>--%>
                <%--</tr>--%>

                <%--<tr>--%>
                    <%--<td>手机号</td>--%>
                    <%--<td><input type="text" class="easyui-validatebox" name="studentPhone"--%>
                               <%--required="true"/></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>考试项目</td>--%>
                    <%--<td><input type="text" class="easyui-validatebox"--%>
                               <%--name="studentProject" required="true"/></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>练车时间</td>--%>
                    <%--<td><input type="text" class="easyui-datebox"--%>
                               <%--name="studentCartime" required="true"/></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>练车次数</td>--%>
                    <%--<td><input type="text" class="easyui-validatebox"--%>
                               <%--name="studentTime" required="true"/></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>学生状态</td>--%>
                    <%--<td><input type="text" class="easyui-validatebox"--%>
                               <%--name="studentSatus" required="true"/></td>--%>
                    <%--<td><p style="color:darkblue">请录入数字：1为正常，2为补考，3为拉黑--%>
                        <%--<p></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>爽约次数</td>--%>
                    <%--<td><input type="text" class="easyui-validatebox"--%>
                               <%--name="studentShaungyue" required="true"/></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>学生密码</td>--%>
                    <%--<td><input type="text" class="easyui-validatebox"--%>
                               <%--name="studentPassword" required="true"/></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>练车最高次数</td>--%>
                    <%--<td><input type="text" class="easyui-validatebox"--%>
                               <%--name="studentTimeCount" required="true"/></td>--%>
                <%--</tr>--%>

                <%--<script type="text/javascript">--%>
                    <%--$(function () {--%>
                        <%--//为保存按钮绑定事件--%>
                        <%--$("#save").click(function () {--%>
                            <%--//表单校验，如果通过，提交表单--%>
                            <%--var v = $("#addForm").form("validate");--%>
                            <%--if (v) {--%>
                                <%--var formdata = $("#addForm").serialize();--%>
                                <%--$.post("studentadd", formdata, function (data) {--%>
                                    <%--//todo--%>
<%--//                                    window.location.href = "/ds/trainer";--%>
                                    <%--if (data == "true") {--%>
                                        <%--alert("插入成功");--%>
                                        <%--window.location.href = "ds/lookusertime";--%>
                                    <%--} else {--%>
                                        <%--alert("插入失败");--%>
                                        <%--window.location.href = "ds/lookusertime";--%>
                                    <%--}--%>


                                <%--});--%>
                            <%--}--%>

                        <%--});--%>
                    <%--});--%>
                <%--</script>--%>

            <%--</table>--%>
        <%--</form>--%>
    <%--</div>--%>
<%--</div>--%>


//查询窗口
<div class="easyui-window" title="查询窗口" id="search" collapsible="false" minimizable="false" maximizable="false"
     style="top:20px;left:200px">
    <div style="overflow:auto;padding:5px;" border="false">
        <form id="searchForm">
            <table class="table-edit" width="50%" align="center">
                <tr class="title">
                    <td colspan="2">查询条件</td>
                </tr>
                <tr>
                    <td>练车日期</td>
                    <td><input type="text" class="easyui-datebox"
                               name="appointmentTime" required="true"/></td>
                </tr>

                <tr>
                    <td colspan="2"><a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

</body>
</html>

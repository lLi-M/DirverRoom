<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
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
    <table id="testpeople">

    </table>
</div>
<script type="text/javascript">

    function doDblClickRow(rowIndex, rowData) {
        //打开修改学生窗口
        $('#edittestpeople').window("open");
        //使用form表单对象的load方法回显数据
        $("#editForm").form("load", rowData);
    }


    function doDelete() {
        var rows = $("#testpeople").datagrid("getSelections");
        if (rows.length == 0) {
            //没有选中记录，弹出提示
            $.messager.alert("提示信息", "请选择需要删除的学生！", "warning");
        } else {
            //选中了学生,弹出确认框
            $.messager.confirm("删除确认", "你确定要删除选中的学生吗？", function (r) {
                if (r) {

                    var array = new Array();
                    //确定,发送请求
                    //获取所有选中的学生的id
                    for (var i = 0; i < rows.length; i++) {
                        var student = rows[i]; //json对象
                        var id = student.id;
                        array.push(id);
                    }
                    var ids = array.join(","); //1,2,3,4,5
                    console.info('ids='+ids)
                    location.href = "${pageContext.request.contextPath}/deltestpeople?ids=" + ids;

                }
            })
        }
    }
    var toolbar = [
        {
            id: 'button-delete',
            text: '删除',
            iconCls: 'icon-cancel',
            handler: doDelete
        }
    ];

    var columns = [[
        {
            field: "id",
            checkbox: true,
        },
        {
            field: "studentName",
            title: "姓名",
            width: 200,
            align: "center",
        },
        {
            field: "studentIdcard",
            title: "身份证号",
            width: 300,
            align: "center",
        },
        {
            field: "studentPhone",
            title: "用户电话",
            width: 300,
            align: "center",
        },
        {
            field: "studentProject",
            title: "所考科目",
            width: 300,
            align: "center",
        }



    ]
    ];


    $(function () {
        $("body").css({visibility: "visible"});

        $('#testpeople').datagrid({
            iconCls: 'icon-forward',
            fit: true,
            border: false,
            rownumbers: true,
            striped: true,
            pageList: [30, 50, 100],
            pagination: true,
            toolbar: toolbar,
            url: "${pageContext.request.contextPath}/testpeople",
            idField: 'id',
            columns: columns,
            method: "get",
            onDblClickRow: doDblClickRow

        })
        $('#edittestpeople').window({
            title: '录入教练信息',
            width: 800,
            modal: true, //遮罩效果
            shadow: true, //阴影效果
            closed: true, //关闭
            height: 500,
            resizable: false
        });

    });


</script>

<div class="easyui-window" title="修改学生预约次数，考试项目" id="edittestpeople"
     collapsible="false" minimizable="false" maximizable="false"
     style="top:20px;left:200px">
    <div region="north" style="height:31px;overflow:hidden;" split="false"
         border="false">
        <div class="datagrid-toolbar">
            <a id="edit" icon="icon-save" href="#" class="easyui-linkbutton"
               plain="true">保存</a>
        </div>
    </div>

    <div region="center" style="overflow:auto;padding:5px;" border="false">
        <form id="editForm">
            <table class="table-edit" width="80%" align="center">
                <tr class="title">
                    <td align="center" colspan="4">基本信息</td>
                </tr>
                <tr>

                    <td><input type="hidden" class="easyui-validatebox"
                               name="id"/></td>
                </tr>
                <tr>
                    <td>学生姓名</td>
                    <td><input type="text" class="easyui-validatebox"
                               name="studentName" required="true"/></td>
                </tr>
                <tr>
                    <td>身份证号</td>
                    <td><input type="text" class="easyui-validatebox" name="studentIdcard"
                               required="true"/></td>
                </tr>
                <tr>
                    <td>用户电话</td>
                    <td><input type="text" class="easyui-validatebox" name="studentPhone"
                               required="true"/></td>
                </tr>

                <tr>
                    <td>所考科目</td>
                    <td><input type="text" class="easyui-validatebox" name="studentProject"
                               required="true"/></td>
                </tr>




                <script type="text/javascript">


                        //
                    $(function () {
                        //为保存按钮绑定事件
                        $("#edit").click(function () {
                            //表单校验，如果通过，提交表单
                            var v = $("#editForm").form("validate");
                            if (v) {
                                var formdata = $("#editForm").serialize();
                                $.post("${pageContext.request.contextPath}/testpeopleedit", formdata, function (data) {
                                    //todo
                                    if (data == "true") {
                                        alert("修改成功");
                                        window.location.href = "${pageContext.request.contextPath}/ds/testpeople";
                                    } else {
                                        alert("修改失败");
                                        window.location.href = "${pageContext.request.contextPath}/ds/testpeople";
                                    }


                                });
                            }

                        });
                    });
                </script>

            </table>
        </form>
    </div>
</div>
</body>
</html>
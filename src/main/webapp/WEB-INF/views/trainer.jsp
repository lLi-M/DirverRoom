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

    function doAdd() {
        $('#addtrainer').window("open");
    }

    function doDblClickRow(rowIndex, rowData) {
        //打开修改学生窗口
        $('#edittrainer').window("open");
        //使用form表单对象的load方法回显数据
        $("#editForm").form("load", rowData);
    }

    function doDelete() {
        var rows = $("#trainer").datagrid("getSelections");
        if (rows.length == 0) {
            //没有选中记录，弹出提示
            $.messager.alert("提示信息", "请选择需要删除的教练！", "warning");
        } else {
            //选中了学生,弹出确认框
            $.messager.confirm("删除确认", "你确定要删除选中的教练吗？", function (r) {
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
                    location.href = "${pageContext.request.contextPath}/deltrainer?ids=" + ids;

                }
            })
        }
    }

    var toolbar = [
        {
            id: 'button-add',
            text: '录入',
            iconCls: 'icon-add',
            handler: doAdd,
        },
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
            field: "testName",
            title: "考试科目",
            width: 150,
            align: "center",
        },
        {
            field: "testTime",
            title: "预约时间",
            width: 220,
            align: "center",
//           formatter: function (data, row, index) {
//               if (data == 0) {
//                  return "预约空余";
//               } else {
//                   return "预约已满";
//               }
//           }

        },
        {
            field: "trainerName",
            title: "教练姓名",
            width: 200,
            align: 'center',
        },
        {
            field: "trainerCard",
            title: "教练车牌号",
            width: 200,
            align: 'center',
        },
        {
            field: "trainerHours",
            title: "教练预约时间点",
            width: 150,
            align: 'center',
        },
        {
            field: "trainerCount",
            title: "教练预约次数",
            width: 150,
            align: 'center',
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
            url: "${pageContext.request.contextPath}/trainer",
            idField: 'id',
            columns: columns,
            method: "get",
            onDblClickRow: doDblClickRow

        })
        $('#addtrainer').window({
            title: '录入教练信息',
            width: 800,
            modal: true, //遮罩效果
            shadow: true, //阴影效果
            closed: true, //关闭
            height: 500,
            resizable: false
        });

        $('#edittrainer').window({
            title: '录入教练信息',
            width: 800,
            modal: true, //遮罩效果
            shadow: true, //阴影效果
            closed: true, //关闭
            height: 500,
            resizable: false
        });

    })

</script>
//新增教练
<div class="easyui-window" title="录入教练信息" id="addtrainer"
     collapsible="false" minimizable="false" maximizable="false"
     style="top:20px;left:200px">
    <div region="north" style="height:31px;overflow:hidden;" split="false"
         border="false">
        <div class="datagrid-toolbar">
            <a id="save" icon="icon-save" href="#" class="easyui-linkbutton"
               plain="true">保存</a>
        </div>
    </div>

    <div region="center" style="overflow:auto;padding:5px;" border="false">
        <form id="addForm">
            <table class="table-edit" width="80%" align="center">
                <tr class="title">
                    <td colspan="4">基本信息</td>
                </tr>
                <tr>
                    <td>预约科目</td>
                    <td><input type="text" class="easyui-validatebox"
                               name="testName" required="true"/></td>
                </tr>
                <tr>
                    <td>教练姓名</td>
                    <td><input type="text" class="easyui-validatebox" name="trainerName"
                               required="true"/></td>
                </tr>

                <tr>
                    <td>教练车牌号</td>
                    <td><input type="text" class="easyui-validatebox" name="trainerCard"
                               required="true"/></td>
                </tr>
                <tr>
                    <td>预约时间</td>
                    <td><input type="text" class="easyui-datebox" name="TestTime"
                               required="true"/></td>
                </tr>
                <tr>
                    <td>教练时间点数</td>
                    <td><input type="text"
                               name="trainerHours" /></td>
                </tr>
                <tr>
                    <td>教练预约总次数</td>
                    <td><input type="text"
                               name="trainerCount" /></td>
                </tr>

                <script type="text/javascript">
                    $(function () {
                        //为保存按钮绑定事件
                        $("#save").click(function () {
                            //表单校验，如果通过，提交表单
                            var v = $("#addForm").form("validate");
                            if (v) {
                                var formdata = $("#addForm").serialize();
                                $.post("${pageContext.request.contextPath}/traineradd", formdata, function (data) {
                                    //todo
//                                    window.location.href = "/ds/trainer";
                                    if (data == "true") {
                                        alert("插入成功");
                                        window.location.href = "${pageContext.request.contextPath}/ds/trainer";
                                    } else {
                                        alert("插入失败");
                                        window.location.href = "${pageContext.request.contextPath}/ds/trainer";
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

//修改教练
<div class="easyui-window" title="修改教练信息" id="edittrainer"
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
                    <td><input type="hidden"
                               name="id"/></td>
                </tr>
                <tr>
                    <td>预约科目</td>
                    <td><input type="text" class="easyui-validatebox"
                               name="testName" required="true"/></td>
                </tr>
                <tr>
                    <td>教练姓名</td>
                    <td><input type="text" class="easyui-validatebox" name="trainerName"
                               required="true"/></td>
                </tr>

                <tr>
                    <td>教练车牌号</td>
                    <td><input type="text" class="easyui-validatebox" name="trainerCard"
                               required="true"/></td>
                </tr>
                <tr>
                    <td>预约时间</td>
                    <td><input type="text" class="easyui-datebox" name="TestTime"
                               required="true"/></td>
                </tr>
                <tr>
                    <td>教练时间点数</td>
                    <td><input type="text"
                               name="trainerHours" /></td>
                </tr>
                <tr>
                    <td>教练预约总次数</td>
                    <td><input type="text"
                               name="trainerCount" /></td>
                </tr>
                <script type="text/javascript">
                    $(function () {
                        //为保存按钮绑定事件
                        $("#edit").click(function () {
                            //表单校验，如果通过，提交表单
                            var v = $("#editForm").form("validate");
                            if (v) {
                                var formdata = $("#editForm").serialize();
                                $.post("${pageContext.request.contextPath}/traineredit", formdata, function (data) {
                                    //todo
                                    console.info(data)
                                    if (data == "true") {
                                        alert("修改成功");
                                        window.location.href = "${pageContext.request.contextPath}/ds/trainer";
                                    } else {
                                        alert("修改失败");
                                        window.location.href = "${pageContext.request.contextPath}/ds/trainer";
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
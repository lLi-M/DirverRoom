<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理系统</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/ztree/zTreeStyle.css" type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/ztree/jquery.ztree.all-3.5.js"></script>
</head>

<body class="easyui-layout">
<div style="height:40px" data-options="region:'north'">
   <div  style="color:purple; " ><h2 align="center" ><b>&copy;2017 Enter cloud Software lilei, Inc. All Rights Reserved. Terms of Use, 入云科技软件公司,李雷:18335463225</b></h2></div>
</div>
<%--<div style="height: 100em" data-options="region:'south'">--%>
    <%--<img src="${pageContext.request.contextPath}/image/tiankong.jpg" width="100%" height="100%">--%>
<%--</div>--%>
<div title="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
菜单" style="width: 300em" data-options="region:'west'">
    <div class="easyui-accordion" data-options="fit:true">
        <div title="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;预约信息管理">
            <ul id="ds" class="ztree"></ul>
        </div>
        <div title="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理"></div>
        <script type="text/javascript">
            $(function () {

                var setting = {
                    data: {
                        simpleData: {
                            enable: true,
                        }
                    },
                    callback: {
                        onClick: onClick
                    }
                };
                $.ajax({
                    url: '${pageContext.request.contextPath}/json/ds.json',
                    type: 'POST',
                    dataType: 'text',
                    success: function (data) {
                        var zNodes = eval("(" + data + ")");
                        $.fn.zTree.init($("#ds"), setting, zNodes);
                    },
                    error: function (msg) {
                        alert('菜单加载异常!');
                    }
                });

                function onClick(event, treeId, treeNode, clickFlag) {
                    // 判断树菜单节点是否含有 page属性
                    if (treeNode.page != undefined && treeNode.page != "") {
                        var content = '<div style="width:100%;height:100%;overflow:hidden;">'
                            + '<iframe src="'
                            + treeNode.page
                            + '" scrolling="auto" style="width:100%;height:100%;border:0;" ></iframe></div>';
                        if ($("#tabs").tabs('exists', treeNode.name)) {// 判断tab是否存在
                            $('#tabs').tabs('select', treeNode.name); // 切换tab
                            var tab = $('#tabs').tabs('getSelected');
                            $('#tabs').tabs('update', {
                                tab: tab,
                                options: {
                                    title: treeNode.name,
                                    content: content
                                }
                            });
                        } else {
                            // 开启一个新的tab页面
                            $('#tabs').tabs('add', {
                                title: treeNode.name,
                                content: content,
                                closable: true
                            });
                        }
                    }
                }

                $.messager.show({
                    title: "欢迎消息",
                    msg: "尊敬的超级管理员：教练员！<br><br>欢迎您登录驾校预约管理系统",
                    timeout: 5000,
                    showType: "slide"

                });
            })
        </script>
    </div>
</div>
<div data-options="region:'center'">
    <div id="tabs" fit="true" class="easyui-tabs" border="false">

    </div>

</div>

</body>

</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的管理系统</title>
    <link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/material/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/static/js/main.js"></script>
</head>
<body>
<div class="easyui-layout" fit="true">
    <div data-options="region:'north' ,height:100" style="background-color: #00bbee; ">
        <div style="float: left; margin-left: 15px;" >
            <h1>我的系统</h1>
        </div>
        <div style="float: right; margin-top: 70px; margin-right: 30px;">
            当前用户:xxx <a href="#">退出</a>
        </div>
    </div>
    <div data-options="region:'west' ,width:180" title="菜单" >
        <ul id="index_menu"></ul>
    </div>
    <div data-options="region:'center'" >
        <div id="index_tabs">
            <div title="欢迎页" closable="true">
                <h1>欢迎使用系统！</h1>
            </div>
        </div>
    </div>
    <div data-options="region:'south' ,height:40" style="background-color: #00bbee; ">
        <center>xxx公司所有</center>
    </div>


</div>


</body>
</html>

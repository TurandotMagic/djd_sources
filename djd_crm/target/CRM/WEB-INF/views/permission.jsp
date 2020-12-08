<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的管理系统</title>
    <%@include file="common.jsp"%>
    <script type="text/javascript" src="/static/js/permission.js"></script>
</head>
<body>
    <table id="permission_datagird"></table>
    <!--数据表格的按钮-->
    <div id = "permission_list_button">
        <div>
        <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" plain="true" data-cmd="reload">加载权限</a>

        </div>

    </div>

</body>
</html>

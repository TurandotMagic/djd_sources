<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的管理系统</title>
    <%@include file="common.jsp"%>
    <script type="text/javascript" src="/static/js/role.js"></script>
</head>
<body>
    <table id="role_datagird"></table>
    <!--数据表格的按钮-->
    <div id = "role_list_button">
        <div>
        <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" plain="true" data-cmd="add">新增</a>
        <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" plain="true" data-cmd="edit" >编辑</a>
        <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" plain="true" data-cmd="quit" >删除</a>
        <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" plain="true">刷新</a>
        </div>
        <div>
            <input class="esayui-textbox" id="search_btn"/>
        </div>
    </div>
    <!--表单的对话框-->
    <div id="role_dialog">
        <form id="role_form" method="post">
            <input type="hidden" name="id">
            <table align="center" style="margin-top: 10px;">
                <tr>
                    <td><input name="sn" class="easyui-textbox" data-options="label:'角色编码',width:250"></td>
                    <td><input name="name" class="easyui-textbox" data-options="label:'角色名称',width:250"></td>
                </tr>
                <tr>
                    <td><table id="allPermission"></table></td>
                    <td><table id="selfPermission"></table></td>
                </tr>
            </table>
        </form>

    </div>
    <!--对话框的保存取消按钮-->
    <div id ="role_dailog_button">
        <a class="easyui-linkbutton" iconCls="icon-save"  data-cmd="saveRole">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>
</body>
</html>

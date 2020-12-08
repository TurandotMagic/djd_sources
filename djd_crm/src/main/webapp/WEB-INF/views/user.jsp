<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的管理系统</title>
    <%@include file="common.jsp"%>
    <script type="text/javascript" src="/static/js/user.js"></script>
</head>
<body>
    <table id="user_datagird"></table>
    <!--数据表格的按钮-->
    <div id = "user_list_button">
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
    <div id="user_dialog">
        <form id="user_form" method="post">
            <input type="hidden" name="id">
            <div align="center" style="margin-top: 10px;">
                <div>
                    <input class="easyui-textbox" name="username" data-options="label:'用户名:',labelPosition:'top'">
                </div>
                <div>
                    <input class="easyui-textbox" name="name" data-options="label:'姓名:',labelPosition:'top'">
                </div>
                <div>
                    <input class="easyui-textbox" name="tel" data-options="label:'电话号码:',labelPosition:'top'">
                </div>
                <div>
                    <input class="easyui-textbox" name="email" data-options="label:'邮箱:',labelPosition:'top'">
                </div>
                <div>
                    <input  class="easyui-combobox" name="dept" data-options="
                        valueField: 'id',
                        textField: 'deptName',
                        label:'职位:',
                        labelPosition:'top',
                        url:'/department/list'
                        "/>
                </div>
            </div>
        </form>

    </div>
    <!--对话框的保存取消按钮-->
    <div id ="user_dailog_button">
        <a class="easyui-linkbutton" iconCls="icon-save"  data-cmd="saveUser">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>
</body>
</html>

$(function () {
    //抽取代码
    var userDatagird, userDialog, searchBtn, userForm

    userDatagird = $("#user_datagird");
    userDialog = $("#user_dialog");
    searchBtn = $("#search_btn");
    userForm = $("#user_form");
    //datagrid数据表格
    userDatagird.datagrid({
        fit: true,
        url: '/user/list',
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        rownumbers: true,
        toolbar: '#user_list_button',//引用数据表格的工具栏属性
        columns: [
            [
                {field: 'id', title: 'ID', align: 'center', width: 10},
                {field: 'username', title: '用户名', align: 'center', width: 10},
                {field: 'name', title: '姓名', align: 'center', width: 10},
                {field: 'tel', title: '电话号码', align: 'center', width: 10},
                {field: 'email', title: '邮箱', align: 'center', width: 10},
                {field: 'dept', title: '部门', align: 'center', width: 10},
                {field: 'createTime', title: '创建时间', align: 'center', width: 10},
                {field: 'state', title: '状态', align: 'center', width: 10, formatter: stateFormatter},//调用函数
                {field: 'isAdmin', title: '是否管理员', align: 'center', width: 10, formatter: adminFormatter}
            ]
        ]
    });
    //dialog对话框的初始化
    userDialog.dialog({
        title: 'My Dialog',
        width: 400,
        height: 330,
        buttons: '#user_dailog_button',
        closed: true
    });

    //搜索框
    searchBtn.textbox({
        buttonText: 'Search',
        prompt: '请输入关键字....',
        width: 270,
        label: '查询:',
        labelWidth: 70,
        onClickButton: function () {
            var keyword = searchBtn.val();//获取文本框的输入内容
            userDatagird.datagrid("load", {
                keyword: keyword
            });
        }
    });
    //统一管理方法
    var cmdObj = {
        //保存表格提交数据
        saveUser: function () {
            //保存表格数据前，需判断是保存还是编辑？
            var url;
            var idVal = $("[name=id]").val();
            if (idVal) {
                url = "/user/update";
            } else {
                url = "/user/save";
            }
            userForm.form("submit", {

                url: url,
                success: function (data) {
                    //{"success":true,"msg":"保存成功"}
                    //{"success":false,"msg":"保存失败"}
                    data = $.parseJSON(data);//把后台返回的json对象转化
                    console.log(data);
                    if (data.code == 0) {
                        $.messager.alert("温馨提示", "保存成功！", "info", function () {//保存成功，点击确定之后，刷新表格数据
                            //刷新表格数据
                            userDatagird.datagrid("reload");
                            //关闭对话框
                            userDialog.dialog("close");
                        });
                    } else {
                        $.messager.alert("温馨提示", "保存失败！", "error");
                    }
                }

            });
        },
        //新增按钮 点击事件
        add: function () {
            userDialog.dialog("open");//打开新增窗口表格
            userDialog.dialog("setTitle", "新增");//设置新增窗口标题
            userForm.form("clear");//把表格旧数据清空

        },

//编辑按钮 点击事件
        edit: function () {
            var rowData = userDatagird.datagrid("getSelected");//获取选中的行 对象
            if (rowData) {
                userDialog.dialog("open");//打开新增窗口表格
                userDialog.dialog("setTitle", "新增");//设置新增窗口标题
                userForm.form("clear");//把表格旧数据清空
                //数据回显
                userForm.form("load", rowData);
            } else {
                $.messager.alert("温馨提示：", "请选中一行数据进行编辑！", "warning");
            }
        },

//删除按钮 点击事件
        quit: function () {
            var rowData = userDatagird.datagrid("getSelected");//获取选中的行 对象
            if (rowData) {
                $.messager.confirm("温馨提示:", "你确定要注销吗？", function (yes) {
                    if (yes) {
                        $.get("/user/updateStateById?id=" + rowData.id, function (data) {
                            if (data.code == 0) {
                                $.messager.alert("温馨提示：", "注销成功", "info", function () {
                                    userDatagird.datagrid("reload");
                                });
                            } else {
                                $.messager.alert("温馨提示：", "注销失败", "error");
                            }
                        }, "json");
                    } else {

                    }
                });
            } else {
                $.messager.alert("温馨提示：", "请选中一行数据进行删除！", "warning");
            }
        }

    };

    //统一管理方法后，通过onclik事件调用方法失效，使用监听<a>标签来调用对应方法
    //监听 带有data-cmd属性的<a>标签按钮
    $("a[data-cmd]").on("click",function(){
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    });

});


function stateFormatter(value, record, index) {
    if (value == 0) {
        return "<font color='green'>正常</font>";
    } else {
        return "<font color='red'>已注销</font>";
    }
}

function adminFormatter(value, record, index) {
    if (value == 1) {
        return "<font color='green'>是</font>";
    } else {
        return "<font color='blue'>否</font>";
    }
}
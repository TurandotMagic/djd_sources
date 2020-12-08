$(function () {
    //抽取代码
    var roleDatagird, roleDialog, searchBtn, roleForm,allPermission,selfPermission

    roleDatagird = $("#role_datagird");
    roleDialog = $("#role_dialog");
    searchBtn = $("#search_btn");
    roleForm = $("#role_form");
    allPermission = $("#allPermission");
    selfPermission = $("#selfPermission");
    //datagrid数据表格
    roleDatagird.datagrid({
        fit: true,
        url: '/role/list',
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        rownumbers: true,
        toolbar: '#role_list_button',//引用数据表格的工具栏属性
        columns: [
            [
                {field: 'id', title: 'ID', align: 'center', width: 10},
                {field: 'sn', title: '编码', align: 'center', width: 10},
                {field: 'name', title: '角色名称', align: 'center', width: 10}

            ]
        ]
    });
    //dialog对话框的初始化
    roleDialog.dialog({
        title: 'My Dialog',
        width: 600,
        height: 400,
        buttons: '#role_dailog_button',
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
            roleDatagird.datagrid("load", {
                keyword: keyword
            });
        }
    });
    var allData;
    //初始所有权限数据表格
    allPermission.datagrid({
        width:250,
        height:250,
        label:'所有权限',
        url:'/permission/list',
        rownumbers:true,
        singleSelect:true,
        fitColumns: true,
        columns:[
            [
                {field: 'name',  align: 'center', width: 10}
            ]
        ],
        onDblClickRow:function(index,row){
            selfPermission.datagrid("appendRow",row);
            allPermission.datagrid("deleteRow",index);
        },
        //当数据加载成功时触发
        onLoadSuccess:function (data) {
            //$.extend(是否深度克隆,目标对象,被拷贝对象)
            allData = $.extend(true,{},data);
        }
    });
    //初始自身权限数据表格
    selfPermission.datagrid({
        width:250,
        height:250,
        label:'自有权限',
        rownumbers:true,
        singleSelect:true,
        fitColumns: true,
        columns:[
            [
                {field: 'name',  align: 'center', width: 10}
            ]
        ],
        onDblClickRow:function(index,row){
            allPermission.datagrid("appendRow",row);
            selfPermission.datagrid("deleteRow",index);
        },
        onLoadSuccess:function (data) {
            var ids = $.map(data.rows,function(item){
                        return item.id;
            });
            var allPermissionRows =  allPermission.datagrid("getRows");
            //注意: 在角色去重时，需从数组后面开始删除，防止删除第一个元素后，其它元素索引值-1
            for(i=allPermissionRows.length - 1;i>=0;i--){
                if(isStrInArray(allPermissionRows[i].id,ids)){
                    allPermission.datagrid("deleteRow",i);
                }
            }
        }
    });
    //统一管理方法
    var cmdObj = {
        //保存表格提交数据
        saveRole: function () {
            //保存表格数据前，需判断是保存还是编辑？
            var url;
            var idVal = $("[name=id]").val();
            if (idVal) {
                url = "/role/update";
            } else {
                url = "/role/save";
            }
            roleForm.form("submit", {
                url: url,
                onSubmit:function(params){
                    //获取自身权限列表数据
                    var rows = selfPermission.datagrid("getRows");
                    //封装到role对象中的permissionList中
                    for(i=0;i<rows.length;i++){
                        params["permissionList["+i+"].id"] = rows[i].id;
                    }
                },
                success: function (data) {
                    //{"success":true,"msg":"保存成功"}
                    //{"success":false,"msg":"保存失败"}
                    data = $.parseJSON(data);//把后台返回的json对象转化
                    if (data.code == 0) {
                        $.messager.alert("温馨提示", "保存成功！", "info", function () {//保存成功，点击确定之后，刷新表格数据
                            //刷新表格数据
                            roleDatagird.datagrid("reload");
                            //关闭对话框
                            roleDialog.dialog("close");
                        });
                    } else {
                        $.messager.alert("温馨提示", "保存失败！", "error");
                    }
                }

            });
        },
        //新增按钮 点击事件
        add: function () {
            roleDialog.dialog("open");//打开新增窗口表格
            roleDialog.dialog("setTitle", "新增");//设置新增窗口标题
            roleForm.form("clear");//把表格旧数据清空
            //清空自身权限的数据
            selfPermission.datagrid("loadData",{total:0,rows:[]});
            //重新加载所有权限的数据
            allPermission.datagrid("loadData",allData);

        },

//编辑按钮 点击事件
        edit: function () {
            var rowData = roleDatagird.datagrid("getSelected");//获取选中的行 对象
            if (rowData) {
                roleDialog.dialog("open");//打开新增窗口表格
                roleDialog.dialog("setTitle", "新增");//设置新增窗口标题
                roleForm.form("clear");//把表格旧数据清空
                //清空自身权限的数据
                //selfPermission.datagrid("loadData",{total:0,rows:[]});
                //重新加载所有权限的数据
                allPermission.datagrid("loadData",allData);
                var options = selfPermission.datagrid("options");
                options.url="/permission/queryListByRoleId?roleId=" + rowData.id;
                selfPermission.datagrid("load");

            } else {
                $.messager.alert("温馨提示：", "请选中一行数据进行编辑！", "warning");
            }
        },

//删除按钮 点击事件
        quit: function () {
            var rowData = roleDatagird.datagrid("getSelected");//获取选中的行 对象
            if (rowData) {
                $.messager.confirm("温馨提示:", "你确定要注销吗？", function (yes) {
                    if (yes) {
                        $.get("/role/updateStateById?id=" + rowData.id, function (data) {
                            if (data.code == 0) {
                                $.messager.alert("温馨提示：", "注销成功", "info", function () {
                                    roleDatagird.datagrid("reload");
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

//自定义一个函数来判断数组中是否存在某个字符串
function isStrInArray(str,arr) {
    var n = arr.length;
    for (var i = 0; i < n; i++) {
        if (arr[i] == str) {
            return true;
        }
    }
    return false;
}
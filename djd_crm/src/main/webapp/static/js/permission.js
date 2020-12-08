$(function () {
    //抽取代码
    var permissionDatagird;

    permissionDatagird = $("#permission_datagird");
    //datagrid数据表格
    permissionDatagird.datagrid({
        fit: true,
        url: '/permission/list',
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        rownumbers: true,
        toolbar: '#permission_list_button',//引用数据表格的工具栏属性
        columns: [
            [
                {field: 'id', title: 'ID', align: 'center', width: 10},
                {field: 'name', title: '权限名称', align: 'center', width: 10},
                {field: 'resource', title: '表达式', align: 'center', width: 10}
            ]
        ]
    });
    //统一管理方法
    var cmdObj = {

//删除按钮 点击事件
        reload: function () {
                $.messager.confirm("温馨提示:", "你确定要重新加载权限吗？", function (yes) {
                    if (yes) {
                        $.get("/permission/reload", function (data) {
                            if (data.code == 0) {
                                $.messager.alert("温馨提示：", "加载成功", "info", function () {
                                    permissionDatagird.datagrid("reload");
                                });
                            } else {
                                $.messager.alert("温馨提示：", "加载失败", "error");
                            }
                        }, "json");
                    } else {

                    }
                });
        }

    };

    //统一管理方法后，通过onclik事件调用方法失效，使用监听<a>标签来调用对应方法
    //监听 带有data-cmd属性的<a>标签按钮
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    });

});


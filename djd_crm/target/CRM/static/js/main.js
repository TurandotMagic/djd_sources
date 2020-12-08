$(function () {
    //west布局-菜单
    $("#index_menu").tree({
        url:"/static/data/menu.json",
        onClick:function (node) {
            //判断选项卡是否已经存在该面板
            var indexTabs = $("#index_tabs");
            if(indexTabs.tabs("exists",node.text)){
                //如果存在，则直接选中
                indexTabs.tabs("select",node.text)
            }else{
                //如果不存在，则创建
                indexTabs.tabs("add",{
                    title:node.text,
                    closable:true
                });
            }
        }
    });
    //center-选项卡
    $("#index_tabs").tabs({
       fit:true,
        pill:true
    });
})
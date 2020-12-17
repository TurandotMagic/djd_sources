package com.djd.crm.controller;


import com.djd.crm.entity.RoleEntity;
import com.djd.crm.service.RoleService;
import com.djd.crm.util.PageResult;
import com.djd.crm.util.Query;
import com.djd.crm.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
*
    * Title: PermissionController.java
    * Description:   前端控制器
    * @author dujindong
    * @created 2020-11-27
*/

@Controller
public class RoleController {

   @Autowired
   private RoleService service;

   @RequestMapping("/role")
   public String index(){
       return"role";
   }


    /**
    * 角色页面列表
    * @param params
    * @return
    */
   @RequestMapping("/role/list")
   @ResponseBody
   public PageResult list(@RequestParam Map<String, Object> params){
       //查询列表数据
       Query query = new Query(params);
       List<RoleEntity> dataList = service.queryList(query);
       int total = service.queryTotal(query);
       PageResult pageResult = new PageResult(total, dataList);
       return pageResult;
   }

    /**
     * 用户新增页面，角色展示勾选
     * @param params
     * @return
     */
    @RequestMapping("/role/queryList")
    @ResponseBody
    public List<RoleEntity> queryList(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<RoleEntity> dataList = service.queryList(query);
        return dataList;
    }

    /**
     * 用户新增页面，角色展示勾选
     * @param params
     * @return
     */
    @RequestMapping("/role/queryRoleByUserid")
    @ResponseBody
    public List<String> queryRoleByUserid(String userId){
        //查询列表数据
        List<String> dataList = service.queryRoleByUserid(userId);
        return dataList;
    }


    /**
    *
    */
   //@SysLog("添加")
   @RequestMapping(value = "/role/save", method = RequestMethod.POST)
   @ResponseBody
   public R save(RoleEntity entity){
       entity.setId(UUID.randomUUID().toString());
       service.save(entity);//新增角色同时，需维护角色_权限中间表关联关系
       return R.ok();
   }


   /**
    * 修改
    */
   //@SysLog("编辑")
   @RequestMapping(value = "/role/update", method = RequestMethod.POST)
   @ResponseBody
   public R update(RoleEntity entity){
       service.update(entity);
       return R.ok();
   }

   /**
    * 删除
    */
   //@SysLog("删除")
   @RequestMapping(value = "/role/deleteRoleById")
   @ResponseBody
   public R deleteRoleById( String roleId){
       service.deleteRoleById(roleId);
       return R.ok();
   }

}

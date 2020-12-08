package com.djd.crm.controller;


import com.djd.crm.entity.PermissionEntity;
import com.djd.crm.service.PermissionService;
import com.djd.crm.util.PageResult;
import com.djd.crm.util.Query;
import com.djd.crm.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;





 /**
 * 
     * Title: PermissionController.java    
     * Description:   前端控制器
     * @author dujindong       
     * @created 2020-11-27
 */
 
@Controller
public class PermissionController {

	@Autowired
	private PermissionService service;

	@RequestMapping("/permission")
	public String index(){
		return"permission";
	}

	 /**
	  * 加载权限
 	  * @param params
	  * @return
	  */
	@RequestMapping("/permission/reload")
	 @ResponseBody
	 public R reload(@RequestParam Map<String, Object> params){
		 //查询列表数据
		 service.reload();

		 return R.ok();
	 }

	 /**
	 * 查询列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/permission/list")
	@ResponseBody
	public PageResult list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<PermissionEntity> dataList = service.queryList(query);
		int total = service.queryTotal(query);
		PageResult pageResult = new PageResult(total, dataList);
		return pageResult;
	}

	 /**
	  * 根据角色id查询列表
	  * @return
	  */
	 @RequestMapping("/permission/queryListByRoleId")
	 @ResponseBody
	 public PageResult queryListByRoleId(String roleId){
		 //查询列表数据
		 List<PermissionEntity> dataList = service.queryListByRoleId(roleId);
		 PageResult pageResult = new PageResult(dataList.size(), dataList);
		 return pageResult;
	 }

	/**
	 * 
	 */
	//@SysLog("添加")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public R save(@RequestBody PermissionEntity entity){
		service.save(entity);
		return R.ok();
	}
	
	
	/**
	 * 修改
	 */
	//@SysLog("编辑")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public R update(@RequestBody PermissionEntity entity){
		service.update(entity);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	//@SysLog("删除")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public R delete(@RequestBody String[] ids){
		service.deleteBatch(ids);
		return R.ok();
	}
	
}

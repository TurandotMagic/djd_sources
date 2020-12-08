package com.djd.crm.controller;

import com.djd.crm.entity.DepartmentEntity;
import com.djd.crm.service.DepartmentService;
import com.djd.crm.util.Query;
import com.djd.crm.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 
     * Title: DepartmentController.java    
     * Description:   前端控制器
     * @author dujindong       
     * @created 2020-11-18
 */
 
@Controller
@RequestMapping("/department")
public class DepartmentController  {

	@Autowired
	private DepartmentService service;
	
	/**
	 * 查询列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<DepartmentEntity> list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<DepartmentEntity> dataList = service.queryList(query);
		//int total = service.queryTotal(query);
		
		return dataList;
	}
	
	/**
	 * 查看详情
	 */
	@RequestMapping("/info/{id}")
	@ResponseBody
	public R info(@PathVariable("id") String id){
		DepartmentEntity entity = service.queryObject(id);
		return R.ok().put("data", entity);
	}
	
	
	/**
	 * 
	 */
	//@SysLog("添加")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public R save(@RequestBody DepartmentEntity entity){
		service.save(entity);
		return R.ok();
	}
	
	
	/**
	 * 修改
	 */
	//@SysLog("编辑")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public R update(@RequestBody DepartmentEntity entity){
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

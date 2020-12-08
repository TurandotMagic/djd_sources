package com.djd.crm.controller;

import com.djd.crm.entity.UserEntity;
import com.djd.crm.service.UserService;
import com.djd.crm.util.PageResult;
import com.djd.crm.util.PermissionName;
import com.djd.crm.util.Query;
import com.djd.crm.util.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * 
     * Title: UserController.java    
     * Description:   前端控制器
     * @author dujindong       
     * @created 2020-11-18
 */
 
@Controller
public class UserController  {

	@Autowired
	private UserService service;
	
	@RequestMapping("/main")
	public String main(HttpServletRequest request){
		System.out.println("main....");
		return "main";
	}

	@RequestMapping("/user")
	public String userJsp(){
		System.out.println("方法中跳转到user.jsp");
		return "user";
	}

	/**
	 * 查询列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/user/list")
	@ResponseBody
	@RequiresPermissions("user:list")
	@PermissionName("用户列表")
	public PageResult list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<UserEntity> dataList = service.queryList(query);
		int total = service.queryTotal(query);
		PageResult pageResult = new PageResult(total,dataList);
		return pageResult;
	}
	

	/**
	 * 
	 */
	//@SysLog("添加")
	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	@ResponseBody
	@RequiresPermissions("user:save")
	@PermissionName("用户保存")
	public R save(UserEntity entity){
		//对保存对象数据进行处理
		entity.setId(UUID.randomUUID().toString());//生成用户主键
		//SimpleHash hash = new SimpleHash("md5",UserEntity.DEFAULT_PASSWORD,entity.getUsername(),1);//对密码进行加密
		//entity.setPassword(hash.toString());//设置加密后的密码
		entity.setPassword(UserEntity.DEFAULT_PASSWORD);//设置用户默认密码
		entity.setState(0);//设置用户状态，默认正常值为0
		entity.setCreateTime(new Date());
		service.save(entity);
		return R.ok();
	}
	
	
	/**
	 * 修改
	 */
	//@SysLog("编辑")
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	@ResponseBody
	@RequiresPermissions("user:update")
	@PermissionName("用户编辑")
	public R update(UserEntity entity){
		service.update(entity);
		return R.ok();
	}

    /**
     * 修改用户状态，注销操作
     */
    //@SysLog("编辑")
    @RequestMapping(value = "/user/updateStateById")
    @ResponseBody
	@RequiresPermissions("user:updateStateById")
	@PermissionName("用户注销")
    public R updateStateById(String id){
        service.updateStateById(id);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
	//@SysLog("删除")
	@RequestMapping(value = "/user/delete")
	@ResponseBody
	public R delete(String id){
		service.delete(id);
		return R.ok();
	}
	
}

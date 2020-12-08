package com.djd.crm.service.impl;

import com.djd.crm.dao.PermissionDao;
import com.djd.crm.entity.PermissionEntity;
import com.djd.crm.service.PermissionService;
import com.djd.crm.util.PermissionName;
import com.djd.crm.util.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;


/**
 * 
     * Title: PermissionServiceImpl.java    
     * Description:  服务实现类
     * @author dujindong       
     * @created 2020-11-27
 */

@Service("xdh_PermissionService")
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionDao dao;
	@Autowired
	private RequestMappingHandlerMapping handlerMapping;
	
	@Override
	public PermissionEntity queryObject(String id){
		PermissionEntity entity = dao.queryObject(id);
		return entity;
	}
	
	@Override
	public List<PermissionEntity> queryList(Map<String, Object> map){
		return dao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return dao.queryTotal(map);
	}
	
	@Override
	@Transactional
	public void save(PermissionEntity entity){
		dao.save(entity);
	}
	
	@Override
	@Transactional
	public void update(PermissionEntity entity){
		dao.update(entity);
		
	}
	
	@Override
	@Transactional
	public void delete(String id){
		dao.delete(id);
	}
	
	@Override
	@Transactional
	public void deleteBatch(String[] ids){
		dao.deleteBatch(ids);
	}

	/**
	 * 加载权限
	 * @return
	 */
	@Override
	@Transactional
	public void reload() {
		//权限数据去重操作
		List<PermissionEntity> permissionList = dao.queryList(new Query());
		Set<String> permissionSet = new HashSet<>();
		for (PermissionEntity permissionEntity : permissionList) {
			permissionSet.add(permissionEntity.getResource());
		}


		//获取所有的控制器中的所有方法
		Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
		Collection<HandlerMethod> methodCollection = handlerMethods.values();
		RequiresPermissions method ;
		String resource;//用于存储权限表达式
		String name ;//用于存储权限名称
		for (HandlerMethod handlerMethod : methodCollection) {//遍历方法，判断方法上是否有使用对应的权限注解标签
			method = handlerMethod.getMethodAnnotation(RequiresPermissions.class);
			if(method!=null){
				//获取注解中内容，封装成对象保存入库
				resource = method.value()[0];
				//对比权限集合中是否已包含该权限表达式,结果为false,再添加入库
				if(!permissionSet.contains(resource)){
					PermissionName methodAnnotation = handlerMethod.getMethodAnnotation(PermissionName.class);
					if(methodAnnotation != null){
						name =  methodAnnotation.value();
					}else{
						name = "";
					}
					PermissionEntity permissionEntity = new PermissionEntity();
					permissionEntity.setId(UUID.randomUUID().toString());
					permissionEntity.setName(name);
					permissionEntity.setResource(resource);
					this.save(permissionEntity);
				}

			}

		}


	}

	@Override
	public List<PermissionEntity> queryListByRoleId(String roleId) {
		return dao.queryListByRoleId(roleId);
	}
}

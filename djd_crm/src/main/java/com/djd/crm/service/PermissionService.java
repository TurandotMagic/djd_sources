package com.djd.crm.service;


import com.djd.crm.entity.PermissionEntity;

import java.util.List;
import java.util.Map;


/**
 * 
     * Title: PermissionService.java    
     * Description:  服务类
     * @author dujindong       
     * @created 2020-11-27
 */

public interface PermissionService  {
	PermissionEntity queryObject(String id);
	
	List<PermissionEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PermissionEntity entity);
	
	void update(PermissionEntity entity);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void reload();

    List<PermissionEntity> queryListByRoleId(String roleId);
}

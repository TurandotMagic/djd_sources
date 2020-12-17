package com.djd.crm.service;


import com.djd.crm.entity.RoleEntity;

import java.util.List;
import java.util.Map;


/**
 * 
     * Title: PermissionService.java    
     * Description:  服务类
     * @author dujindong       
     * @created 2020-11-27
 */

public interface RoleService {
	RoleEntity queryObject(String id);
	
	List<RoleEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(RoleEntity entity);
	
	void update(RoleEntity entity);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    List<String> queryRoleByUserid(String userId);

	int deleteRoleById(String roleId);
}

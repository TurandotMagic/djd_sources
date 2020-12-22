package com.djd.crm.service;

import com.djd.crm.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 
     * Title: UserService.java    
     * Description:  服务类
     * @author dujindong       
     * @created 2020-11-18
 */

public interface UserService  {
	UserEntity queryObject(String id);
	
	List<UserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserEntity entity);
	
	void update(UserEntity entity);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	void updateStateById(String id);

    UserEntity queryObjectByUsername(String username);
}

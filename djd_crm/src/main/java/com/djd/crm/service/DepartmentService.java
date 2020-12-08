package com.djd.crm.service;

import com.djd.crm.entity.DepartmentEntity;

import java.util.List;
import java.util.Map;

/**
 * 
     * Title: DepartmentService.java    
     * Description:  服务类
     * @author dujindong       
     * @created 2020-11-18
 */

public interface DepartmentService {
	DepartmentEntity queryObject(String id);
	
	List<DepartmentEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DepartmentEntity entity);
	
	void update(DepartmentEntity entity);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}

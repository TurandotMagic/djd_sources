package com.djd.crm.dao;


import com.djd.crm.entity.DepartmentEntity;

import java.util.List;
import java.util.Map;

/**
 * 
     * Title: DepartmentDao.java    
     * Description:  
     * @author dujindong       
     * @created 2020-11-18
 */

public interface DepartmentDao  {
    DepartmentEntity queryObject(String id);

    List<DepartmentEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(DepartmentEntity entity);

    void update(DepartmentEntity entity);

    void delete(String id);

    void deleteBatch(String[] ids);
}
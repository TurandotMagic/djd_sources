package com.djd.crm.dao;

import com.djd.crm.entity.PermissionEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
     * Title: PermissionDao.java    
     * Description:  
     * @author dujindong       
     * @created 2020-11-27
 */

public interface PermissionDao  {
    PermissionEntity queryObject(String id);

    List<PermissionEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(PermissionEntity entity);

    void update(PermissionEntity entity);

    void delete(String id);

    void deleteBatch(String[] ids);

    void updateStateById(String id);

    List<PermissionEntity> queryListByRoleId(@Param("roleId") String roleId);
}
package com.djd.crm.dao;

import com.djd.crm.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
     * Title: UserDao.java    
     * Description:  
     * @author dujindong       
     * @created 2020-11-18
 */

public interface UserDao  {
    UserEntity queryObject(String id);

    List<UserEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(UserEntity entity);

    void update(UserEntity entity);

    void delete(String id);

    void deleteBatch(String[] ids);

    void updateStateById(String id);

    void insertRoleRelation(@Param("userId") String userId,@Param("roleId") String roleId);

    void deleteRoleRelation(String userId);
}
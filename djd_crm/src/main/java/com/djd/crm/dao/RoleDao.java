package com.djd.crm.dao;

import com.djd.crm.entity.RoleEntity;
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

public interface RoleDao {
    RoleEntity queryObject(String id);

    List<RoleEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(RoleEntity entity);

    void update(RoleEntity entity);

    void delete(String id);

    void deleteBatch(String[] ids);

    void saveRoleAndPermission(@Param("roleId") String roleId,@Param("permissionId") String permissionId);

    List<String> queryRoleByUserid(String userId);

    int deleteRoleById(String roleId);

    void deletePermissionById(String id);
}
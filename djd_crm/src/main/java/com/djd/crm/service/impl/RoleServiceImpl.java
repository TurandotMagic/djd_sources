package com.djd.crm.service.impl;

import com.djd.crm.dao.RoleDao;
import com.djd.crm.entity.PermissionEntity;
import com.djd.crm.entity.RoleEntity;
import com.djd.crm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 
     * Title: PermissionServiceImpl.java    
     * Description:  服务实现类
     * @author dujindong       
     * @created 2020-11-27
 */

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao dao;


	@Override
	public RoleEntity queryObject(String id) {
		return dao.queryObject(id);
	}

	@Override
	public List<RoleEntity> queryList(Map<String, Object> map) {
		return dao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return dao.queryTotal(map);
	}

	@Override
	@Transactional
	public void save(RoleEntity entity) {
		//新增角色同时，中间表也需要新增对应关系数据
        if(entity.getPermissionList().size()>0){
            for (PermissionEntity permissionEntity : entity.getPermissionList()) {
                dao.saveRoleAndPermission(entity.getId(),permissionEntity.getId());
            }
        }
        dao.save(entity);
	}

	@Override
	@Transactional
	public void update(RoleEntity entity) {
		dao.update(entity);
	}

	@Override
	@Transactional
	public void delete(String id) {
		dao.delete(id);
	}

	@Override
	@Transactional
	public void deleteBatch(String[] ids) {
		dao.deleteBatch(ids);
	}
}

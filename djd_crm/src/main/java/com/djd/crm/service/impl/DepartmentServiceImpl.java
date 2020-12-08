package com.djd.crm.service.impl;

import com.djd.crm.dao.DepartmentDao;
import com.djd.crm.entity.DepartmentEntity;
import com.djd.crm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 
     * Title: DepartmentServiceImpl.java    
     * Description:  服务实现类
     * @author dujindong       
     * @created 2020-11-18
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao dao;
	
	@Override
	public DepartmentEntity queryObject(String id){
		DepartmentEntity entity = dao.queryObject(id);
		return entity;
	}
	
	@Override
	public List<DepartmentEntity> queryList(Map<String, Object> map){
		return dao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return dao.queryTotal(map);
	}


	@Override
	@Transactional
	public void save(DepartmentEntity entity){
		dao.save(entity);
	}

	@Override
	@Transactional
	public void update(DepartmentEntity entity){
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
}

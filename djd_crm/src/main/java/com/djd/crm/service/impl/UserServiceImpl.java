package com.djd.crm.service.impl;

import com.djd.crm.dao.UserDao;
import com.djd.crm.entity.UserEntity;
import com.djd.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 
     * Title: UserServiceImpl.java    
     * Description:  服务实现类
     * @author dujindong       
     * @created 2020-11-18
 */

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public UserEntity queryObject(String id){
		UserEntity entity = dao.queryObject(id);
		return entity;
	}
	
	@Override
	public List<UserEntity> queryList(Map<String, Object> map){
		return dao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return dao.queryTotal(map);
	}


	@Override
	@Transactional
	public void save(UserEntity entity){
		dao.save(entity);
		//int num = 1/0;
	}

	@Override
	@Transactional
	public void update(UserEntity entity){
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

	@Override
	@Transactional
	public void updateStateById(String id) {
		dao.updateStateById(id);
	}
}

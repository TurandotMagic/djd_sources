package com.djd.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 
     * Title: UserEntity.java    
     * Description:  
     * @author dujindong       
     * @created 2020-11-18
 */

public class UserEntity  {

	public static final int STATE_NORMAL = 0;	//正常状态
	public static final int STATE_CANCEL = 1;	//注销状态
	public static final String DEFAULT_PASSWORD = "11111";//默认密码

	private String id;

	private String username;

	private String name;
	
	private String password;
	
	private String tel;
	
	private String email;
	
	private String dept;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT-8")
	private Date createTime;
	
	private int state;
	
	private int isAdmin;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

}

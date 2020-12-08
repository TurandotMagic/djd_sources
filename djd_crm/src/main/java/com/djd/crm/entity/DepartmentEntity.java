package com.djd.crm.entity;

/**
 * 
     * Title: DepartmentEntity.java    
     * Description:  
     * @author dujindong       
     * @created 2020-11-18
 */

public class DepartmentEntity  {


	
	private String id;
	
	private String sn;
	
	private String deptName;
	
	private String state;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}

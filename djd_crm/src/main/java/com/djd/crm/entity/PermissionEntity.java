package com.djd.crm.entity;



/**
 * 
     * Title: PermissionEntity.java    
     * Description:  
     * @author dujindong       
     * @created 2020-11-27
 */

public class PermissionEntity  {

    private static final long serialVersionUID = 1L;

	
	private String id;
	
	private String name;
	
	private String resource;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

}

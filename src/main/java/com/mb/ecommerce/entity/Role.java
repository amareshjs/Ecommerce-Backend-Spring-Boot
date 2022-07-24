package com.mb.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
	private String roleName;
	private String roleDescription;
	
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDiscription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDiscription) {
		this.roleDescription = roleDiscription;
	}
	
	

}

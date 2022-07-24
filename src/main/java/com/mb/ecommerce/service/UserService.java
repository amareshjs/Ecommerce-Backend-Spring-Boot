package com.mb.ecommerce.service;

import com.mb.ecommerce.entity.User;

public interface UserService {
	
	public User registerNewUser(User user);
	public void initRolesAndUser();
	public String getEncodedPassword(String password);
	public User registerNewAdmin(User user);

}

package com.mb.ecommerce.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mb.ecommerce.dao.RoleDao;
import com.mb.ecommerce.dao.UserDao;
import com.mb.ecommerce.entity.Role;
import com.mb.ecommerce.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User registerNewUser(User user) {
		
		Role role=roleDao.findById("User").get();
		Set<Role> roles=new HashSet<>();
		roles.add(role);
		user.setRole(roles);
		
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));	
		return userDao.save(user);
	}
	
	@Override
	public User registerNewAdmin(User user) {
		
		Role role=roleDao.findById("Admin").get();
		Set<Role> roles=new HashSet<>();
		roles.add(role);
		user.setRole(roles);
		
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));	
		return userDao.save(user);
	}
	
	@Override
	public void initRolesAndUser() {
		Role adminRole=new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin Role");
		roleDao.save(adminRole);
		
		Role userRole =new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default Role for newly created record");
		roleDao.save(userRole);
		
//		User adminUser=new User();
//		adminUser.setUserFirstName("admin");
//		adminUser.setUserLastName("admin");
//		adminUser.setUserName("Admin123");
//		adminUser.setUserPassword(getEncodedPassword("Admin@123"));
//		Set<Role> adminRoles=new HashSet<>();
//		adminRoles.add(adminRole);
//		adminUser.setRole(adminRoles);
//		userDao.save(adminUser);
		
	}
	
	@Override
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

}

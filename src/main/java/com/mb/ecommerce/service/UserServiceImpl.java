package com.mb.ecommerce.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mb.ecommerce.dao.RoleDao;
import com.mb.ecommerce.dao.UserDao;
import com.mb.ecommerce.entity.Role;
import com.mb.ecommerce.entity.User;
import com.mb.ecommerce.exception.BusinessException;
import com.mb.ecommerce.exception.UserAlreadyExistException;

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
		
		Optional<User> existingUser=userDao.findById(user.getUserName());
		if(existingUser.isEmpty()) {
			try {
			user.setUserPassword(getEncodedPassword(user.getUserPassword()));	
			return userDao.save(user);			
		}
			catch(Exception e) {
				
				throw new BusinessException("700",e.getMessage());
			}
		}
		else
		{
			throw new UserAlreadyExistException("User Already Exist");
		}
	}
	
	@Override
	public User registerNewAdmin(User user) {
		
		Role role=roleDao.findById("Admin").get();
		Set<Role> roles=new HashSet<>();
		roles.add(role);
		user.setRole(roles);
		Optional<User> existingUser=userDao.findById(user.getUserName());
		if(existingUser.isEmpty()) {
			try {
			user.setUserPassword(getEncodedPassword(user.getUserPassword()));	
			return userDao.save(user);			
		}
			catch(Exception e) {
				
				throw new BusinessException("700", e.getMessage());
			}
		}
		else
		{
			throw new UserAlreadyExistException("Admin Already Exist");
		}
		
		
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
	}
	
	@Override
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

}

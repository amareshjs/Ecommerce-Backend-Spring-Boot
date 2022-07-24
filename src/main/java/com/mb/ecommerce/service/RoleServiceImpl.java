package com.mb.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ecommerce.dao.RoleDao;
import com.mb.ecommerce.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao; 

	@Override
	public Role createNewRole(Role role) {
		return roleDao.save(role);
	}
}

package com.mb.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mb.ecommerce.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, String> {

}

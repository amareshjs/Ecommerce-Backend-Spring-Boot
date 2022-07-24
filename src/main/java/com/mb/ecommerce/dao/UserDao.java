package com.mb.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.ecommerce.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {

}

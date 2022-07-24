package com.mb.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mb.ecommerce.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Integer> {

}

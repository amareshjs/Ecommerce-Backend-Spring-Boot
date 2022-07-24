package com.mb.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mb.ecommerce.entity.Products;

public interface ProductDao extends JpaRepository<Products, Long> {

}

package com.mb.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mb.ecommerce.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {
	
	@Query(value="SELECT * FROM products  WHERE MATCH (product_name,product_brand,product_category,product_type)"
	+" AGAINST (?1)",nativeQuery=true)
	public List<Product> search(String keyword);
	
	@Query(value="SELECT * FROM products  WHERE product_price BETWEEN(?1) AND (?2)",nativeQuery=true)
	public List<Product> filterByPriceRange(int max,int min);

}

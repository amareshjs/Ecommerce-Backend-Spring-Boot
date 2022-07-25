package com.mb.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mb.ecommerce.entity.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Long>
{

	boolean existsByProductId(long id);
	
	@Query(value="SELECT * FROM ecommerce_backend.cart where user_id=(?1) and is_payment_done=0",nativeQuery=true)
	public List<Cart> getCartProducts(String userId);
	
	
	
}
package com.mb.ecommerce.service;

import java.util.List;

import com.mb.ecommerce.entity.Cart;
import com.mb.ecommerce.model.CartModel;

public interface CartService {

	public String addTocart(CartModel cartModel);
	
	public List<Cart> getCartProducts(String userId);
}

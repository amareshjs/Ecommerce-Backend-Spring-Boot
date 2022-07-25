package com.mb.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.ecommerce.entity.Cart;
import com.mb.ecommerce.model.CartModel;
import com.mb.ecommerce.service.CartServiceImpl;

@RestController
@RequestMapping("/api/cart")
public class CartController
{
	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('User')")
	public String addTocart(@RequestBody CartModel CartModel) {
		return cartServiceImpl.addTocart(CartModel);
	}
	
	
	@GetMapping()
	@PreAuthorize("hasRole('User')")
	public List<Cart> getCartProducts(){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		String username = userDetails.getUsername();
		System.out.println(username);
		return cartServiceImpl.getCartProducts(username);
	}
	
}	
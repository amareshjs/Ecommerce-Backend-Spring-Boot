package com.mb.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.ecommerce.entity.Product;
import com.mb.ecommerce.service.JwtService;
import com.mb.ecommerce.service.ProductServiceImpl;
import com.mb.ecommerce.service.UserServiceImpl;


@RestController
@RequestMapping("/api/v1/products")
@PreAuthorize("hasRole('Admin')")
public class AdminController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@PostMapping()
	
	public ResponseEntity<Product> RegisterNewProduct( @RequestBody Product product ) {
		productServiceImpl.saveProduct(product);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct( @PathVariable long id,@RequestBody Product product ) {
		productServiceImpl.updateProduct(id,product);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct( @PathVariable long id ) {
		productServiceImpl.deleteProduct(id);
		return "Product Deleted";
	}
	
	
	


}

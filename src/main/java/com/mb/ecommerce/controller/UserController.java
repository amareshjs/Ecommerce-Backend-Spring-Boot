package com.mb.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.ecommerce.entity.Product;
import com.mb.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@PreAuthorize("hasAnyRole('Admin','User')")
public class UserController {
	
	@Autowired
	private ProductService productService;
	
	//search products by name,brand,etc,
	@GetMapping("/search/{keyword}")
    public List<Product> search(@PathVariable String keyword) {
        return productService.search(keyword);
    }
	
	//filter products by price range,
	@GetMapping("/filter/{min}/{max}")
    public List<Product> filterByPrice(@PathVariable int min,@PathVariable int max) {
        return productService.filterByPrice(min, max);
    }
	
	@GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable long id) {
        return productService.getProductDetails(id);
    }

}

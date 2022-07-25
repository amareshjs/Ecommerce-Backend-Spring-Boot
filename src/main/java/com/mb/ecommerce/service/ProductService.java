package com.mb.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.mb.ecommerce.entity.Product;

public interface ProductService {

	public void saveProduct(Product product);
	public List<Product> getAllProducts();
	public void deleteProduct(long id);
	public String updateProduct(Long id, Product product);
	public List<Product> search(String keyword);
	public List<Product> filterByPrice(int min,int max);
	public Optional<Product> getProductDetails(long id);
}

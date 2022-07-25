package com.mb.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ecommerce.dao.ProductDao;
import com.mb.ecommerce.entity.Product;
import com.mb.ecommerce.exception.BusinessException;
import com.mb.ecommerce.exception.EmptyInputException;
import com.mb.ecommerce.exception.NoDataFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public void saveProduct(Product product) {
		if(product.getProductName().isEmpty() || 
				product.getProductBrand().isEmpty() ||
				product.getProductCategory().isEmpty() ||
				product.getProductDiscription().isEmpty() ||
				product.getProductType().isEmpty()||
				product.getProductPrice()==0 ||
				product.getProductHeight()==0||
				product.getProductWidth()==0) {
			throw new EmptyInputException("");
		}
		try {
			productDao.save(product);
		}
		catch(Exception e) {
			throw new BusinessException("700","Something Went Wring in service"+e.getMessage());
		}
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> result=productDao.findAll();
		if(result.isEmpty()) {
			throw new NoDataFoundException();
		}
		else {
			return result;
		}
	}

	@Override
	public void deleteProduct(long id) {
		if(id!=0) {
			try {
			productDao.deleteById(id);
			}
			catch(Exception e) {
				throw new BusinessException("700",e.getMessage());
			}
		}

	}
	
	@Override
	public String updateProduct(Long id, Product product)
	{
		
		Optional<Product> productOptional = productDao.findById(id);
		if (!productOptional.isPresent())
		{
//			throw new CustomException("Product with id :: " + id + " not found", ErrorCode.NOT_FOUND);
			throw new BusinessException("Product Not found...","404");
		}
		Product oldProduct = productOptional.get();
		oldProduct.setProductName(product.getProductName());
		oldProduct.setProductType(product.getProductType());
		oldProduct.setProductCategory(product.getProductCategory());
		oldProduct.setProductBrand(product.getProductBrand());
		oldProduct.setProductPrice(product.getProductPrice());
		oldProduct.setProductWidth(product.getProductWidth());
		oldProduct.setProductHeight(product.getProductHeight());
		oldProduct.setProductDiscription(product.getProductDiscription());
		try
		{
			productDao.save(oldProduct);
		}
		catch (Exception e)
		{
			throw new BusinessException("Unable update product","404");
		}
		
		return "Product with ID :: " + id + " updated !";
	}
	
	
	
	//search product by name,category,type,brand
	@Override
	public List<Product> search(String keyword) {
		if (keyword != null)
		{			
			List<Product> products= productDao.search(keyword);
			int count=products.size();	
			return products;
		}
		return productDao.findAll();
	}
	
	@Override
	public List<Product> filterByPrice(int min,int max){
		return productDao.filterByPriceRange(min, max);
	}

	@Override
	public Optional<Product> getProductDetails(long id) {
		return productDao.findById(id);
	}












	

}

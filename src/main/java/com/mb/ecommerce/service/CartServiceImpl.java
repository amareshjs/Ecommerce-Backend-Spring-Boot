package com.mb.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mb.ecommerce.dao.CartDao;
import com.mb.ecommerce.dao.ProductDao;
import com.mb.ecommerce.dao.UserDao;
import com.mb.ecommerce.entity.Cart;
import com.mb.ecommerce.entity.Product;
import com.mb.ecommerce.entity.User;
import com.mb.ecommerce.exception.BusinessException;
import com.mb.ecommerce.model.CartModel;

@Service
public class CartServiceImpl implements CartService {
	
	
	@Autowired
	private CartDao cartDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private UserDao userDao;
	
	

	@Override
	public String addTocart(CartModel cartModel) {
				Optional<Cart> oldProductCart=cartDao.findById(cartModel.getProductId());
				
		if (cartDao.existsByProductId(cartModel.getProductId())) {
			throw new BusinessException("Product already in cart", "400");
		}
		Optional<Product> optionalProduct = productDao.findById(cartModel.getProductId());
		Optional<User> optionalUser = userDao.findById(cartModel.getUserId());

		if (!optionalUser.isPresent()) {
			throw new BusinessException("User Not Found", "404");
		}
		if (!optionalProduct.isPresent()) {
			throw new BusinessException("Product Not Found", "405");
		}
		Product product = optionalProduct.get();
		User user = optionalUser.get();
		Cart cart = new Cart();
		cart.setUser(user);
		cart.setProduct(product);
		cart.setQuantity(cartModel.getQuantity());
		cart.setIsPaymentDone(false);
		cartDao.save(cart);
		return "add to cart work from service";
	}

	@Override
	public List<Cart> getCartProducts(String userId) {
		try {

			return cartDao.getCartProducts(userId);
		}
		catch(Exception e) {
			throw  new BusinessException("700",e.getMessage());
		}
	}
}
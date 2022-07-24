package com.mb.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.mb.ecommerce.audit.Auditable;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Cart extends Auditable<String>  {
	
	@Id
	private int cartId;
	private int productQuantity;
	private int isPaymentDone;
	private long productId;
	private long userId;
	
	public Cart() {
		
	}
	public Cart(int productQuantity, int isPaymentDone, long productId, long userId,int cartId) {
		super();
		this.productQuantity = productQuantity;
		this.isPaymentDone = isPaymentDone;
		this.productId = productId;
		this.userId = userId;
		this.cartId=cartId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getIsPaymentDone() {
		return isPaymentDone;
	}
	public void setIsPaymentDone(int isPaymentDone) {
		this.isPaymentDone = isPaymentDone;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	
	
	
	
	
	

}

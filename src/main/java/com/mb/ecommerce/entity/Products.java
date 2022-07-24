package com.mb.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.mb.ecommerce.audit.Auditable;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Products extends Auditable<String> {

	@Id
	private long id;
	private String productName;
	private String productCategory;
	private String productDiscription;
	private float productPrice;
	private int productWidth;
	private int productHeight;
	private String productType;

	public Products() {
	}

	public Products(long id, String productName, String productCategory, String productDiscription, float productPrice,
			int productWidth, int productHeight, String productType) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDiscription = productDiscription;
		this.productPrice = productPrice;
		this.productWidth = productWidth;
		this.productHeight = productHeight;
		this.productType = productType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDiscription() {
		return productDiscription;
	}

	public void setProductDiscription(String productDiscription) {
		this.productDiscription = productDiscription;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductWidth() {
		return productWidth;
	}

	public void setProductWidth(int productWidth) {
		this.productWidth = productWidth;
	}

	public int getProductHeight() {
		return productHeight;
	}

	public void setProductHeight(int productHeight) {
		this.productHeight = productHeight;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
}

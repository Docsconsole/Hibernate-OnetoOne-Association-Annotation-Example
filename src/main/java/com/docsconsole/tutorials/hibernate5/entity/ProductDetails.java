package com.docsconsole.tutorials.hibernate5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_DETAILS")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PROD_DET_ID")
	private long prodDetailsId;
	@Column(name = "PROD_NAME")
	private String prodName;
	@Column(name = "PROD_DESC")
	private String prodDescription;
	@Column(name = "PROD_PRICE")
	private float prodPrice;

	@OneToOne(mappedBy = "prodDetails")
	private Product product;

	public ProductDetails() {
	}

	public long getProdDetailsId() {
		return prodDetailsId;
	}

	public void setProdDetailsId(long prodDetailsId) {
		this.prodDetailsId = prodDetailsId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	public float getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(float prodPrice) {
		this.prodPrice = prodPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
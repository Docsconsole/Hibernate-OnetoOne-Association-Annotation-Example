package com.docsconsole.tutorials.hibernate5.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PROD_ID")
	private long prodId;
	@Column(name = "PROD_NAME")
	private String prodName;
	@Column(name = "PROD_VENDOR")
	private String prodVendor;
	@OneToOne(cascade = CascadeType.ALL)

	@PrimaryKeyJoinColumn
	private ProductDetails prodDetails;

	public Product() {
	}

	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdVendor() {
		return prodVendor;
	}

	public void setProdVendor(String prodVendor) {
		this.prodVendor = prodVendor;
	}

	public ProductDetails getProdDetails() {
		return prodDetails;
	}

	public void setProdDetails(ProductDetails prodDetails) {
		this.prodDetails = prodDetails;
	}

}
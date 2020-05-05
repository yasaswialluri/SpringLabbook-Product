package com.cg.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="product_table")
public class Product {

	@Id
	@Column(name="pid")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mygen")
	@SequenceGenerator(name="mygen",sequenceName="p_seq",allocationSize=1)
	/*
	 * create  sequence in orcale DB
	 * create sequence employee_seq start with 1000
	 */
	private int productId;
	
	@Column(name="pname",length=15)
	private String productName;
	
	@Column(name="price")
	private double price ;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
	
	
}

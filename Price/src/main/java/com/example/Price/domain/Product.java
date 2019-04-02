package com.example.Price.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Product implements Serializable{

	@Id
	private String productId;
	


	@Column
	private String  title;
	
	
	private ArrayList <ColorSwatch> colorSwatches;
	@Column
	private String nowPrice;
	@Column
	private String priceLabel;
	
	public Product(String productId, String title, String nowPrice, String priceLabel) {
	
		this.productId = productId;
		this.title = title;
		this.nowPrice = nowPrice;
		this.priceLabel = priceLabel;
	}
	
	
	public Product() {
	}
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(String nowPrice) {
		this.nowPrice = nowPrice;
	}

	public String getPriceLabel() {
		return priceLabel;
	}

	public void setPriceLabel(String priceLabel) {
		this.priceLabel = priceLabel;
	}


	public ArrayList<ColorSwatch> getColorSwatches() {
		return colorSwatches;
	}


	public void setColorSwatches(ArrayList<ColorSwatch> colorSwatches) {
		this.colorSwatches = colorSwatches;
	}

	
	
	
	
}

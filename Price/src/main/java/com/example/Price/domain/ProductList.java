package com.example.Price.domain;

import java.util.ArrayList;

public class ProductList {

	ArrayList <ProductInfo> products = new ArrayList<ProductInfo>() ;

	public ArrayList<ProductInfo> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<ProductInfo> products) {
		this.products = products;
	}
	
}

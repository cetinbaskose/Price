package com.example.Price.domain;

import java.util.ArrayList;

public class ProductInfo {

	private String productId;
	private String type;
	private String title;
	private String code;

	Price price;

	ArrayList<ColorSwatch> colorSwatches = new ArrayList<ColorSwatch>();

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public ArrayList<ColorSwatch> getColorSwatches() {
		return colorSwatches;
	}

	public void setColorSwatches(ArrayList<ColorSwatch> colorSwatches) {
		this.colorSwatches = colorSwatches;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getDiscountAmount() {
		if (price.getWas().isEmpty())
			return 0;

		float was = Float.parseFloat(price.getWas());
		float now = Float.parseFloat(price.getNow().getTo());
		return was - now;

	}

}

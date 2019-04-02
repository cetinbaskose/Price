package com.example.Price.domain;

import java.util.HashMap;

public class ColorSwatch {

	String color;
	String rgbColor;
	String skuId;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
		setRgbColor(getRgbCode(color));
	}
	public String getRgbColor() {
		return rgbColor;
	}
	public void setRgbColor(String rgbColor) {
		this.rgbColor = rgbColor;
	}
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuid) {
		this.skuId = skuid;
	}
	
	
	public String getRgbCode (String color)
	{
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("Dark Grey","#A9A9A9");
		hmap.put("Dark Mauve","#8B008B");
		hmap.put("Dark Teal","#76FF8B");
		hmap.put("Berry","#6600FB");
		hmap.put("Burgundy","#45008B");
		hmap.put("Navy","#64FF8B");
		hmap.put("Royal Blue","#10008B");
		hmap.put("Navy","#75008B");
		hmap.put("Mimosa Yellow","#FF008B");
	
		return hmap.get(color);
	}



	
}

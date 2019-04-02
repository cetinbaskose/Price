package com.example.Price.domain;

import java.math.BigDecimal;

public class Price {

	String was;
	String then1;
	String then2;
	Now now = new Now();
	
	String currency;

	public String getWas() {
		return was;
	}

	public void setWas(String was) {
		this.was = was;
	}

	public String getThen1() {
		return then1;
	}

	public void setThen1(String then1) {
		this.then1 = then1;
	}

	public String getThen2() {
		return then2;
	}

	public void setThen2(String then2) {
		this.then2 = then2;
	}

	public Now getNow() {
		return now;
	}

	public void setNow(Now now) {
		this.now = now;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}

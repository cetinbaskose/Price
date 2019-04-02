package com.example.Price.domain;

public class Now {

	String from;
    String to;

	public Now() {
	}

	public Now(String to) {
		this.to = to;
	}

	public Now(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
}

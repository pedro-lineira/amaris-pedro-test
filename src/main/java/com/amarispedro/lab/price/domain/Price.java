package com.amarispedro.lab.price.domain;

import java.time.LocalDateTime;

////////////////////////////////////////////
///	Price: Product-PriceList Scheduler
//////////////////////////////////////////
public final class Price {
	
	private String brand_id;
	private String product_id;
	private String priceList;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Integer priority;
	private Float price;
	private String currency;
	
	public Price () {}
	

	public Price(String brand_id, String product_id, String priceList, LocalDateTime startDate, LocalDateTime endDate, Integer priority,
			Float price, String currency) {
			
		super();
		this.brand_id = brand_id;
		this.product_id = product_id;
		this.priceList = priceList;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.price = price;
		this.currency = currency;
	}
	
	
	public String getBrand_id() {
		return brand_id;
	}


	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}


	public String getProduct_id() {
		return product_id;
	}


	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


	public String getPriceList() {
		return priceList;
	}


	public void setPriceList(String priceList) {
		this.priceList = priceList;
	}


	public LocalDateTime getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}


	public LocalDateTime getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}


	public Integer getPriority() {
		return priority;
	}


	public void setPriority(Integer priority) {
		this.priority = priority;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
}

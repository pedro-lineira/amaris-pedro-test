package com.amarispedro.lab.price.infrastructure.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.amarispedro.lab.price.infrastructure.configuration.PriceSearchConfig;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "PRICE")
@IdClass(PriceIdJPA.class)	
public final class PriceJPA {
	
	@Id
	@Column(name = "BRAND_ID", nullable = false, length = 10)
	private String brand_id;
	@Id
	@Column(name = "PRODUCT_ID", nullable = false, length = 50)
	private String product_id;
	@Id
	@Column(name = "PRICELIST", nullable = false, length = 10)
	private String priceList;
	
	@Column(name = "STARTDATE")
	@JsonFormat(pattern=PriceSearchConfig.DATE_FORMAT)  
	private LocalDateTime startDate;
	
	@Column(name = "ENDDATE")
	@JsonFormat(pattern=PriceSearchConfig.DATE_FORMAT)  
	private LocalDateTime endDate;
	
	@Column(name = "PRIORITY")
	private Integer priority;
	
	@Column(name = "PRICE")
	private Float price;
	
	@Column(name = "CURRENCY", nullable = false, length = 10)
	private String currency;
	
	
	protected PriceJPA() {}
	

	public PriceJPA(String brand_id, String product_id, String priceList, LocalDateTime startDate, LocalDateTime endDate, Integer priority,
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

	@Override
	public String toString() {
		return "Price [brand_id=" + brand_id + ", product_id=" + product_id + ", priceList=" + priceList
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", priority=" + priority + ", price=" + price
				+ ", currency=" + currency + "]";
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

package com.amarispedro.lab.price.infrastructure.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PriceDTO {
	
	public PriceDTO() {}
	
	@JsonFormat()
	private String brand_id;
	@JsonFormat()
	private String product_id;
	@JsonFormat()
	private String priceList;
	@JsonFormat(pattern="yyyy-MM-dd-HH.mm.ss")
	private LocalDateTime startDate;
	@JsonFormat(pattern="yyyy-MM-dd-HH.mm.ss")
	private LocalDateTime endDate;
	@JsonFormat()
	private Float price;
	

	
	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public void setPriceList(String priceList) {
		this.priceList = priceList;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	

}

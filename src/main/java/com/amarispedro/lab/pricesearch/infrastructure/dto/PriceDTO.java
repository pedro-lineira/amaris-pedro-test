package com.amarispedro.lab.pricesearch.infrastructure.dto;

import java.time.LocalDateTime;

import com.amarispedro.lab.pricesearch.infrastructure.configuration.PriceSearchConfig;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PriceDTO {
	
	@JsonFormat()
	private String brand_id;
	@JsonFormat()
	private String product_id;
	@JsonFormat()
	private String priceList;
	@JsonFormat(pattern=PriceSearchConfig.DATE_FORMAT)
	private LocalDateTime startDate;
	@JsonFormat(pattern=PriceSearchConfig.DATE_FORMAT)
	private LocalDateTime endDate;
	@JsonFormat()
	private Float price;
	
	
	public PriceDTO() {}

	
	public PriceDTO(String brand_id, String product_id, String priceList, LocalDateTime startDate,
			LocalDateTime endDate, Float price) {
		super();
		this.brand_id = brand_id;
		this.product_id = product_id;
		this.priceList = priceList;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}

	
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

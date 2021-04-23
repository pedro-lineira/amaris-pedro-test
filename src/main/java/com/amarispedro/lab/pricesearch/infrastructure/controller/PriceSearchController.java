package com.amarispedro.lab.pricesearch.infrastructure.controller;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.amarispedro.lab.price.domain.querymodel.Price;
import com.amarispedro.lab.price.domain.querymodel.exception.MoreThanOnePriceFound;
import com.amarispedro.lab.price.domain.querymodel.exception.PriceNotFound;
import com.amarispedro.lab.pricesearch.application.PriceSearch;
import com.amarispedro.lab.pricesearch.infrastructure.dto.PriceDTO;

@RestController
@RequestMapping(PriceSearchController.PRICE_SEARCH_RESOURCE)
public class PriceSearchController {
	
	public static final String PRICE_SEARCH_RESOURCE = "/amarispedrotest";
	public static final String URL_MAPPING = "/getPriceByDate/{brand_id}/{product_id}/{date}";
	
	@Autowired
    private ModelMapper modelMapper;

	@Autowired
	private PriceSearch priceService;
	
	@GetMapping(PriceSearchController.URL_MAPPING)
	public PriceDTO getPriceByDate(@PathVariable String brand_id, @PathVariable String product_id, @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss") LocalDateTime date)
			throws MoreThanOnePriceFound, PriceNotFound, MethodArgumentTypeMismatchException {
		
		try {
			Price price = priceService.getPriceByDate(brand_id, product_id, date);
			return convertToDto(price);
		} catch (PriceNotFound e) {
			throw(e);
		} catch (MoreThanOnePriceFound e) {
			throw(e);
		} catch (MethodArgumentTypeMismatchException e) {
			throw(e);
		}
	
	}
	
	private PriceDTO convertToDto(Price price) {
        return modelMapper.map(price, PriceDTO.class);
    }
	
}

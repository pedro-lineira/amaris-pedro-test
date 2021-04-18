package com.amarispedro.lab.price.infrastructure.controller;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.amarispedro.lab.price.application.PriceSearch;
import com.amarispedro.lab.price.domain.Price;
import com.amarispedro.lab.price.domain.exception.MoreThanOnePriceFound;
import com.amarispedro.lab.price.domain.exception.PriceNotFound;
import com.amarispedro.lab.price.infrastructure.dto.PriceDTO;

@RestController
@RequestMapping("/amarispedrotest")
public class PriceController {
	
	@Autowired
    private ModelMapper modelMapper;

	@Autowired
	private PriceSearch priceService;
	
	@GetMapping("/getPriceByDate/{brand_id}/{product_id}/{date}")
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

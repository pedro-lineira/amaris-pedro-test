package com.amarispedro.lab.pricesearch.infrastructure.persistence;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amarispedro.lab.price.domain.querymodel.Price;
import com.amarispedro.lab.price.domain.querymodel.persistence.PriceRepository;
import com.amarispedro.lab.pricesearch.infrastructure.entity.PriceJPA;

@Service
public class JPAPriceRepositoryAdapter implements PriceRepository {

	@Autowired
	private ModelMapper modelMapper;

    @Autowired
    private JPAPriceRepository priceRepository;
    
	@Override
	public Optional<List<Price>> findByDate(String brand_id, String product_id, LocalDateTime date) throws RuntimeException{
		
		Optional<List<Price>> prices = Optional.of(new ArrayList<Price>()); 
		
		Optional<List<PriceJPA>> priceJPAs = priceRepository.findByDate(brand_id, product_id, date);
		
		if(priceJPAs.isEmpty()) return prices;
		
		try {
			for(PriceJPA priceJPA: priceJPAs.get()) {
				prices.get().add(convertToPrice(priceJPA));
			}
		}catch(RuntimeException e) {
			return prices = Optional.of(new ArrayList<Price>()); //Trazar en log y generar evento de monitorización.
		}

	    return prices;
	}
	
	private Price convertToPrice(PriceJPA price) throws RuntimeException{
		Price mappedPrice;
		try {
			mappedPrice = modelMapper.map(price, Price.class);
		}
		catch(RuntimeException e) {
			throw(e);
		}
		
		return mappedPrice;
    }
}

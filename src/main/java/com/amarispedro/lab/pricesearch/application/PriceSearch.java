package com.amarispedro.lab.pricesearch.application;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.amarispedro.lab.price.domain.querymodel.Price;
import com.amarispedro.lab.price.domain.querymodel.exception.MoreThanOnePriceFound;
import com.amarispedro.lab.price.domain.querymodel.exception.PriceNotFound;
import com.amarispedro.lab.price.domain.querymodel.persistence.PriceRepository;

public class PriceSearch { 
	
	private PriceRepository priceRepository;
	
	public PriceSearch (PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
	

	public Price getPriceByDate (String brand_id, String product_id, LocalDateTime date) throws MoreThanOnePriceFound, PriceNotFound {
		
		Optional<List<Price>> prices = priceRepository.findByDate(brand_id, product_id, date);
		
		if (prices.get().size()==0) throw new PriceNotFound(); 
		
		
		Price price;
		try {
			price = findPrice(prices.get());
		} catch (MoreThanOnePriceFound e) {
			throw(e);
		}
		
		return price;
	}
	
	
	
	private Price findHighPriorityPrice(List<? extends Price> prices) {
		Comparator<Price> priority = Comparator.comparing(Price::getPriority);
		return prices.stream()    //Searching for highest priority price
				.max(priority)
				.get();
	}
	
	private long countPricesWithSamePriority(List<? extends Price> prices, int priority) {
		return prices.stream()   //Counting prices with the same high priority
				.filter(price -> price.getPriority() == priority)
				.count();
	}
	
	private Price findPrice(List<Price> prices) throws MoreThanOnePriceFound, PriceNotFound{
		
		if (prices.size() == 1) return prices.get(0); //There is one price only.
		
		Price price = findHighPriorityPrice(prices);
		long numPrices = countPricesWithSamePriority(prices, price.getPriority());
		if (numPrices > 1) throw new MoreThanOnePriceFound(); //if there are more than one price with the same high priority. Returns an exception
		
		return price;
			
	}
	
}

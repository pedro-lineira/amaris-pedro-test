package com.amarispedro.lab.pricesearch.infrastructure.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amarispedro.lab.price.domain.querymodel.persistence.PriceRepository;
import com.amarispedro.lab.pricesearch.application.PriceSearch;
import com.amarispedro.lab.pricesearch.infrastructure.persistence.JPAPriceRepositoryAdapter;

@Configuration
public class PriceSearchConfig {
	
	public static final String DATE_FORMAT="yyyy-MM-dd-HH.mm.ss";
	
	 @Bean
	 public ModelMapper modelMapper() {
		 return new ModelMapper();
	 }
	 
	 @Bean
	 public PriceRepository priceRepository(){
	     return new JPAPriceRepositoryAdapter();
	 }

	 @Bean
	 public PriceSearch getPriceService(){  //Inyectar PriceRepository en PriceSearch. 
	     return new PriceSearch(priceRepository());
	 }

}

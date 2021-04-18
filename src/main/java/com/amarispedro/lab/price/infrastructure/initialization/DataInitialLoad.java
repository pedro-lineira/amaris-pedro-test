package com.amarispedro.lab.price.infrastructure.initialization;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amarispedro.lab.price.infrastructure.entity.PriceJPA;
import com.amarispedro.lab.price.infrastructure.persistence.JPAPriceRepository;

@Configuration
public class DataInitialLoad {
	
	//Habria que cargar desde el fichero de otra forma si fueran mas datos.
	
	 @Bean
	 public CommandLineRunner demo(JPAPriceRepository repository) {
	      return (args) -> {
	    	  
	      // save 4 example prices
	      repository.save(new PriceJPA("1","35455", "1",
  					DateHelper.getLocalDate("2020-06-14-00.00.00"),
  					DateHelper.getLocalDate("2020-12-31-23.59.59"),
  					0,
  					35.5f,
  					"EUR"));
	      
	      repository.save(new PriceJPA("1","35455", "2",
					DateHelper.getLocalDate("2020-06-14-15.00.00"),
					DateHelper.getLocalDate("2020-06-14-18.30.00"),
					1,
					25.45f,
					"EUR"));
	      
	      repository.save(new PriceJPA("1","35455", "3",
					DateHelper.getLocalDate("2020-06-15-00.00.00"),
					DateHelper.getLocalDate("2020-06-15-11.00.00"),
					1,
					30.5f,
					"EUR"));
	      
	      repository.save(new PriceJPA("1","35455", "4",
					DateHelper.getLocalDate("2020-06-15-16.00.00"),
					DateHelper.getLocalDate("2020-12-31-23.59.59"),
					1,
					38.95f,
					"EUR"));
	      
	      //Datos extra en otro rango
	      
	      repository.save(new PriceJPA("1","35455", "5",
					DateHelper.getLocalDate("2010-06-15-00.00.00"),
					DateHelper.getLocalDate("2010-06-15-11.00.00"),
					1,
					500.5f,
					"EUR"));
	      
	      repository.save(new PriceJPA("1","35455", "6",
					DateHelper.getLocalDate("2010-06-15-08.00.00"),
					DateHelper.getLocalDate("2010-06-15-23.59.59"),
					1,
					3809.95f,
					"EUR"));
	      
	    };
	    
	 }


}

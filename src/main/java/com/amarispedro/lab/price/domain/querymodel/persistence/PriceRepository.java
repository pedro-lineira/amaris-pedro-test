package com.amarispedro.lab.price.domain.querymodel.persistence;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.amarispedro.lab.price.domain.querymodel.Price;

public interface PriceRepository {

	Optional<List<Price>> findByDate(String brand_id, String product_id, LocalDateTime date);
		
}


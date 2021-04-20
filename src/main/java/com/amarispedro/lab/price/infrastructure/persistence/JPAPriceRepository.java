package com.amarispedro.lab.price.infrastructure.persistence;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amarispedro.lab.price.infrastructure.entity.PriceIdJPA;
import com.amarispedro.lab.price.infrastructure.entity.PriceJPA;

@Repository
public interface JPAPriceRepository extends JpaRepository<PriceJPA, PriceIdJPA> {
	
	@Query(value = "SELECT * FROM PRICE WHERE BRAND_ID = ?1 AND PRODUCT_ID = ?2 AND STARTDATE <= ?3 AND ENDDATE >= ?3", nativeQuery = true)
	Optional<List<PriceJPA>> findByDate(String brand_id, String product_id, LocalDateTime date);
		
}

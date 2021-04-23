package com.amarispedro.lab.pricesearch.infrastructure.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHelper {
	
	private DateHelper() {}
		
	static public LocalDateTime getLocalDate(String string_date){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
		LocalDateTime date = LocalDateTime.parse(string_date, formatter);
	
		return date;
	}
	
}

package com.amarispedro.lab.price.infrastructure.initialization;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//////////// Solo se usa en la carga inicial.

public class DateHelper {	//clase de prueba eliminar --- NO UTILIZAR
		
	//static private SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
	
	/*static public Long getDateasLong(String string_date) throws ParseException{

		Date d = f.parse(string_date);
		Long milliseconds = d.getTime();
		
		return milliseconds;
	}

	static public Date getDate(String string_date) throws ParseException{

		Date d = f.parse(string_date);
			
		return d;
	}*/

	static public LocalDateTime getLocalDate(String string_date){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
		LocalDateTime date = LocalDateTime.parse(string_date, formatter);
	
		return date;
	}
	
}

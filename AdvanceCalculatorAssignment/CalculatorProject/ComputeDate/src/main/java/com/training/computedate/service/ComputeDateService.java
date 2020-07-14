package com.training.computedate.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.computedate.dto.Request;
import com.training.computedate.dto.Response;


@Service
public class ComputeDateService {

	public Response computeDate(@RequestBody Request request) throws ParseException, Exception{
	
		String service = "compute_date";
		if(!service.equals(request.getService()))
			throw new Exception("Invalid Service Name");
		
		SimpleDateFormat myFormat = new SimpleDateFormat("dd-mm-yyyy");
		String firstDate = request.getParam1();
		String secondDate = request.getParam2();

			Date date1 = myFormat.parse(firstDate);
			Date date2 = myFormat.parse(secondDate);
			long diff = date2.getTime() - date1.getTime();
			long result = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			Response resp = new Response();
			resp.setResult(result);
			return resp;
	}
	
	/*public static boolean isValidFormat(String format, String value, Locale locale) {
		
		LocalDateTime ldt = null;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy", locale);
		
		try {
			ldt = LocalDateTime.parse(value, formatter);
			String result = ldt.format(formatter);
			return result.equals(value);
		}catch(DateTimeParseException e) {
			try {
				LocalDate ld = LocalDate.parse(value, formatter);
				String result = ld.format(formatter);
				return result.equals(value);
			}catch(DateTimeParseException ex) {
				ex.printStackTrace();
			}
		}
		return false;
	}*/
}

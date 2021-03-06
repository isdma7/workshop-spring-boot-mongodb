package com.isdma.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

	//classe para descodificar o paramentro do url para podermos usa-lo aqui no java e bd
	
	//crio metodo estatico para nao ter de instanciar um novo objeto URL para usar o metodo
	//assim basta chamar a class . metodo que queremos, exemplo URL.decodeParam
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return ""; // caso de erro processo de descodificação simplesmente devolvo string vazia
		}
	}
	
	public static Date convertDate(String textDate, Date defaultDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return sdf.parse(textDate);
		} catch (ParseException e) {
			return defaultDate;
		}
	}
}

package com.prosegur.rulesEngine.services.soapService.adapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {

	private final static String ISO_DATE_FORMAT = "yyyy-MM-dd"; 
	private final static DateFormat df = new SimpleDateFormat(ISO_DATE_FORMAT);

	public Date unmarshal(String date) throws Exception {
		return (date==null||date.isEmpty())?null:(parse(date));
	}

	public String marshal(Date date) throws Exception {
		return date==null?null:(format(date));
	}
	
	public static Date parse(String date) throws RuntimeException {
		try {
			synchronized (df) {
				return df.parse(date);
			}
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static String format(Date date) throws RuntimeException {
		if (date == null) {
			return null;
		}
		synchronized (df) {
			return df.format(date);
		}
	}
}

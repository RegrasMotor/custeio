package com.prosegur.rulesEngine.services.soapService.adapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TimeAdapter extends XmlAdapter<String, Date> {

	private final static String ISO_TIME_REDUCED_FORMAT = "HH:mm"; 
	private final static DateFormat df = new SimpleDateFormat(ISO_TIME_REDUCED_FORMAT);

	public Date unmarshal(String time) throws Exception {
		return (time==null||time.isEmpty())?null:(parse(time));
	}

	public String marshal(Date time) throws Exception {
		return time==null?null:(format(time));
	}
	
	public static Date parse(String time) throws RuntimeException {
		try {
			synchronized (df) {
				return df.parse(time);
			}
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static String format(Date time) throws RuntimeException {
		if (time == null) {
			return null;
		}
		synchronized (df) {
			return df.format(time);
		}
	}
}

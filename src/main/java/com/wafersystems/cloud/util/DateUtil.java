package com.wafersystems.cloud.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Timestamp parseCaasDateTime(String time){
		SimpleDateFormat sf =new SimpleDateFormat("yyyyMMddhhmmss");
		try {
			return new Timestamp(sf.parse(time).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String formatDateTimeToDay(Date time){
		SimpleDateFormat sf =new SimpleDateFormat("yyyyMMdd");
		try {
			return sf.format(time);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

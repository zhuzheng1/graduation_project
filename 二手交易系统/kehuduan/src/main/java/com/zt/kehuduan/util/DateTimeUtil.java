package com.zt.kehuduan.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

	public static String getSysTime() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date = new Date();
		
		String time = sdf.format(date);
		
		return time;
	}
}

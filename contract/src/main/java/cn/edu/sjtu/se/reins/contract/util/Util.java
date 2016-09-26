package cn.edu.sjtu.se.reins.contract.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Util {
	private Util() {
	}

	public static Map<String, Object> createMap(Object value) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", true);
		map.put("value", value);
		return map;
	}

	public static Map<String, Object> createErrorMap(String errorMessage) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", false);
		map.put("message", errorMessage);
		return map;
	}

	public static Date string2date(String s) throws ParseException {
		return DateFormat.getDateInstance().parse(s);
	}

	@SuppressWarnings("deprecation")
	public static String date2string(Date date) {
		int year = date.getYear() + 1900;
		int month = date.getMonth() + 1;
		int day = date.getDate();
		return year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day);
	}
}

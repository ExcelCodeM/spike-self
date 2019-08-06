package com.spike.util;

import java.util.UUID;

public class StringUtils {
	
	public static String createUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}

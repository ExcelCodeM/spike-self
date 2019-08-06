package com.spike.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 两次加盐加密处理
 * @author 1
 *
 */
public class MD5Util {
	
	private static final String SALT = "springBoot";
	
	public static String md5(String str) {
		return DigestUtils.md5Hex(str);
	}
	
	//第一次进行加密
	public static String inputToBack(String str) {
		return md5(str + SALT);
	}
	
	//第二次进行加密
	public static String backToDB(String str) {
		return md5(str + SALT);
	}
	
	public static String inputToDB(String str) {
		return backToDB(inputToBack(str + SALT) + SALT);
	}

}

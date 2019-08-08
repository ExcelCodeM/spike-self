package com.spike.util;

import java.util.HashMap;
import java.util.Map;

public class ResultResponse {
	
    private static Map<String, Object> map = new HashMap<String, Object>();
	
	public static Map<String, Object> getResultResponse(String code, String message, Object data){
		map.put("code", code);
		map.put("message", message);
		map.put("data", data);

		return map;
	}
	
	public static void put(String k, Object v) {
		map.put(k, v);
	}
}

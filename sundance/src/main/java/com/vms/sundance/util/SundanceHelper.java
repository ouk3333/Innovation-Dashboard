package com.vms.sundance.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vms.sundance.enums.IMSPErrorCode;

public class SundanceHelper {

	/***
	 * request 객체를 넣어주면 HashMap Key, Value 로 반환
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static HashMap<String, Object> getRequestValues(HttpServletRequest request) throws UnsupportedEncodingException {
		
		HashMap<String, Object> parameter = new HashMap<String, Object>();
		
		Enumeration names = request.getParameterNames();
		
		while(names.hasMoreElements()) {
			String key = names.nextElement().toString();
			String value = URLDecoder.decode(request.getParameter(key), "UTF-8");
			
			parameter.put(key, value);
		}
		
		return parameter;
	}
	
	/***
	 * Json String을 넣어주면 HashMap Key, Value 형태로 반환
	 * @param JsonString
	 * @return
	 */
	public static HashMap<String, Object> getJsonToHashMap( String JsonString ) {
		HashMap<String, Object> parameter = new HashMap<String, Object>();
		
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse( JsonString );
		Gson gson = new Gson();
		
		parameter.putAll( gson.fromJson(element, HashMap.class) );
		
		return parameter;
	}
	
	/***
	 * Json String 배열을 넣어주면 ArrayList HashMap Key, Value 형태로 반환
	 * @param jsonString
	 * @return
	 */
	public static ArrayList<HashMap<String, Object>> getJsonToHashMapList( String jsonString ) {
		ArrayList<HashMap<String, Object>> parameters = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> parameter = new HashMap<String, Object>();
		
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse( jsonString );
		JsonArray array = element.getAsJsonArray(); 
		Gson gson = new Gson();
		
		for(int i = 0; i < array.size(); i++) {
			
			parameter.putAll( gson.fromJson(array.get(i), HashMap.class) );
			
			parameters.add(parameter);
		}
		
		return parameters;
	}
	
	/***
	 * 서버의 현재 시각을 반환
	 * @return
	 */
	public static String getCurrentTime() {
		
		String time = "";
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		time = sdf.format(date);
		
		return time;
	}
	
	/***
	 * 새로운 UUID 를 생성
	 * @return
	 */
	public static String CreateUUID() {
		
		String uuid = "";
		
		uuid = UUID.randomUUID().toString();
		
		return uuid;
	}
	
	/***
	 * Reseponse Result Code Converter (use compare to IMSPErrorCode)
	 * @param jsonValue
	 * @return
	 */
	public static int ResponseStatus(String jsonValue) {
		
		HashMap<String, Object> parameter = SundanceHelper.getJsonToHashMap(jsonValue);
		
		try {
			return Integer.parseInt(parameter.get("retCode").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static JsonObject ResponseConverter(String jsonValue) {
		
		try {
			JsonParser parser = new JsonParser();
			
			return (JsonObject) parser.parse(jsonValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

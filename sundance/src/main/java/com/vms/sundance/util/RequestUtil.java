package com.vms.sundance.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

public class RequestUtil {

	private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);
	
	private static final String Content_Type_XML = "application/xml";
	private static final String Content_Type_JSON = "application/json";
	
	public static HttpURLConnection _conn = null;
	public static String interopServerIP;
	public static String interopServerPort;
	public static String _sendURL;
	
	
	/**
	 * Constructor
	 */
	public RequestUtil() {
		logger.debug(String.format("[Request Util Initialize Complete]"));
	}
	
	public static boolean CreateConnection() throws MalformedURLException {
		
		try {
			
			URL url = new URL(_sendURL);
			
			_conn = (HttpURLConnection) url.openConnection();
			
			_conn.setDoOutput(true);
			_conn.setConnectTimeout(10000);
			_conn.setReadTimeout(10000);
			
			_conn.setRequestProperty("Content-Type", Content_Type_JSON);
			_conn.setRequestProperty("Accept-Charset", "UTF-8");
			_conn.setRequestProperty("ContentEncoding", "UTF-8");
			_conn.setRequestProperty("FieldType", "2");
			
			return true;
		} catch (Exception e) {
			
			System.out.println( e.getMessage() );
			return false;
		}
		
		
	}
	
	public static String SendRequest( String command, String content ) throws IOException {
		
		String inputLine = "";
		StringBuffer outResult = new StringBuffer();
		OutputStream os = null;
		
		try {
			
			if( _conn == null ) {
				CreateConnection();
			}
			
			System.out.println(String.format(" ** [SendRequest() Start] ** "));
			
//			_conn.setRequestProperty("Command", command);
			_conn.addRequestProperty("Command", command);
			
			os = _conn.getOutputStream();
			
			os.write(content.getBytes("UTF-8"));
			os.flush();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(_conn.getInputStream(), "UTF-8"));
			
			while((inputLine = in.readLine()) != null) {
				outResult.append(inputLine);
			}
			
			return outResult.toString();
			
		} catch (Exception e) {
			
			System.out.println(String.format(" ** [SendRequest() Error] ** "));
			System.out.println( String.format("%s", e.getMessage()) );
			return null;
			
		} finally {
			
			if( _conn != null ) {
				_conn.disconnect();
			}
			
			if( os != null ) {
				os.close();
			}
			
			System.out.println(String.format(" ** [SendRequest() End] ** "));
		}
	}
}

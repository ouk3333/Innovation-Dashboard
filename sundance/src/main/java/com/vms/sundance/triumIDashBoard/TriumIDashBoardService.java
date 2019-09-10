package com.vms.sundance.triumIDashBoard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("TriumIDashBoardService")
public class TriumIDashBoardService {

	private static final Logger logger = LoggerFactory.getLogger(TriumIDashBoardService.class);
	
	public 	String sendREST(String sendURL, String jsonValue) throws IOException {
		
		String inputLine = null;
		StringBuffer outResult = new StringBuffer();
		
		URL url = new URL(sendURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		try {
			
			logger.debug("REST API Start");
			
			conn.setDoOutput(true); 
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Command", "Login");
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			
			OutputStream os = conn.getOutputStream();
			os.write(jsonValue.getBytes("UTF-8"));
			os.flush();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			
			while ((inputLine = in.readLine()) != null) {
					
				outResult.append(inputLine);
			}
			
		} catch (Exception e) {
			
			logger.error("Login Fail");
			e.printStackTrace();
			
		} finally {
			
			conn.disconnect();
		}
		
		return outResult.toString();
	}
}

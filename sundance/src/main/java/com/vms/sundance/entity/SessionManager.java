package com.vms.sundance.entity;

import java.util.HashMap;

public class SessionManager {

	/**
	 * Key : LoginID
	 * Value : SessionID
	 */
	private static HashMap<String, String> sessions = new HashMap<String, String>();
	
	public static void sessionAdd(String loginID, String sessionID) {
		
		if( sessions.containsKey(loginID) ) {
			sessionRemove(loginID);
		}
		
		sessions.put(loginID, sessionID);
	}
	
	public static void sessionRemove(String loginID) {
		sessions.remove(loginID);
	}
	
	public static void DestroyManager() {
		
	}
	
}
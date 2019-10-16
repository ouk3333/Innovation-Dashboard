package com.vms.sundance.entity;

public class SessionInfo {
	private String loginID;
	private String sessionID;
	
	
	public SessionInfo(String _loginID, String _sessionID) {
		this.loginID = _loginID;
		this.sessionID = _sessionID;
	}
	
	public String getLoginID() {
		return loginID;
	}
	public String getSessionID() {
		return sessionID;
	}
}

package com.vms.sundance;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonObject;
import com.vms.sundance.entity.SessionManager;
import com.vms.sundance.enums.IMSPErrorCode;
import com.vms.sundance.util.RequestUtil;
import com.vms.sundance.util.SundanceHelper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static SessionManager sessions;
	
	@Value("#{interopServerSetting['interopServer.ip']}")
	private String _interopServerIP;
	
	@Value("#{interopServerSetting['interopServer.port']}")
	private String _interopServerPort;
	
	@PostConstruct
	public void postConstructor() {
		sessions = new SessionManager();
		
		RequestUtil.interopServerIP = _interopServerIP;
		RequestUtil.interopServerPort = _interopServerPort;
		RequestUtil._sendURL = String.format("http://%s:%s", _interopServerIP, _interopServerPort);
	}
	
	@PreDestroy
	public void preDestroy() {
		
		SessionManager.DestroyManager();
		sessions = null;
	}
	
	
	
	
	
	@RequestMapping(value = "/")
	public void home(HttpServletResponse response) throws IOException {
		logger.info("Sundance Page Init()");
		
		response.sendRedirect("/sundance/triumIDashBoard");
	}
	
	@RequestMapping(value="/sundance")
	public void goMain(HttpServletResponse response) throws IOException {
		logger.info("Sundance Page Init()");
		
		response.sendRedirect("/sundance/triumIDashBoard");
	}
	
	@RequestMapping("/login")
	public void procInteropServerLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		
		PrintWriter out = response.getWriter();
		JsonObject json = new JsonObject();
		
		String content = request.getParameter("content");
		
		if( content == null ) {
			json.addProperty("status", IMSPErrorCode.InvalidContent);
			out.print(json);
		}
		
		String responseData = RequestUtil.SendRequest("Login", content);
		
		if( SundanceHelper.ResponseStatus(responseData) != IMSPErrorCode.OK ) {
			json.addProperty("status", IMSPErrorCode.AuthorizeFail);
			out.print(json);
		}

		json.addProperty("status", IMSPErrorCode.OK);
		json.add("result", SundanceHelper.ResponseConverter(responseData));
		out.print(json);
	}
}
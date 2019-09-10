package com.vms.sundance.triumIDashBoard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonObject;

@Controller
@RequestMapping(value="/sundance/")
public class TriumIDashBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(TriumIDashBoardController.class);
	
	@Resource(name="TriumIDashBoardService")
	private TriumIDashBoardService triumIDashBoardService;

	@RequestMapping("/triumIDashBoard")
	public String goMainPage(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("goMainPage() Init");
		
		return "triumIDashBoard/triumIDashBoard";
	}
	
	@RequestMapping("/login")
	public void procInteropServerLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		JsonObject json = new JsonObject();
		
		String content = request.getParameter("content");
		
		if( content == null ) {
			json.addProperty("status", 500);
			out.print(json);
		}
		
		triumIDashBoardService.sendREST("http://192.168.104.215:8080", content);
		
		json.addProperty("status", 200);
		out.print(json);
	}
}
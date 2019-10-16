package com.vms.sundance.triumIDashBoard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonObject;
import com.vms.sundance.enums.IMSPErrorCode;
import com.vms.sundance.util.RequestUtil;
import com.vms.sundance.util.SundanceHelper;

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
	
	@RequestMapping("/GetIPDevices")
	public void GetIPDevices(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		JsonObject json = new JsonObject();
		
		String content = request.getParameter("content");
		
		if( content == null ) {
			json.addProperty("status", IMSPErrorCode.InvalidContent);
			out.print(json);
		}
		
		String responseData = RequestUtil.SendRequest("GetIPDevices", content);
		
		if( SundanceHelper.ResponseStatus(responseData) != IMSPErrorCode.OK ) {
			json.addProperty("status", IMSPErrorCode.InternalServerError);
			out.print(json);
		}

		json.addProperty("status", IMSPErrorCode.OK);
		json.add("result", SundanceHelper.ResponseConverter(responseData));
		out.print(json);
	}
	
	@RequestMapping("/GetIPDevice")
	public void GetIPDevice(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		JsonObject json = new JsonObject();
		
		String content = request.getParameter("content");
		
		if( content == null ) {
			json.addProperty("status", IMSPErrorCode.InvalidContent);
			out.print(json);
		}
		
		String responseData = RequestUtil.SendRequest("GetIPDevice", content);
		
		if( SundanceHelper.ResponseStatus(responseData) != IMSPErrorCode.OK ) {
			json.addProperty("status", IMSPErrorCode.InternalServerError);
			out.print(json);
		}

		json.addProperty("status", IMSPErrorCode.OK);
		json.add("result", SundanceHelper.ResponseConverter(responseData));
		out.print(json);
	}
}
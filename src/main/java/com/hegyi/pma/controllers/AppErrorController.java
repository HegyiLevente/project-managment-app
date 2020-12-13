package com.hegyi.pma.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppErrorController implements ErrorController{

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if(status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			
			if(statusCode == HttpStatus.FORBIDDEN.value()) {
				return "errorpages/error-403";
			}
		}
		
		return "errorpages/error-404";
	}

}

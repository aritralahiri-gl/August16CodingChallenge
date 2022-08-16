package com.java;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HelloController {
	
	@RequestMapping(value = "/")
	public String showHomePage() {
		return "index";
	}

	@RequestMapping(value = "/show")
	public String showDashboardPage(HttpServletRequest request, Model theModel) {
		String name = request.getParameter("name");
		theModel.addAttribute("empName", name);
		int number =  Integer.parseInt (request.getParameter("number"));
		theModel.addAttribute("empNo", number);
		String designation = request.getParameter("designation");
		theModel.addAttribute("empDesg", designation);
		int salary = Integer.parseInt(request.getParameter("salary"));
		theModel.addAttribute("empSalary", salary);
		return "show";
	}

}

package com.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Employee;
import com.service.EmpService;

@Controller
//@RestController
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping(value={"/","/home"},method=RequestMethod.GET)
    public String home(HttpSession session) {
		List<Employee> emp=empService.listEmp();
		emp.stream().forEach(System.out::println);
		session.setAttribute("emp",emp);
    	return "index";
    }
	
	@RequestMapping(value="/addemp",method=RequestMethod.GET)
    public String addEmployee() {
    	return "addEmp";
    }
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@ModelAttribute Employee e,HttpSession session) {
		System.out.println(e);
		session.setAttribute("msg","Employee Added successfully");
		empService.addEmp(e);
		return "redirect:/";
	}
}

package com.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String home(Model m) {
		List<Employee> emp=empService.listEmp();
		emp.stream().forEach(System.out::println);
		m.addAttribute("emp",emp);
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
	
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute Employee e,HttpSession session) {
		System.out.println(e);
		session.setAttribute("msg","Employee updated successfully");
		empService.addEmp(e);
		return "redirect:/";
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String editEmployee(@PathVariable Integer id,Model m) {
		System.out.print(id);
		Employee emp=empService.getEmpById(id);
		System.out.println(emp);
		m.addAttribute("emp",emp);
		return "editEmp";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteEmployee(@PathVariable Integer id, HttpSession session) {
		System.out.print(id);
		empService.deleteEmp(id);
		session.setAttribute("msg","Employee deleted successfully");
		return "redirect:/";
	}
}

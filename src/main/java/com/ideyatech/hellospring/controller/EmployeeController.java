package com.ideyatech.hellospring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ideyatech.hellospring.entity.Employee;
import com.ideyatech.hellospring.repository.EmployeeRepository;
import com.ideyatech.hellospring.validator.EmployeeValidator;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeValidator employeeValidator;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@ModelAttribute(name = "employee")
	public Employee initialEmployee() {
		return new Employee();
	}
	
	@RequestMapping(value ="/")
	public String employeeForm() {
		return "employee-form";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		binder.addValidators(employeeValidator);
	}
	
	@RequestMapping(value="/{id}")
	public @ResponseBody String getEmployee(@PathVariable("id") Long id) {
		return employeeRepository.findOne(id).toString();
	}
	
	@RequestMapping(value="/list")
	public String getEmployeeList(ModelMap model) {
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
		return "employee-list";
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute Employee employee, 
			BindingResult bindingResult, ModelMap map,
			HttpServletRequest request, HttpServletResponse response) {
		if(bindingResult.hasErrors()) {
			System.out.println("MAY ERROR!");
			return "employee-form";
		}
		employeeRepository.save(employee);
		map.addAttribute("message", "Saving Success");
	
		return "employee-success";
	}

}

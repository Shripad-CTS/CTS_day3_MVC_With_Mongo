package com.cts.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.exception.EmployeeNotFoundException;
import com.cts.model.Employee;
import com.cts.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	Logger log = LoggerFactory.getLogger(EmployeeController.class); 
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	@GetMapping("/dashboard")
	public String getAllEmployee(Model model) {
		log.info("in the dashboard");
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "allEmployee";
	}
	@GetMapping("/getEmployee/{id}")
	public String getEmployee(@PathVariable String id,Model model) {
		
		Employee emp= employeeService.getEmployee(id);
		model.addAttribute("employee", emp);
		return "viewEmployee";
	}
	
	
	@GetMapping("/addEmployee")
	public String addForm(Model model) {
		model.addAttribute("employee",new Employee());
		return "addForm";
	}
	@PostMapping("/saveEmployee")
	public String addEmployee(@Valid @ModelAttribute Employee employee, BindingResult result) {
		if(result.hasErrors()) {
			return "addForm";
		}
		employeeService.saveEmployee(employee);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/editEmployee/{id}")
	public String editForm(@PathVariable String id,Model model){
		model.addAttribute("employee", employeeService.getEmployee(id));
		return "addForm";
		
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable String id) {
		employeeService.deleteEmployee(id);
		return "redirect:/dashboard";
	}
	@GetMapping("/forceError")
	public String forceError() {
	    throw new EmployeeNotFoundException("FORCED EXCEPTION TEST");
	}

	
}

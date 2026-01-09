package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.model.Employee;
import com.cts.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	@GetMapping("/dashboard")
	public String getAllEmployee(Model model) {
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
	public String addEmployee(@ModelAttribute Employee employee) {
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
	
}

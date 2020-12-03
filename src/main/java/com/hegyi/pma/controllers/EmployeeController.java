package com.hegyi.pma.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hegyi.pma.entities.Employee;
import com.hegyi.pma.entities.Project;
import com.hegyi.pma.services.EmployeeService;
import com.hegyi.pma.services.ProjectService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	private ProjectService projectService;

	public EmployeeController(EmployeeService employeeService, ProjectService projectService) {
		this.employeeService = employeeService;
		this.projectService = projectService;
	}

	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employeeList = employeeService.findAll();
		model.addAttribute("employeesList", employeeList);
		
		return "/employees/employees-list";
	}

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		List<Project> projects = projectService.findAll();
		model.addAttribute("projects", projects);
		
		model.addAttribute("employee", new Employee());
		
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee) {
		employeeService.save(employee);
		
		return "redirect:/employees";
	}
	
	
	
}










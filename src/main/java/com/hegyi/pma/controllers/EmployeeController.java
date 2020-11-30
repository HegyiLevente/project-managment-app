package com.hegyi.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hegyi.pma.dao.EmployeeRepository;
import com.hegyi.pma.dao.ProjectRepository;
import com.hegyi.pma.entities.Employee;
import com.hegyi.pma.entities.Project;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeRepository employeeRepository;
	private ProjectRepository projectRepository;
	
	public EmployeeController(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
		this.employeeRepository = employeeRepository;
		this.projectRepository = projectRepository;
	}

	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employeeList = employeeRepository.findAll();
		model.addAttribute("employeesList", employeeList);
		
		return "/employees/employees-list";
	}

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		List<Project> projects = projectRepository.findAll();
		model.addAttribute("projects", projects);
		
		model.addAttribute("employee", new Employee());
		
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee) {
		employeeRepository.save(employee);
		
		return "redirect:/employees";
	}
	
	
	
}










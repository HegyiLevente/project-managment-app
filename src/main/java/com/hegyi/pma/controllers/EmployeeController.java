package com.hegyi.pma.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hegyi.pma.entities.Employee;
import com.hegyi.pma.entities.Project;
import com.hegyi.pma.services.EmployeeService;
import com.hegyi.pma.services.ProjectService;
import com.hegyi.pma.validation.NewEmployeeValidator;
import com.hegyi.pma.validation.UpdatedEmployeeValidator;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	private ProjectService projectService;
	private NewEmployeeValidator newEmployeeValidator;
	private UpdatedEmployeeValidator updatedEmployeeValidator;

	public EmployeeController(EmployeeService employeeService, ProjectService projectService, NewEmployeeValidator employeeValidator, UpdatedEmployeeValidator updatedEmployeeValidator) {
		this.employeeService = employeeService;
		this.projectService = projectService;
		this.newEmployeeValidator = employeeValidator;
		this.updatedEmployeeValidator = updatedEmployeeValidator;
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
	public String createEmployee(@ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model) {
		this.newEmployeeValidator.validate(employee, bindingResult);
		
		if(bindingResult.hasErrors()) {
			List<Project> projects = projectService.findAll();
			model.addAttribute("projects", projects);
			
			return "employees/new-employee";
		}
		
		employeeService.save(employee);
		
		return "redirect:/employees";
	}
	
	@PostMapping("/saveUpdatedEmployee")
	public String saveUpdatedEmployee(Employee employee, BindingResult bindingResult, Model model) {
		this.updatedEmployeeValidator.validate(employee, bindingResult);
		
		if(bindingResult.hasErrors()) {
			List<Project> allProjects = projectService.findAll();
			model.addAttribute("allProjects", allProjects);
			
			List<Project> assignedProjects = employee.getProjectList();
			model.addAttribute("assignedProjects", assignedProjects);
			
			return "employees/update-employee";
		}
		
		employeeService.save(employee);
		
		return "redirect:/employees";
	}
	
	@GetMapping("/update")
	public String updateEmployee(@RequestParam("id") Long id, Model model) {
		Employee employee = employeeService.findEmployeeById(id);
		model.addAttribute("employee", employee);
		
		List<Project> assignedProjects = employee.getProjectList();
		model.addAttribute("assignedProjects", assignedProjects);
		
		List<Project> allProjects = projectService.findAll();
		model.addAttribute("allProjects", allProjects);
		
		return "employees/update-employee";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") Long id) {
		this.employeeService.deleteEmployeeById(id);
		
		return "redirect:/employees";
	}
	
	
}




















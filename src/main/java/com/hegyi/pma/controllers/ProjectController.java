package com.hegyi.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hegyi.pma.dao.EmployeeRepository;
import com.hegyi.pma.dao.ProjectRepository;
import com.hegyi.pma.entities.Employee;
import com.hegyi.pma.entities.Project;
import com.hegyi.pma.services.EmployeeService;
import com.hegyi.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	private ProjectService projectService;
	private EmployeeService employeeService;

	public ProjectController(ProjectService projectService, EmployeeService employeeService) {
		this.projectService = projectService;
		this.employeeService = employeeService;
	}

	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projectList = projectService.findAll();
		model.addAttribute("projectList", projectList);
		
		return "projects/projects-list";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project project = new Project();
		model.addAttribute("project", project);
		
		List<Employee> allEmployees = employeeService.findAll();
		model.addAttribute("allEmployees", allEmployees);

		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project) {
		projectService.save(project);

		return "redirect:/projects";
	}
	
}









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

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	private ProjectRepository projectRepository;
	private EmployeeRepository employeeRepository;
	
	public ProjectController(ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
		this.projectRepository = projectRepository;
		this.employeeRepository = employeeRepository;
	}

	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projectList = projectRepository.findAll();
		model.addAttribute("projectList", projectList);
		
		return "projects/projects-list";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project project = new Project();
		model.addAttribute("project", project);
		
		List<Employee> allEmployees = employeeRepository.findAll();
		model.addAttribute("allEmployees", allEmployees);

		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project) {
		projectRepository.save(project);

		return "redirect:/projects";
	}
	
}









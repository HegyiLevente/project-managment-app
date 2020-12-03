package com.hegyi.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hegyi.pma.dao.EmployeeRepository;
import com.hegyi.pma.dao.ProjectRepository;
import com.hegyi.pma.dto.ChartData;
import com.hegyi.pma.dto.EmployeeProject;
import com.hegyi.pma.entities.Project;
import com.hegyi.pma.services.EmployeeService;
import com.hegyi.pma.services.ProjectService;

@Controller
public class HomeController {

	private EmployeeService employeeService;
	private ProjectService projectService;

	public HomeController(EmployeeService employeeService, ProjectService projectService) {
		this.employeeService = employeeService;
		this.projectService = projectService;
	}

	@GetMapping("/")
	public String displayHomePage(Model model) {
		List<Project> projectsList = projectService.findAll();
		model.addAttribute("projectsList", projectsList);
		
		List<EmployeeProject> employeesProjectsCount = employeeService.getEmployeeProjects();
		model.addAttribute("employeesProjectsCount", employeesProjectsCount);
		
		return "main/home";
	}
	
}








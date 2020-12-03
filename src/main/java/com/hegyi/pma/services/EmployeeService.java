package com.hegyi.pma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hegyi.pma.dao.EmployeeRepository;
import com.hegyi.pma.dto.EmployeeProject;
import com.hegyi.pma.entities.Employee;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}
	
	public void save(Employee employee) {
		this.employeeRepository.save(employee);
	}
	
	public List<EmployeeProject> getEmployeeProjects() {
		return this.employeeRepository.getEmployeeProjects();
	}
	
	
}

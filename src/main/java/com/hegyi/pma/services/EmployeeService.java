package com.hegyi.pma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hegyi.pma.dao.EmployeeRepository;
import com.hegyi.pma.dto.EmployeeProjectCount;
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
	
	public List<EmployeeProjectCount> getEmployeeProjectsCount() {
		return this.employeeRepository.getEmployeeProjectsCount();
	}
	
	public Employee findEmployeeById(Long id) {
		return this.employeeRepository.findByEmployeeId(id);
	}
	
	public void deleteEmployeeById(Long id) {
		this.employeeRepository.deleteById(id);
	}
	
	public Employee findByEmailAddress(String email) {
		return this.employeeRepository.findByEmailAddress(email);
	}
	
	public Employee findByEmailAddressAndEmployeeIdNot(String emailAddress, Long employeeId) {
		return this.employeeRepository.findByEmailAddressAndEmployeeIdNot(emailAddress, employeeId);
	}
	
}

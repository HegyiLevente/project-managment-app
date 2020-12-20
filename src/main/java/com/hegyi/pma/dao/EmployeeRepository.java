package com.hegyi.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hegyi.pma.dto.EmployeeProjectCount;
import com.hegyi.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	public Employee findByEmployeeId(Long id);
	
	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery = true, value = "SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.project_id) as projectCount "
			+ "FROM employee e LEFT JOIN project_employee pe ON e.employee_id = pe.employee_id "
			+ "GROUP BY firstName, lastName")
	public List<EmployeeProjectCount> getEmployeeProjectsCount();
	
	public Employee findByEmailAddress(String email);
	
	public Employee findByEmailAddressAndEmployeeIdNot(String emailAddress, Long employeeId);
	
	
}







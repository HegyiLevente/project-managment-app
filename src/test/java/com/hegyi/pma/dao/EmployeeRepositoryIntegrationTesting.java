package com.hegyi.pma.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.hegyi.pma.entities.Employee;

@SpringBootTest
@RunWith(SpringRunner.class)
@SqlGroup(@Sql(executionPhase=ExecutionPhase.BEFORE_TEST_METHOD, scripts= {"classpath:schema.sql", "classpath:data.sql"}))
public class EmployeeRepositoryIntegrationTesting {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void ifEmployeeSaved_thenSucces() {
		Employee john = new Employee("John", "Doe", "john@gmail.com");
		employeeRepository.save(john);
		
		assertEquals(10, employeeRepository.findAll().size());
	}
	
}













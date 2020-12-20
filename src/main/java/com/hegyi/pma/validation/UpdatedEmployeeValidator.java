package com.hegyi.pma.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hegyi.pma.entities.Employee;
import com.hegyi.pma.services.EmployeeService;

@Component
public class UpdatedEmployeeValidator implements Validator{

	private EmployeeService employeeService;	
	
	public UpdatedEmployeeValidator(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee employee = (Employee) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
		if(employee.getFirstName().length() < 3 || employee.getFirstName().length() > 50) {
			errors.rejectValue("firstName", "Size.employeeForm.firstName");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
		if(employee.getLastName().length() < 2 || employee.getLastName().length() > 50) {
			errors.rejectValue("lastName", "Size.employeeForm.lastName");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "NotEmpty");
		if(this.employeeService.findByEmailAddressAndEmployeeIdNot(employee.getEmailAddress(), employee.getEmployeeId()) != null) {
			errors.rejectValue("emailAddress", "AlreadyExisting.employeeForm.emailAddress");
		}
		
	}
	
	

}
















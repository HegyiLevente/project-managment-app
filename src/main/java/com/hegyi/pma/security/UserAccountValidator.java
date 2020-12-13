package com.hegyi.pma.security;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hegyi.pma.entities.UserAccount;
import com.hegyi.pma.services.UserAccountService;

@Component
public class UserAccountValidator implements Validator{
	
	private UserAccountService userAccountService;

	public UserAccountValidator(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return UserAccount.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserAccount user = (UserAccount) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if(user.getUsername().length() < 6 || user.getUsername().length() > 20) { 
			errors.rejectValue("username", "Size.userForm.username"); 
		}
		if(this.userAccountService.findByUsername(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if(user.getPassword().length() < 8 || user.getPassword().length() > 25) {
			errors.rejectValue("password", "Size.userForm.password");
		}
		if(!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Difference.userForm.passwordConfirm");
		}
		
	}

}






















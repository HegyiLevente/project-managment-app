package com.hegyi.pma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hegyi.pma.entities.UserAccount;
import com.hegyi.pma.security.UserAccountValidator;
import com.hegyi.pma.services.SecurityService;
import com.hegyi.pma.services.UserAccountService;

@Controller
public class UserAccountController {

	private UserAccountService userAccountService;
	private SecurityService securityService;
	private UserAccountValidator userAccountValidator;
	
	public UserAccountController(UserAccountService userAccountService, SecurityService securityService, UserAccountValidator userAccountValidator) {
		this.userAccountService = userAccountService;
		this.securityService = securityService;
		this.userAccountValidator = userAccountValidator;
	}
	
	@GetMapping("/registration")
	public String registration(Model model) {
		if(this.securityService.isAuthenticated()) {
			return "redirect:/";
		}
		
		model.addAttribute("userAccount", new UserAccount());
		
		return "security/registration";
	}
	
	@PostMapping("/registration/save")
	public String registrationSave(@ModelAttribute("userAccount") UserAccount userAccount, BindingResult bindingResult) {
		this.userAccountValidator.validate(userAccount, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "security/registration";
		}
		
		this.userAccountService.save(userAccount);
		
		this.securityService.autoLogin(userAccount.getUsername(), userAccount.getPasswordConfirm());
		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if(this.securityService.isAuthenticated()) {
			return "redirect:/";
		}
		
		if(error != null) {
			model.addAttribute("error", "Your username and password is invalid.");
		}
		
		if(logout != null) {
			model.addAttribute("message", "Logged out successfully.");
		}
		
		return "security/login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "security/logout";
	}
	
}




















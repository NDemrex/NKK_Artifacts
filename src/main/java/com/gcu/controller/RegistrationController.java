package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.RegistrationModel;
	
@Controller
@RequestMapping("/Registration")
public class RegistrationController {
/*Now we will do the registration */
	
	@GetMapping ("/")
	public String displayReg(Model model) {
		//model.addAttribute("title", "Registration Form");
		model.addAttribute("registrationModel", new RegistrationModel());
		
		return "Registration";		
	}
	
	//this is going to route my app. 
	@PostMapping("/doRegistration")
	public String doRegistration(@Valid RegistrationModel registrationModel,  BindingResult bindingResult, Model model) {
		//run the binding of the page, run the model and run the info through
		
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Registration Form");
			//if we have errors we need to stay on this page and fix them
			return "Registration";
		}
		//else we want to return the main page, or a success page
		model.addAttribute("RegistrationModel", registrationModel);
		return "RegistrationSuccess"; 
		//return "Artifacts";
	}
	 
}
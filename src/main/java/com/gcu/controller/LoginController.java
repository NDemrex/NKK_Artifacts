package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/Login")
public class LoginController {

	/* This is going to track people logging in*/
	@GetMapping ("/")
	public String display(Model model) {
		
		model.addAttribute("title", "Login Form");
		
		model.addAttribute("LoginModel", new LoginModel());
		
		return "Login";		
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel,  BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "Login";
		}
		
		//if we are the user we will go to the artifacts shopping page
		model.addAttribute("loginModel", loginModel);
		return "Artifacts";
	}
	
}
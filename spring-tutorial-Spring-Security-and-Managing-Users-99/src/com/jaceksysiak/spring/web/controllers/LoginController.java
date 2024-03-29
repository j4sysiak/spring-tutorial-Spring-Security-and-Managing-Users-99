package com.jaceksysiak.spring.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jaceksysiak.spring.web.dao.Offer;
import com.jaceksysiak.spring.web.dao.User;
import com.jaceksysiak.spring.web.service.UsersService;

@Controller
public class LoginController {
	
	private UsersService usersService;
	
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}

	@RequestMapping("/newaccount")
	public String showNewAccount(Model model){
		
		model.addAttribute("user", new User());
		return "newaccount";
	}
	
   
	
	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result){
		
		//System.out.println(user);
		
		if(result.hasErrors()){
		
			return "createaccount";
		}
		
		user.setAuthority("user");
		user.setEnabled(true);
		
		usersService.create(user);
		
		return "accountcreated";
	}
}





































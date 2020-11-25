package com.springmvc.contAppSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.contAppSpring.models.User;
import com.springmvc.contAppSpring.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService usersService;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String showHomePage(Model model) {
		model.addAttribute("users", usersService.getAllUsers());
		return "index";
	}

	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST}, value = "/")
	public String addUser(@ModelAttribute("newUser") User user, Model model) {
		if(user != null)
		usersService.saveUser(user);
		model.addAttribute("users", usersService.getAllUsers());
		return "index";
	}
	
	@RequestMapping(method = {RequestMethod.DELETE, RequestMethod.POST}, value = "/deleteUser")
	public String deleteUser(@RequestParam("delete") int id, Model model) {
		usersService.deleteUserById(id);
		model.addAttribute("users", usersService.getAllUsers());
		return "index";
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST}, value = "/updateUser")
	public String updateUser(@RequestParam("update") int id, Model model) {
		User user = usersService.getUserById(id);
		model.addAttribute("user", user);
		return "updateUser";
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/saveUser")
	public String saveUserUpdate(@ModelAttribute("updatedUser") User user) {
		if (user != null)
			usersService.updateUser(user);
		return "redirect:./";
	}
}



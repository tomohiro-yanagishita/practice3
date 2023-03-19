package com.example.demo.practice2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.practice2.dto.UserSearchRequest;
import com.example.demo.practice2.entity.User;
import com.example.demo.practice2.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/user/search")
	public String diaplySearch(Model model) {
		model.addAttribute("userSearchRequest", new UserSearchRequest()); 
		return "practice2/user/search";
	}
	
	@PostMapping(value = "/user/id_search")
	public String search(@ModelAttribute UserSearchRequest userSearchRequest, Model model) {
		User user = userService.search(userSearchRequest);
		model.addAttribute("userinfo", user);
		return "practice2/user/search";
	}
	
	

}



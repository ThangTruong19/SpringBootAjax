package com.thangtruong19.SpringBootSessionExample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thangtruong19.SpringBootSessionExample.entity.User;

@Controller
public class MainController {
	
	private List<User> users = new ArrayList<User>();
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/addNew")
	@ResponseBody
	public String addNew(@RequestParam("name")String name,@RequestParam("age")String age) {
		User user = new  User();
		user.setName(name);
		user.setAge(Integer.parseInt(age));
		user.setRole("Nomal");
		users.add(user);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonResponse = "";
		try {
			jsonResponse = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResponse;
	}
	
	@GetMapping("search")
	@ResponseBody
	public String search(@RequestParam("name")String name) {
		String jsonResponse = "";
		ObjectMapper mapper = new ObjectMapper();

		for(User user:users) {
			if(user.getName().equals(name)) {
				try {
					jsonResponse = mapper.writeValueAsString(user);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return jsonResponse;
	}
}

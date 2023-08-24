package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.MessuserService;

@RestController
@RequestMapping("/api/messuser")
public class MessuserController {

	@Autowired
	private MessuserService messuserService;
	
	@PostMapping
	public User createnewuser(@RequestBody User user) {
		return messuserService.createNewMess(user);
	}
	
	@GetMapping("/alluser")
	public List<User> findAllUser(){
		return messuserService.findAllMessUser();
	}
	
	@GetMapping("/{email}")
	public User finduserByEmail(@PathVariable String email) {
		return messuserService.findByUsersEmail(email);
	}
	
	@PutMapping("/updatepassword/{email}")
	public User modifyUserPassword(@PathVariable String email, User user) {
		return messuserService.updateMessUserPassword(email,user);
	}
	
	@DeleteMapping("/{email}")
	public String deleteMessUser(String email) {
		return messuserService.deleteMessUser(email);
	}
}

package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.MessuserRepository;

@Service
public class MessuserService {

	@Autowired
	private MessuserRepository messuserRepository;
	
	//CRUD operations
	//create operation
	public User createNewMess(User user) {
		return messuserRepository.save(user);
	}
	
	//read operations
	public List<User> findAllMessUser(){
		return messuserRepository.findAll();
	}
	
	public User findByUsersEmail(String email) {
		return messuserRepository.findByEmail(email);
	}
	
	//update 
	public User updateMessUserPassword(String email,User userrequest) {
		//get the existing document from DB
        //User existingUser = messuserRepository.findByEmail(userrequest.getEmail());
		User existingUser = messuserRepository.findByEmail(email);
		//populate new value to existing object 
		existingUser.setPassword(userrequest.getPassword());
		//save new mess user password
		return messuserRepository.save(existingUser);
	}
	
	//delete 
	public String deleteMessUser(String email) {
		messuserRepository.deleteByEmail(email);
		return email +"User deleted successfully";
	}
}

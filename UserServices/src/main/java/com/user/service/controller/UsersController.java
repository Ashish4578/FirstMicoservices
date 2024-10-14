package com.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entities.UsersMicro;
import com.user.service.services.UserServices;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UserServices userServices;

	@PostMapping
	public ResponseEntity<UsersMicro> createUser(@RequestBody UsersMicro user){
		UsersMicro users1= userServices.saveUsers(user);
		return  ResponseEntity.status(HttpStatus.CREATED).body(users1);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsersMicro> getUserById(@PathVariable String id){
		UsersMicro user =userServices.getUser(id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<List<UsersMicro>> getAllUsers(){
		List<UsersMicro> allUsers=userServices.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
}

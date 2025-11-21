package com.shadow.AutoScaleApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shadow.AutoScaleApi.dto.UserDto;
import com.shadow.AutoScaleApi.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Operation(summary = "Add a new user", description = "Creates a new user with the provided details")
	@PostMapping("/addUser")
	public ResponseEntity<Object> addUser(@Valid @RequestBody UserDto user) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
	}
	@Operation(summary = "Delete an existing user", description = "Deletes the user with the specified ID")
	@DeleteMapping("/deleteUser")
	public ResponseEntity<Object> deleteUser(@RequestParam Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
	}
	
	
	@Operation(summary = "Update an existing user", description = "Updates the details of the user with the provided information")
	@PutMapping("/updateUser")
	public ResponseEntity<Object> updateUser(@RequestBody UserDto user) {

		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user));
	}
	
	@Operation(summary = "Get a user by ID", description = "Retrieves the details of the user with the specified ID")
	@GetMapping("/getUser")
	public ResponseEntity<Object> getUser(@RequestParam Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
	}
	
	
	@Operation(summary = "Get all users", description = "Retrieves a list of all users")
	@GetMapping("/getUsers")
	public ResponseEntity<Object> getUsers() {

		return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
	}
	
}

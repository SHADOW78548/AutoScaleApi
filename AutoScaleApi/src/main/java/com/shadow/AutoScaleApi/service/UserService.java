package com.shadow.AutoScaleApi.service;

import java.util.List;
import java.util.Optional;

import com.shadow.AutoScaleApi.dto.UserDto;
import com.shadow.AutoScaleApi.dto.UserResponse;
import com.shadow.AutoScaleApi.exceptions.UserAlreadyExistsException;
import com.shadow.AutoScaleApi.exceptions.UserNotExistsException;

public interface UserService {
	UserResponse addUser(UserDto user) throws UserAlreadyExistsException;
	UserResponse deleteUser(Long id) throws UserNotExistsException;
	UserResponse updateUser(UserDto user) throws UserNotExistsException;
	UserResponse getUser(Long id) throws UserNotExistsException;
	List<UserResponse> getUsers() throws UserNotExistsException;
	
	
}

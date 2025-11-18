package com.shadow.AutoScaleApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadow.AutoScaleApi.dao.UserDao;
import com.shadow.AutoScaleApi.dto.UserDto;
import com.shadow.AutoScaleApi.dto.UserResponse;
import com.shadow.AutoScaleApi.exceptions.UserAlreadyExistsException;
import com.shadow.AutoScaleApi.exceptions.UserNotExistsException;
import com.shadow.AutoScaleApi.model.UserInfo;
import com.shadow.AutoScaleApi.utilities.UserUtils;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao dao;
	@Autowired
	UserUtils userUtil;
	@Override
	public UserResponse addUser(UserDto user) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		
		UserInfo existingUser= dao.findByName(user.getName());
		
		if (existingUser!=null) {
			throw new UserAlreadyExistsException("User with id " + user.getId() + " already exists");
		}else {
		UserInfo userInfo = userUtil.dtoToEntity(user);
		dao.save(userInfo);
		
		UserResponse response=userUtil.entityToResponse(userInfo);
		return response;
		}
	}

	@Override
	public UserResponse deleteUser(Long id) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		UserInfo userInfo =	dao.findById(id).orElse(null);
		if (userInfo==null) {
			throw new UserAlreadyExistsException("User with id " + id + " does not exists");
		}else {
		
		dao.deleteById(id);
		
		UserResponse response=userUtil.entityToResponse(userInfo);
		return response;
		}
	}

	@Override
	public UserResponse updateUser(UserDto user) throws UserNotExistsException {
		// TODO Auto-generated method stub
		if (!dao.existsById(user.getId())) {
			throw new UserNotExistsException("User with id " + user.getId() + " does not exists");
		}else {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(user.getId());
		userInfo.setName(user.getName());
		userInfo.setDesignation(user.getDesignation());
		dao.save(userInfo);
		UserResponse response=userUtil.entityToResponse(userInfo);
		
		return response;
		}
	}

	@Override
	public UserResponse getUser(Long id) throws UserNotExistsException {
		// TODO Auto-generated method stub
		
		if (!dao.existsById(id)) {
			throw new UserNotExistsException("User with id " + id + " does not exists");
		}else {
		UserInfo user= dao.findById(id).orElse(null);
		UserResponse response=userUtil.entityToResponse(user);
		
		return response;
		}
	}

	@Override
	public List<UserResponse> getUsers() throws UserNotExistsException {
		// TODO Auto-generated method stub
		if (dao.count() == 0) {
			throw new UserNotExistsException("No users exists");
		}
		List<UserInfo> users= dao.findAll();
		
		List<UserResponse> responses=userUtil.getUserResponses(users);
		
		
		
		return responses;
	}

}

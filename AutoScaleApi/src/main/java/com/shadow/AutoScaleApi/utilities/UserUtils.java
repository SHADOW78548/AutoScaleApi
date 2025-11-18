package com.shadow.AutoScaleApi.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.shadow.AutoScaleApi.dto.UserDto;
import com.shadow.AutoScaleApi.dto.UserResponse;
import com.shadow.AutoScaleApi.model.UserInfo;
@Component
public class UserUtils {
	UserInfo userInfo;
	UserDto userDto;

	public  UserInfo dtoToEntity(UserDto userDto) {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(userDto.getId());
		userInfo.setName(userDto.getName());
		userInfo.setDesignation(userDto.getDesignation());
		return userInfo;
	}
	
	public  UserDto entityToDto(UserInfo userInfo) {
		UserDto userDto = new UserDto();
		userDto.setId(userInfo.getId());
		userDto.setName(userInfo.getName());
		userDto.setDesignation(userInfo.getDesignation());
		return userDto;
	}
	
	public  UserResponse entityToResponse(UserInfo user) {
		UserResponse response = new UserResponse();
		response.setName(user.getName());
		response.setDesignation(user.getDesignation());
		return response;
	}
	
	public List<UserResponse> getUserResponses(List<UserInfo> users) {
		List<UserResponse> responses = new ArrayList<>();
		for (UserInfo user : users) {
			UserResponse response = entityToResponse(user);
			responses.add(response);
		}
		return responses;
	}
	
}

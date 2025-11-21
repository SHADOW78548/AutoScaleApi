package com.shadow.AutoScaleApi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "Response Object for User")
public class UserResponse {
	@Schema(description = "Name of the User", example = "Sujit Mondal")
	private String name;
	@Schema(description = "Designation of the User", example = "Developer")
	private String designation;
	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserResponse(String name, String designation) {
		super();
		this.name = name;
		this.designation = designation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	

}

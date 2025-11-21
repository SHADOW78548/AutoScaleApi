package com.shadow.AutoScaleApi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
@Schema(description = "Data Transfer Object for User")
public class UserDto {
	@Schema(description = "Unique identifier of the User", example = "1")
	private Long id;
	@Schema(description = "Name of the User", example = "Sujit Mondal")
	@NotNull(message="Name cannot be null")
	private String name;
	@Schema(description = "Designation of the User", example = "Developer")
	@Pattern(regexp="^(Developer|Manager|Tester|HR)$", message="Designation must be one of the following: Developer, Manager, Tester, HR")
	private String designation;

	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(Long id, String name, String designation) {
		
		this.id = id;
		this.name = name;
		this.designation = designation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

package com.myTinyLibrary.user.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
	
	private String id;
	private String name;
	private String password;
	private String email;
	private String joinDate;

}

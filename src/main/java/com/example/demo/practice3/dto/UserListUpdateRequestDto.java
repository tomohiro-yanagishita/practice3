package com.example.demo.practice3.dto;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class UserListUpdateRequestDto implements Serializable{
	
	@Valid
	private List<UserUpdateRequestDto> userDataList;
	

}

package com.example.demo.practice3.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserSearchRequestDto implements Serializable {
	
    /**
     * ユーザーID
     */
    private String id;
    /**
     * ユーザー名
     */
    private String name;

}

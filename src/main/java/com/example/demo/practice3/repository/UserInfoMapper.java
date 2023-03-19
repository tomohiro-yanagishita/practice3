package com.example.demo.practice3.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.practice3.dto.UserAddRequestDto;
import com.example.demo.practice3.dto.UserSearchRequestDto;
import com.example.demo.practice3.dto.UserUpdateRequestDto;
import com.example.demo.practice3.entity.UserInfoEntity;

@Mapper
public interface UserInfoMapper {
	
	List<UserInfoEntity> findAll();
	
	void save(UserAddRequestDto userAddRequestDto);
	
	List<UserInfoEntity> search(UserSearchRequestDto user);
	
	void delete(Long id);
	
	UserInfoEntity findById(Long id);
	
	void update(UserUpdateRequestDto userUpdateRequestDto);

}

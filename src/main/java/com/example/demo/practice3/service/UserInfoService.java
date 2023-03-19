package com.example.demo.practice3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.practice3.dto.UserAddRequestDto;
import com.example.demo.practice3.dto.UserListUpdateRequestDto;
import com.example.demo.practice3.dto.UserSearchRequestDto;
import com.example.demo.practice3.dto.UserUpdateRequestDto;
import com.example.demo.practice3.entity.UserInfoEntity;
import com.example.demo.practice3.repository.UserInfoMapper;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	public List<UserInfoEntity> findAll(){
		return userInfoMapper.findAll();
		
	}
	
	public UserListUpdateRequestDto findListAll() {
		List<UserInfoEntity> userList = userInfoMapper.findAll();
		UserListUpdateRequestDto userListUpdateRequestDto = new UserListUpdateRequestDto();
		List<UserUpdateRequestDto> list = new ArrayList<UserUpdateRequestDto>();
		/*
		 * エンティティを画面データに詰め替え
		 */
		for(UserInfoEntity user: userList) {
			UserUpdateRequestDto data = new UserUpdateRequestDto();
			data.setId(user.getId());
			data.setName(user.getName());
			data.setAddress(user.getAddress());
			data.setPhone(user.getPhone());
			list.add(data);			
		}
		userListUpdateRequestDto.setUserDataList(list);
		return userListUpdateRequestDto;
		
		
	}
	
	public List<UserInfoEntity> search(UserSearchRequestDto userSearchRequestDto){
		return userInfoMapper.search(userSearchRequestDto);
	}
	
	public void save(UserAddRequestDto userAddRequestDto) {
		userInfoMapper.save(userAddRequestDto);
	}
	
	public void delete(Long id) {
		userInfoMapper.delete(id);
	}
	
	public UserInfoEntity findById(Long id) {
		return userInfoMapper.findById(id);
	}
	
	public void update(UserUpdateRequestDto userUpdateRequestDto) {
		userInfoMapper.update(userUpdateRequestDto);
	}
	
	public void updateAll(UserListUpdateRequestDto userListUpdateRequestDto) {
//		List<UserUpdateRequestDto> userList = (List<UserUpdateRequestDto>) userListUpdateRequestDto;
//		for(UserUpdateRequestDto userUpdateRequestDto: userList) {
//			userInfoMapper.update(userUpdateRequestDto);
//		}
//		for(UserUpdateRequestDto userUpdateRequestDto: userListUpdateRequestDto) {
//			userInfoMapper.update(userUpdateRequestDto);
//		}
//		List<UserUpdateRequestDto> userList = new ArrayList<UserUpdateRequestDto>();
		for(UserUpdateRequestDto data: userListUpdateRequestDto.getUserDataList()) {
			userInfoMapper.update(data);
		}
		
	}
	

}

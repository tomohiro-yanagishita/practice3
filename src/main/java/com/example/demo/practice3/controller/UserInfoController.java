package com.example.demo.practice3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.practice3.dto.UserAddRequestDto;
import com.example.demo.practice3.dto.UserListUpdateRequestDto;
import com.example.demo.practice3.dto.UserSearchRequestDto;
import com.example.demo.practice3.dto.UserUpdateRequestDto;
import com.example.demo.practice3.entity.UserInfoEntity;
import com.example.demo.practice3.service.UserInfoService;

@Controller
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	/*
	 * 初期表示
	 */
	@GetMapping("/user/list")
	public String displayList(Model model) {
		List<UserInfoEntity> userList = userInfoService.findAll();
		model.addAttribute("userlist", userList);
		model.addAttribute("userSearchRequestDto", new UserSearchRequestDto());
		return "practice3/user/search";
		
	}
	/*
	 * ユーザ検索（ID,名前）
	 */
	@PostMapping("/user/search")
	public String search(@ModelAttribute UserSearchRequestDto userSearchRequestDto, Model model) {
		List<UserInfoEntity> userList = userInfoService.search(userSearchRequestDto);
		model.addAttribute("userlist", userList);
		return "practice3/user/search";
	}
	
	/*
	 * 追加画面に遷移
	 */
	@GetMapping("/user/add")
	public String displayAdd(Model model) {
		model.addAttribute("userAddRequestDto", new UserAddRequestDto());
		return "practice3/user/add";
	}
	/*
	 * 追加後、一覧画面に戻る
	 * エラーの場合、画面遷移せずエラーメッセージを表示
	 */	
	@PostMapping("/user/create")
	public String create(@Validated @ModelAttribute UserAddRequestDto userAddRequestDto, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for(ObjectError error: result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "practice3/user/add";
			
		}
		
		userInfoService.save(userAddRequestDto);
		return "redirect:/user/list";
	}
	
	/*
	 * ユーザ削除
	 */
	@GetMapping("/user/{id}/delete")
	public String delete(@PathVariable Long id, Model model) {
		userInfoService.delete(id);
		return "redirect:/user/list";
	}
	
	/*
	 * ユーザ詳細画面遷移
	 */
	 @GetMapping("/user/{id}/detail") 
	 public String detail(@PathVariable Long id,Model model) { 
		 UserInfoEntity user = userInfoService.findById(id);
		 model.addAttribute("userData", user); 
		 return "practice3/user/detail";
	 }
	 
	 /*
	  * ユーザ編集画面に遷移
	  */
	 @GetMapping("/user/{id}/edit")
	 public String displayEdit(@PathVariable long id, Model model) {
		 UserInfoEntity user = userInfoService.findById(id);
		 UserUpdateRequestDto userUpdateRequestDto = new UserUpdateRequestDto();
		 userUpdateRequestDto.setId(user.getId());
		 userUpdateRequestDto.setName(user.getName());
		 userUpdateRequestDto.setPhone(user.getPhone());
		 userUpdateRequestDto.setAddress(user.getAddress());
		 model.addAttribute("userUpdateRequestDto", userUpdateRequestDto);
		 return "practice3/user/edit";	 
		 
	 }
	 
	 /*
	  * ユーザ編集登録
	  */
	 @PostMapping("/user/update")
	 public String update(@Validated @ModelAttribute UserUpdateRequestDto userUpdateRequestDto, BindingResult result, Model model) {
		 if(result.hasErrors()) {
			 List<String> errorList = new ArrayList<String>();
			 for(ObjectError error:result.getAllErrors()) {
				 errorList.add(error.getDefaultMessage());
			 }
			 model.addAttribute("validationError", errorList);
			 return "practice3/user/edit";		 
		 }
		 userInfoService.update(userUpdateRequestDto);
		 return "redirect:/user/list";
		 
	 }
	 
	 /*
	  * ユーザ一括編集画面遷移
	  */
	 @GetMapping("/user/editAll")
	 public String displayEditAll(Model model){
		 UserListUpdateRequestDto userListUpdateRequestDto = userInfoService.findListAll();
		 model.addAttribute("userListUpdateRequestDto", userListUpdateRequestDto);
		 return "practice3/user/editAll";
	 }
	 
	 /*
	  * ユーザ一括編集登録
	  */
	 @PostMapping("/user/listUpdate")
	 public String listUpdate(@Validated @ModelAttribute UserListUpdateRequestDto userListUpdateRequestDto, BindingResult result, Model model) {
		 if(result.hasErrors()) {
			 List<String> errorList = new ArrayList<String>();
			 for(ObjectError error:result.getAllErrors()) {
				 if (!errorList.contains(error.getDefaultMessage())) {
			          errorList.add(error.getDefaultMessage());
			      }
			 }
			 model.addAttribute("validationError", errorList);
			 return "practice3/user/editAll";
		 }
		 userInfoService.updateAll(userListUpdateRequestDto);
		 return "redirect:/user/list";
	 }




}

package com.example.demo.practice2.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.practice2.dto.UserSearchRequest;
import com.example.demo.practice2.entity.User;
import com.example.demo.practice2.repository.UserMapper;

/**
 * ユーザー情報 Service
 */
@Service
public class UserService {
    /**
     * ユーザー情報 Mapper
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * ユーザー情報検索
　　　* @param userSearchRequest リクエストデータ
     * @return 検索結果
     */
    public User search(UserSearchRequest userSearchRequest) {
        return userMapper.search(userSearchRequest);
    }
}
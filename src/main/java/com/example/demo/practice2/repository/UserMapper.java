package com.example.demo.practice2.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.practice2.dto.UserSearchRequest;
import com.example.demo.practice2.entity.User;
/**
 * ユーザー情報 Mapper
 */
@Mapper
public interface UserMapper {
    /**
     * ユーザー情報検索
     * @param user 検索用リクエストデータ
     * @return ユーザー情報
     */
    User search(UserSearchRequest user);
}
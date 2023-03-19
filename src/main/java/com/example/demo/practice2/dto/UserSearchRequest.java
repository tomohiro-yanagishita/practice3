package com.example.demo.practice2.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserSearchRequest implements Serializable {
  /**
   * ユーザーID
   */
  private Long id;
}


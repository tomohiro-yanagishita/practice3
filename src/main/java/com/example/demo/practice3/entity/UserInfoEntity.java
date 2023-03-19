package com.example.demo.practice3.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserInfoEntity implements Serializable{
	
    /**
     * ID
     */
    private Long id;
    /**
     * 名前
     */
    private String name;
    /**
     * 住所
     */
    private String address;
    /**
     * 電話番号
     */
    private String phone;
    /**
     * 更新日時
     */
    private Date updateDate;
    /**
     * 登録日時
     */
    private Date createDate;
    /**
     * 削除日時
     */
    private Date deleteDate;
	

}

package com.example.demo.practice3.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserUpdateRequestDto extends UserAddRequestDto implements Serializable {
    /**
     * ユーザーID
     */
    @NotNull
    private Long id;

}

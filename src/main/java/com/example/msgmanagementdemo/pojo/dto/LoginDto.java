package com.example.msgmanagementdemo.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author xiaoying
 * @create 2023/3/8
 */
@Data
@AllArgsConstructor
public class LoginDto {
    private String userName;
    private String password;
}

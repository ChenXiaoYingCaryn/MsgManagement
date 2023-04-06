package com.example.msgmanagementdemo.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xiaoying
 * @create 2023/3/8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterDto {
    private String userName;
    private String password;
    private String mobile;
    private String email;
}

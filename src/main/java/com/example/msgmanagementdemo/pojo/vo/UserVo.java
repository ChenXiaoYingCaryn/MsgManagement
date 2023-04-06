package com.example.msgmanagementdemo.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author xiaoying
 * @create 2023/3/8
 */
@Data
@AllArgsConstructor
public class UserVo {
    private String id;
    private String userName;
    private String mobile;
    private String email;
    private String createTime;
}

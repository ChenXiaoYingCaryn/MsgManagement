package com.example.msgmanagementdemo.service;

import com.example.msgmanagementdemo.pojo.dto.LoginDto;
import com.example.msgmanagementdemo.pojo.dto.RegisterDto;
import com.example.msgmanagementdemo.pojo.po.UserPo;
import com.example.msgmanagementdemo.pojo.vo.UserVo;

/**
 * @author xiaoying
 * @create 2023/3/8
 */
public interface UserService {

    UserVo login(UserPo po);

    void register(UserPo po);

}

package com.example.msgmanagementdemo.controller;

import com.example.msgmanagementdemo.common.CommonResult;
import com.example.msgmanagementdemo.factory.UserFactory;
import com.example.msgmanagementdemo.pojo.dto.LoginDto;
import com.example.msgmanagementdemo.pojo.dto.RegisterDto;
import com.example.msgmanagementdemo.pojo.po.UserPo;
import com.example.msgmanagementdemo.pojo.vo.UserVo;
import com.example.msgmanagementdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaoying
 * @create 2023/3/27 16:31
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public CommonResult login(@RequestBody LoginDto loginDto){
        UserPo po = UserFactory.DtoToUserPo(loginDto);
        UserVo vo;
        try {
            vo = userService.login(po);
        }catch (Exception e){
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(vo);
    }

    @PostMapping("/register")
    public CommonResult register(@RequestBody RegisterDto registerDto){
        UserPo po = UserFactory.DtoToUserPo(registerDto);
        try {
            userService.register(po);
        }catch (Exception e){
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success();
    }
}

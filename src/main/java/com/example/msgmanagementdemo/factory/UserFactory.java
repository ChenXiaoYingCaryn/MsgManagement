package com.example.msgmanagementdemo.factory;

import com.example.msgmanagementdemo.pojo.dto.LoginDto;
import com.example.msgmanagementdemo.pojo.dto.RegisterDto;
import com.example.msgmanagementdemo.pojo.po.UserPo;
import com.example.msgmanagementdemo.pojo.vo.UserVo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaoying
 * @create 2023/3/8
 */
public class UserFactory {

    static SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static Date date = new Date(System.currentTimeMillis());

    public static UserVo PoToVo(UserPo userPo){
        return new UserVo(
                userPo.getId(),
                userPo.getUserName(),
                userPo.getMobile(),
                userPo.getEmail(),
                userPo.getCreateTime()
        );
    }

    public static UserPo DtoToUserPo(LoginDto loginDto){
        return new UserPo(
                loginDto.getUserName(),
                loginDto.getPassword()
        );
    }

    public static UserPo DtoToUserPo(RegisterDto registerDto){
        return new UserPo(
                registerDto.getUserName(),
                registerDto.getPassword(),
                registerDto.getMobile(),
                registerDto.getEmail(),
                formatter.format(date)
        );
    }
}

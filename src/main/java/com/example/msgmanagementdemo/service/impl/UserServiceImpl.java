package com.example.msgmanagementdemo.service.impl;

import com.example.msgmanagementdemo.dao.UserDao;
import com.example.msgmanagementdemo.factory.UserFactory;
import com.example.msgmanagementdemo.pojo.po.UserPo;
import com.example.msgmanagementdemo.pojo.vo.UserVo;
import com.example.msgmanagementdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaoying
 * @create 2023/3/8
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserVo login(UserPo po) {
        UserPo user;
        try{
            user = userDao.findOne(po);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        if(user == null){
            throw new RuntimeException("用户名或密码错误");
        }
        return UserFactory.PoToVo(user);
    }

    @Override
    public void register(UserPo po) {
        try{
            userDao.save(po);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

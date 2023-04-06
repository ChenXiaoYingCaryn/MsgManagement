package com.example.msgmanagementdemo.dao;

import com.example.msgmanagementdemo.pojo.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;


/**
 * @author xiaoying
 * @create 2023/3/27 16:12
 */
@Component
public class UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public UserPo findOne(UserPo po){
        Query query = new Query();
        query.addCriteria(Criteria
                .where("user_name").is(po.getUserName())
                .and("password").is(po.getPassword())
        );
        return mongoTemplate.findOne(query, UserPo.class);
    }

    public void save(UserPo po){
        mongoTemplate.insert(po);
    }

}

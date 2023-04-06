package com.example.msgmanagementdemo.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author xiaoying
 * @create @create 2023/3/27 16:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("user_management")
public class UserPo {
    @Id
    private String id;
    @Field("user_name")
    private String userName;
    private String password;
    private String mobile;
    private String email;
    @Field("create_time")
    private String createTime;

    public UserPo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserPo(String userName, String password, String mobile, String email, String createTime) {
        this.userName = userName;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
        this.createTime = createTime;
    }
}

package com.example.msgmanagementdemo.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashMap;
import java.util.List;

/**
 * @author xiaoying
 * @create 2023/3/20 15:33
 */
@Data
@Document(collection = "msg_management")
public class NodePo {
    @Id
    private String id;
    private String type; //0:目录 1:产品
    private String name;
    @Field("msg")
    private List<HashMap<String,String>> msg;
    @Field("parent_id")
    private String parentId;

    @Field("user_id")
    private String userId;
    @Field("create_time")
    private String createTime;

    @Field("is_deleted")
    private String isDeleted;

    public NodePo() {
    }

    public NodePo(String id, String type, String name, List<HashMap<String, String>> msg, String parentId, String userId, String createTime, String isDeleted) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.msg = msg;
        this.parentId = parentId;
        this.userId = userId;
        this.createTime = createTime;
        this.isDeleted = isDeleted;
    }

    public NodePo(String id, String name, List<HashMap<String, String>> msg, String userId) {
        this.id = id;
        this.name = name;
        this.msg = msg;
        this.userId = userId;
    }

    public NodePo(String type, String name, List<HashMap<String, String>> msg, String parentId, String userId, String createTime, String isDeleted) {
        this.type = type;
        this.name = name;
        this.msg = msg;
        this.parentId = parentId;
        this.userId = userId;
        this.createTime = createTime;
        this.isDeleted = isDeleted;
    }

    public NodePo(String type, String name, List<HashMap<String, String>> msg, String parentId, String userId, String createTime) {
        this.type = type;
        this.name = name;
        this.msg = msg;
        this.parentId = parentId;
        this.userId = userId;
        this.createTime = createTime;
    }

    public NodePo(String id, String userId) {
        this.id = id;
        this.userId = userId;
    }
}

package com.example.msgmanagementdemo.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

/**
 * @author xiaoying
 * @create 2023/3/20 15:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeVo {
    private String id;
    private String type; //0:目录 1:产品
    private String name;
    private List<HashMap<String,String>> msg;

    private String parentId;
    private String userId;
    private String createTime;
    private List<NodeVo> childrenList;

    public NodeVo(String id, String type, String name, List<HashMap<String, String>> msg, String parentId, String userId, String createTime) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.msg = msg;
        this.parentId = parentId;
        this.userId = userId;
        this.createTime = createTime;
    }
}

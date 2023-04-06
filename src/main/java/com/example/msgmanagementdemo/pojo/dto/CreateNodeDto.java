package com.example.msgmanagementdemo.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

/**
 * @author xiaoying
 * @create 2023/3/20 15:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNodeDto {
    private String type; //0:目录 1:产品
    private String name;
    private List<HashMap<String,String>> msg;
    private String parentId;
    private String userId;
}

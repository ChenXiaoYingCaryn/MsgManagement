package com.example.msgmanagementdemo.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

/**
 * @author xiaoying
 * @create 2023/3/27 15:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNodeDto {
    private String id;
    private String name;
    private List<HashMap<String,String>> msg;
    private String userId;
}

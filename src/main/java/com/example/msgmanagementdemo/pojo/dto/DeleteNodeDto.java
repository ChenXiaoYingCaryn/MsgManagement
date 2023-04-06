package com.example.msgmanagementdemo.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoying
 * @create 2023/3/27 15:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteNodeDto {
    private String id;
    private String userId;
}

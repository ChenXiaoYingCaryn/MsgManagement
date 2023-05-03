package com.example.msgmanagementdemo.service;

import com.example.msgmanagementdemo.pojo.dto.FindNodeByNameDto;
import com.example.msgmanagementdemo.pojo.po.NodePo;
import com.example.msgmanagementdemo.pojo.vo.NodeVo;

import java.util.List;

/**
 * @author xiaoying
 * @create 2023/3/20 15:45
 */
public interface NodeService {

    List<NodeVo> findByNodeName(FindNodeByNameDto dto);

    List<NodeVo> findByUserId(String userId);

    void delete(NodePo po);

    NodeVo update(NodePo po);

    List<NodeVo> queryAll();

    NodeVo save(NodePo po);
}

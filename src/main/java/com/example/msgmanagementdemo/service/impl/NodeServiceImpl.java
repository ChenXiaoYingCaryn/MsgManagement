package com.example.msgmanagementdemo.service.impl;

import com.example.msgmanagementdemo.dao.NodeDao;
import com.example.msgmanagementdemo.factory.NodeFactory;
import com.example.msgmanagementdemo.pojo.dto.FindNodeByNameDto;
import com.example.msgmanagementdemo.pojo.po.NodePo;
import com.example.msgmanagementdemo.pojo.vo.NodeVo;
import com.example.msgmanagementdemo.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.soap.Node;
import java.util.*;

/**
 * @author xiaoying
 * @create 2023/3/20 15:46
 */
@Service
public class NodeServiceImpl implements NodeService {

    @Autowired
    private NodeDao nodeDao;

    @Override
    public List<NodeVo> findByNodeName(FindNodeByNameDto dto) {
        List<NodeVo> NodeVoList = findByUserId(dto.getUserId());
        List<NodeVo> res = new ArrayList<>();

        for(NodeVo vo : NodeVoList){
            List<NodeVo> list = getNodeByName(vo, dto.getName());
            if(!list.isEmpty()){
                res.addAll(list);
            }
        }
        return res;
    }

    @Override
    public List<NodeVo> findByUserId(String userId) {
        List<NodeVo> nodeVos = queryAll();
        List<NodeVo> res = new ArrayList<>();
        for(NodeVo vo : nodeVos){
            if(vo.getUserId().equals(userId)){
               res.add(vo);
            }
        }
        return res;
    }

    @Override
    public void delete(NodePo po) {
        try{
            nodeDao.delete(po);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public NodeVo update(NodePo po) {
        NodeVo vo;
        try{
            nodeDao.upsert(po);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        vo = NodeFactory.PoToVo(po);
        return vo;
    }

    @Override
    public List<NodeVo> queryAll() {
        List<NodePo> nodePos;
        List<NodeVo> nodeVos = new ArrayList<>();
        List<NodeVo> res = new ArrayList<>();

        try{
            nodePos = nodeDao.queryAll();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

        for(NodePo po : nodePos){
            NodeVo vo = NodeFactory.PoToVo(po);
            nodeVos.add(vo);
        }
        HashMap<String, List<NodeVo>> map = parentIdMapNodeVo(nodeVos);
        res = map.get("0");
        for(NodeVo vo : res){
            vo = getTree(map, vo);
        }
        return res;
    }

    @Override
    public NodeVo save(NodePo po) {
        NodeVo vo;
        try{
            nodeDao.insert(po);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        vo = NodeFactory.PoToVo(po);
        return vo;
    }

    // 根据parentId将node分类
    public HashMap<String, List<NodeVo>> parentIdMapNodeVo(List<NodeVo> list){
        HashMap<String, List<NodeVo>> map = new HashMap<>();
        for(NodeVo vo : list){
            String parentId = vo.getParentId();
            List<NodeVo> l = map.getOrDefault(parentId, new ArrayList<NodeVo>());
            l.add(vo);
            map.put(parentId, l);
        }
        return map;
    }

    // 构建树
    public NodeVo getTree(HashMap<String, List<NodeVo>> map, NodeVo vo){
        List<NodeVo> childs = map.get(vo.getId());
        vo.setChildrenList(childs);
        if(childs != null){
            for(NodeVo item : childs){
                getTree(map, item);
            }
        }
        return vo;
    }

    // 通过名字获取节点
    public List<NodeVo> getNodeByName(NodeVo vo, String name){
        List<NodeVo> res = new ArrayList<>();
        Queue<NodeVo> queue = new ArrayDeque<>();
        if(vo == null){
            return res;
        }
        queue.offer(vo);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<NodeVo> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                NodeVo node = queue.poll();
                if(judgeName(node.getName(), name)){
                    res.add(node);
                }
                if(node.getChildrenList() != null){
                    for(NodeVo v : node.getChildrenList()){
                        queue.offer(v);
                    }
                }
            }
        }
        return res;
    }

    // 使用正则判断名字是否符合
    public boolean judgeName(String nodeName, String inputName){
        String regex = String.format("%s%s%s", ".*", inputName, ".*");
        return nodeName.matches(regex);
    }
}

package com.example.msgmanagementdemo.dao;

import com.example.msgmanagementdemo.pojo.po.NodePo;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Queue;

/**
 * @author xiaoying
 * @create 2023/3/26 23:20
 */

@Component
public class NodeDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增节点
     */
    public void insert(NodePo po){
        mongoTemplate.insert(po);
    }

    /**
     * 查全部未删除的子节点
     */
    public List<NodePo> queryAll(){
        Query query = new Query();
        query.addCriteria(Criteria.where("is_deleted").is("0"));
        return mongoTemplate.find(query, NodePo.class);
    }

    /**
     * 更新节点名称和节点信息
     */
    public void upsert(NodePo po){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(po.getId()));

        Update update = new Update();
        update.set("name", po.getName());
        update.set("msg", po.getMsg());

        mongoTemplate.upsert(query, update, NodePo.class);
    }

    /**
     * 删除节点
     */
    public void delete(NodePo po){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(po.getId()));

        Update update = new Update();
        update.set("is_deleted", "1");

        mongoTemplate.upsert(query, update, NodePo.class);
    }

}

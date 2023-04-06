package com.example.msgmanagementdemo.factory;

import com.example.msgmanagementdemo.pojo.dto.CreateNodeDto;
import com.example.msgmanagementdemo.pojo.dto.DeleteNodeDto;
import com.example.msgmanagementdemo.pojo.dto.UpdateNodeDto;
import com.example.msgmanagementdemo.pojo.po.NodePo;
import com.example.msgmanagementdemo.pojo.vo.NodeVo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaoying
 * @create 2023/3/20 15:53
 */
public class NodeFactory {

    static SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static Date date = new Date(System.currentTimeMillis());

    public static NodeVo PoToVo(NodePo po){
        return new NodeVo(
                po.getId(),
                po.getType(),
                po.getName(),
                po.getMsg(),
                po.getParentId(),
                po.getUserId(),
                po.getCreateTime()
        );
    }


    public static NodePo DtoToPo(CreateNodeDto dto){
        return new NodePo(
                dto.getType(),
                dto.getName(),
                dto.getMsg(),
                dto.getParentId(),
                dto.getUserId(),
                formatter.format(date.getTime()),
                "0"
        );
    }

    public static NodePo DtoToPo(UpdateNodeDto dto){
        return new NodePo(
                dto.getId(),
                dto.getName(),
                dto.getMsg(),
                dto.getUserId()
        );
    }

    public static NodePo DtoToPo(DeleteNodeDto dto){
        return new NodePo(
                dto.getId(),
                dto.getUserId()
        );
    }
}

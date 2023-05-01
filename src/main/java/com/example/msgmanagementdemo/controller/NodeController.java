package com.example.msgmanagementdemo.controller;

import com.example.msgmanagementdemo.common.CommonResult;
import com.example.msgmanagementdemo.factory.NodeFactory;
import com.example.msgmanagementdemo.pojo.dto.*;
import com.example.msgmanagementdemo.pojo.po.NodePo;
import com.example.msgmanagementdemo.pojo.vo.NodeVo;
import com.example.msgmanagementdemo.service.NodeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoying
 * @create 2023/3/20 15:49
 */
@Api
@RestController
@RequestMapping("/node")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @PostMapping("/FindByNodeName")
    public CommonResult<List<NodePo>> findByNodeName(@RequestBody FindNodeByNameDto dto){
        List<NodePo> res = new ArrayList<>();
        try{
            res = nodeService.findByNodeName(dto);
        }catch (Exception e){
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(res);
    }

    @PostMapping("/FindByUserId")
    public CommonResult<List<NodeVo>> findByUserId(@RequestBody FindTreeByUserIdDto dto){
        List<NodeVo> res = new ArrayList<>();
        try{
            res = nodeService.findByUserId(dto.getUserId());
        }catch (Exception e){
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(res);
    }

    @PostMapping("/DeleteNode")
    public CommonResult deleteNode(@RequestBody DeleteNodeDto dto){
        NodePo po = NodeFactory.DtoToPo(dto);
        try{
            nodeService.delete(po);
        }catch (Exception e){
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success();
    }

    @PostMapping("/UpdateNode")
    public CommonResult<NodeVo> updateNode(@RequestBody UpdateNodeDto dto){
        NodePo po = NodeFactory.DtoToPo(dto);
        NodeVo vo;
        try{
            vo = nodeService.update(po);
        }catch (Exception e){
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(vo);
    }

    @PostMapping("/QueryAll")
    public CommonResult<List<NodeVo>> queryAll(){
        List<NodeVo> res = new ArrayList<>();
        try{
            res = nodeService.queryAll();
        }catch (Exception e){
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(res);
    }

    @PostMapping("/CreateNode")
    public CommonResult<NodeVo> CreateNode(@RequestBody CreateNodeDto dto){
        NodePo po = NodeFactory.DtoToPo(dto);
        NodeVo vo;
        try{
            vo = nodeService.save(po);
        }catch (Exception e){
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(vo);
    }


}

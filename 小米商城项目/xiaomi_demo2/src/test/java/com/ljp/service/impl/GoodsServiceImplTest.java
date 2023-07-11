package com.ljp.service.impl;

import com.github.pagehelper.PageInfo;
import com.ljp.entity.Goods;
import com.ljp.service.GoodsService;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GoodsServiceImplTest {

    @Test
    public void findByPage2() {
        GoodsService goodsService=new GoodsServiceImpl();
        Map<String,Object> condition=new HashMap<>();
        condition.put("pageNum",1);
        condition.put("pageSize",8);
        condition.put("typeId",1);
        PageInfo<Goods> pageInfo = goodsService.findByPage2(condition);
        System.out.println(pageInfo.getSize());
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getList().toString());
    }
}
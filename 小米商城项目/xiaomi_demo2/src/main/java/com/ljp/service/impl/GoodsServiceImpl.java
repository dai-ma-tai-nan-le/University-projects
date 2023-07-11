package com.ljp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljp.dao.GoodsDao;
import com.ljp.entity.Goods;
import com.ljp.entity.PageBean;
import com.ljp.service.GoodsService;
import com.ljp.util.MyBatisUtils;

import java.util.List;
import java.util.Map;

public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao= MyBatisUtils.getMapper(GoodsDao.class);
    @Override
    public PageBean<Goods> findByPage(Map<String, Object> condition) {

        Integer pageNum = (Integer) condition.get("pageNum");
        Integer pageSize = (Integer) condition.get("pageSize");
//        System.out.println("pageSize="+pageSize);
        long totalSize=goodsDao.getCount(condition);
        List<Goods> data=goodsDao.selectByPage(condition);
        PageBean<Goods> pageBean=new PageBean<>(pageNum,pageSize,totalSize,data);
        return pageBean;
    }

    @Override
    public PageInfo<Goods> findByPage2(Map<String, Object> condition) {
        Integer pageNum = (Integer) condition.get("pageNum");
        Integer pageSize = (Integer) condition.get("pageSize");
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> data=goodsDao.select(condition);
        PageInfo<Goods> pageInfo=new PageInfo<>(data);
        return pageInfo;
    }

    @Override
    public Goods findById(int gid) {
        Goods goods= goodsDao.selectById(gid);
        MyBatisUtils.clearCache();//清除缓存
        if (goods == null){
            throw new  RuntimeException("商品不存在");
        }
        return goods;
    }
}

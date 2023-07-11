package com.ljp.service.impl;

import com.ljp.dao.GoodsTypeDao;
import com.ljp.entity.GoodsType;
import com.ljp.service.GoodsTypeService;
import com.ljp.util.MyBatisUtils;

import java.util.List;

public class GoodsTypeServiceImpl implements GoodsTypeService {
    private GoodsTypeDao goodsTypeDao= MyBatisUtils.getMapper(GoodsTypeDao.class);

    @Override
    public List<GoodsType> findAll() {
        return goodsTypeDao.selectAll();
    }
}

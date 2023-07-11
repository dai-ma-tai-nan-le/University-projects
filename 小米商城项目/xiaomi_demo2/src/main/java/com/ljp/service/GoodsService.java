package com.ljp.service;

import com.github.pagehelper.PageInfo;
import com.ljp.entity.Goods;
import com.ljp.entity.PageBean;

import java.util.Map;

public interface GoodsService {
    PageBean<Goods> findByPage(Map<String, Object> condition);

    PageInfo<Goods> findByPage2(Map<String, Object> condition);

    Goods findById(int gid);
}

package com.offcn.imovie.service;

import com.offcn.imovie.pojo.CategroyVO;

import java.util.List;

public interface CategroyService {

    List<CategroyVO> vos();

    public void deleteByCategroy(String categroy);

    /**
     * 根据大分类名称查询vo对象
     * @param categroy
     * @return
     */
    CategroyVO getCategroyVo(String categroy);

    //删除小分类
    public void deleteTitle(String categroy,String title);
}


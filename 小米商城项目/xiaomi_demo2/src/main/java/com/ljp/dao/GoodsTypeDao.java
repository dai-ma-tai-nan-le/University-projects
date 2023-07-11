package com.ljp.dao;

import com.ljp.entity.GoodsType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsTypeDao {

    @Select("select * from type")
    List<GoodsType> selectAll();

    @Select("select * from type where t_id=#{id}")
    List<GoodsType> selectById(int id);
}

package com.ljp.dao;

import com.ljp.entity.Goods;
import com.ljp.entity.GoodsType;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

public interface GoodsDao {
    @Select("<script>" +
            "select count(*) from product" +
            "<where>" +
            "<if test='p_name==null'>"+
            "and t_id=#{typeId}"+
            "</if>"+
            "<if test='p_name!=null'>"+
            "and p_name like '%' #{name} '%' or t_id=#{typeId}"+
            "</if>"+
            "</where>"+
            "</script>")
    long getCount(Map<String,Object> condition);

//    @Select("<script>" +
//            "select * from product" +
//            "<where>" +
//            "<if test='t_id!=null'>"+
//            "and t_id=#{typeId}"+
//            "</if>"+
//            "<if test='p_name!=null'>"+
//            "and p_name like '%' #{name} '%'"+
//            "</if>"+
//            "</where>"+
//            "limit #{start},#{pageSize}"+
//            "</script>")
    @Select("<script>" +
            "select * from product" +
            "<where>" +
            "<if test='p_name==null'>"+
            "and t_id=#{typeId}"+
            "</if>"+
            "<if test='p_name!=null'>"+
            "and p_name like '%' #{name} '%' or t_id=#{typeId}"+
            "</if>"+
            "</where>"+
            "limit #{start},#{pageSize}"+
            "</script>")
    List<Goods> selectByPage(Map<String,Object> condition);

//    @Select("<script>" +
//            "select * from product" +
//            "<where>" +
//            "<if test='t_id!=null'>"+
//            "and t_id=#{typeId}"+
//            "</if>"+
//            "<if test='p_name!=null'>"+
//            "and p_name like '%' #{name} '%'"+
//            "</if>"+
//            "</where>"+
//            "</script>")
    @Select("select * from product where t_id=#{typeId}")
    List<Goods> select(Map<String,Object> condition);

//1.    @Select("select * from tb_goods where id=#{gid}")

// 2   @Results(
//            {
//                    @Result(property = "type.t_id",column = "typeid"),
//                    @Result(property = "type.t_name",column = "tname"),
//            }
//    )
    @Select("select g.*,t.t_name as tname from product as g inner join type as t on g.t_id=t.t_id where g.p_id=#{gid}")

//3.    @Results(
//            {
//                    @Result(property = "goodsType",javaType = GoodsType.class,column = "typeId",
//                            one = @One(select = "com.ljp.dao.GoodsTypeDao.selectById",fetchType = FetchType.LAZY))
//            }
//    )
//    @Select("select * from tb_goods where id=#{gid}")
    Goods selectById(int gid);
}

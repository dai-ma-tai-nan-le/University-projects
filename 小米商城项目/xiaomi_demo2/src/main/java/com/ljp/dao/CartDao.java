package com.ljp.dao;

import com.ljp.entity.Cart;
import com.ljp.entity.CartGoods;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CartDao {

    @Select("select * from cart where u_id=#{uid} and p_id=#{pid}")
    Cart selectByUidAndPid(@Param("uid") int uid,@Param("pid") int pid);

    @Insert("insert into cart values(null,#{uid},#{pid},#{ccount},#{cnum})")
    void insertCart(Cart cart);

    @Update("update cart set c_num=#{cnum},c_count=#{ccount} where u_id=#{uid} and p_id=#{pid}")
    void update(Cart cart);

//    @Select("select c.*,g.p_name,g.p_time,g.p_image,g.p_price,g.p_state,g.p_info,g.t_id " +
//            "from cart as c inner join product as g on c.p_id=g.p_id where c.u_id=#{uid}")
//    @Results({
//            @Result(property = "id",column = "id",id = true),
//            @Result(property = "u_id",column = "uid"),
//            @Result(property = "p_id",column = "pid"),
//            @Result(property = "cnum",column = "num"),
//            @Result(property = "ccount",column = "count"),
//            @Result(property = "product.p_id",column = "pid"),
//            @Result(property = "product.p_name",column = "name"),
//            @Result(property = "product.ptime",column = "pubdate"),
//            @Result(property = "product.pimage",column = "picture"),
//            @Result(property = "product.pprice",column = "price"),
//            @Result(property = "product.pstate",column = "star"),
//            @Result(property = "product.pinfo",column = "intro"),
//            @Result(property = "product.typeid",column = "typeid"),
//    })
    @Select("select c.*,g.p_name,g.p_time,g.p_image,g.p_price,g.p_state,g.p_info,g.t_id " +
            "from cart as c inner join product as g on c.p_id=g.p_id where c.u_id=#{uid}")
        @Results({
            @Result(property = "c_id",column = "id",id = true),
            @Result(property = "u_id",column = "uid"),
            @Result(property = "p_id",column = "pid"),
            @Result(property = "c_num",column = "cnum"),
            @Result(property = "c_count",column = "ccount"),
            @Result(property = "product.p_id",column = "pid"),
            @Result(property = "product.p_name",column = "pname"),
            @Result(property = "product.p_time",column = "ptime"),
            @Result(property = "product.p_image",column = "pimage"),
            @Result(property = "product.p_price",column = "pprice"),
            @Result(property = "product.p_state",column = "pstate"),
            @Result(property = "product.p_info",column = "pinfo"),
            @Result(property = "product.t_id",column = "tid"),
    })
    List<CartGoods> selectByUid(int uid);

    @Delete("delete from cart where u_id=#{uid} and p_id=#{pid}")
    void delete(@Param("uid") int uid, @Param("pid") int pid);

    @Delete("delete from cart where u_id=#{uid}")
    void deleteByUid(int uid);
}

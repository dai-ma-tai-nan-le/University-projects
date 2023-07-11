package com.ljp.dao;

import com.ljp.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface OrderDao {
    @Insert("insert into orders values(#{oid},#{uid},#{aid},#{ocount},#{otime},#{ostate})")
    void add(Order order);

    @Update("update orders set o_state=#{ostate} where o_id=#{oid}")
    void updateStatus(@Param("oid") String oid, @Param("status") String status);
}


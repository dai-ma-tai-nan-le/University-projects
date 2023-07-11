package com.ljp.dao;

import com.ljp.entity.OrderDetail;
import org.apache.ibatis.annotations.Insert;

public interface OrderDetailDao {

    @Insert("insert into item values(null,#{oid},#{pid},#{icount},#{inum})")
    void add(OrderDetail od);
}

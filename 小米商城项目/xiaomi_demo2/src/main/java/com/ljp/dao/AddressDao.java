package com.ljp.dao;

import com.ljp.entity.Address;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author wgy
 * @version v1.0
 * @date 2022/9/27 14:10
 */
public interface AddressDao {
    @Select("select * from address where u_id=#{uid}")
    List<Address> selectByUid(int uid);

    @Insert("insert into address values(null,#{uid},#{aname},#{aphone},#{adetail},#{astate})")
    void insert(Address address);

    @Delete("delete from address where a_id=#{aid}")
    void deleteById(int aid);

    @Update("update address set a_name=#{aname},a_phone=#{aphone},a_detail=#{adetail} where a_id=#{aid}")
    void update(Address address);

    @Update("update address set a_state=0 where u_id=#{uid}")
    void updateAll(int uid);
    @Update("update address set a_state=1 where a_id=#{aid}")
    void updateDefault(int aid);
}

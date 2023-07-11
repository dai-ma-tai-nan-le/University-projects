package com.ljp.demo.service;

import com.ljp.demo.entity.Accomplishment;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 成就(Accomplishment)表服务接口
 *
 * @author makejava
 * @since 2023-04-26 16:53:14
 */
public interface AccomplishmentService {

    //查询该用户有没有这个成就
    List<Accomplishment> selectCj(@Param("username")String username, @Param("name") String name);
    //添加成就
    void insertCj(Accomplishment accomplishment);



    //查询该用户的成就
    List<Accomplishment> selectAllcj(@Param("username")String username);
}

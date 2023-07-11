package com.ljp.demo.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Communication;
import com.ljp.demo.entity.Experience;
import com.ljp.demo.entity.Goal_plan;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;

/**
 * 心得(Experience)表服务接口
 *
 * @author makejava
 * @since 2023-03-28 12:53:28
 */
public interface ExperienceService {

    //添加心得
    void addxd(Experience experience);


    ////查询心得列表
    List<Experience> selectList(@Param("username") String username, @Param("value1") Date value1,@Param("value2") Date value2);
    //修改心得
    void modxd(Experience experience);
    //删除心得
    void delxd(@Param("experienceId")int experienceId);


    //分页查询计划的
    IPage<Experience> findByAllPage(Page<Experience> page, @Param("date") Date date,@Param("date2") Date date2);
    //分页模糊查询用户名计划人数的
    List<Experience> selectList3(Page<Experience> page, @Param("username") String username,@Param("date") Date date,@Param("date2") Date date2);
    //分页模糊查询计划的
    List<Experience> selectList1(Page<Experience> page,  @Param("value1") Date value1,@Param("value2") Date value2);
    //分页模糊查询教师姓名的
    List<Experience> selectList2(Page<Experience> page, @Param("username") String username, @Param("value1") Date value1,@Param("value2") Date value2);
    //查询长度
    Long selectnum2(@Param("username") String username, @Param("value1") Date value1,@Param("value2") Date value2);
    Long selectnum1(@Param("value1") Date value1,@Param("value2") Date value2);
    Long selectnum3(@Param("username") String username,@Param("date") Date date,@Param("date2") Date date2);



    //分享心得
    void fxxd(Communication communication);




    //分页查询计划的
    IPage<Experience> findByAllPage1(Page<Experience> page, @Param("date") Date date,@Param("date2") Date date2, @Param("academy") String academy);
    //分页模糊查询用户名计划人数的
    List<Experience> selectList5(Page<Experience> page, @Param("username") String username,@Param("date") Date date,@Param("date2") Date date2, @Param("academy") String academy);
    //分页模糊查询计划的
    List<Experience> selectList6(Page<Experience> page,  @Param("value1") Date value1,@Param("value2") Date value2, @Param("academy") String academy);
    //分页模糊查询教师姓名的
    List<Experience> selectList4(Page<Experience> page, @Param("username") String username, @Param("value1") Date value1,@Param("value2") Date value2, @Param("academy") String academy);
    //查询长度
    Long selectnum4(@Param("username") String username, @Param("value1") Date value1,@Param("value2") Date value2, @Param("academy") String academy);
    Long selectnum6(@Param("value1") Date value1,@Param("value2") Date value2, @Param("academy") String academy);
    Long selectnum5(@Param("username") String username,@Param("date") Date date,@Param("date2") Date date2, @Param("academy") String academy);



//    查看指定心得
    List<Experience> selectListPname(@Param("username") String username, @Param("value1") Date value1,@Param("value2") Date value2, @Param("planName")String planName);
}

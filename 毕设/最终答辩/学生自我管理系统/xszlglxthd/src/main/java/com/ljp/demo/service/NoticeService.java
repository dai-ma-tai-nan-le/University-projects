package com.ljp.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 通知(Notice)表服务接口
 *
 * @author makejava
 * @since 2023-04-04 16:32:08
 */
public interface NoticeService {

    //重新学生用户名
    List<User> selectUsernamae();
    //查询班级
    List<Student> selectClass();
    //查询专业
    List<Student> selectMajor();
    //查询学院
    List<Student> selectAcademy();


    //发布通知
    void addtz(Notice notice);


    //分页查询计划的
    IPage<Notice> findByAllPage(Page<Notice> page);
    //分页模糊查询用户名计划人数的
    List<Notice> selectList3(Page<Notice> page, @Param("username") String username);
    //分页模糊查询计划的
    List<Notice> selectList1(Page<Notice> page, @Param("type") String type);
    //分页模糊查询教师姓名的
    List<Notice> selectList2(Page<Notice> page, @Param("username") String username, @Param("type") String type);
    //查询长度
    Long selectnum2(@Param("username") String username, @Param("type") String type);
    Long selectnum1(@Param("type") String type);
    Long selectnum3(@Param("username") String username);
    //删除通知
    void deltz(@Param("noticeId")int noticeId);


    //置顶与取消置顶
    void updateLevel(Notice notice);


    ////查询通知列表
//    List<Notice> selectLists(@Param("reusername")String reusername,@Param("username") String username);
    List<Notice> selectLists(@Param("reusername")String reusername);
//    List<Notice> selectList(@Param("reusername")String reusername, @Param("type")String type,@Param("username") String username);
    List<Notice> selectList(@Param("reusername")String reusername, @Param("type")String type);
    //查询xsnotice中为用户名的列表
    List<XsNotice> selectXsList1(@Param("username") String username);
    //查询是否有该id和用户名的人创建置顶
    List<XsNotice> selectXsList(@Param("noticeId")int noticeId,@Param("username") String username);
    //学生确认收到
    void updateXsSd(XsNotice xsnotice);
    void insertXsSd(XsNotice xsnotice);
    //收到人数加1
    List<Notice> selectNoticeid(@Param("noticeId")int noticeId);
    void updateReceived(Notice notice);
}

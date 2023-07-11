package com.ljp.demo.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.*;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 通知(Notice)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-04 16:32:08
 */
@Mapper
public interface NoticeDao {

    //重新学生用户名
    @Select("select username from user where user_group='学生'")
    List<User> selectUsername();
    //查询班级
    @Select("select DISTINCT class_name from student")
    List<Student> selectClass();
    //查询专业
    @Select("select DISTINCT major from student")
    List<Student> selectMajor();
    //查询学院
    @Select("select DISTINCT academy from student")
    List<Student> selectAcademy();



    //发布通知
    @Insert("insert into notice values(null,#{title},#{type},#{username},#{reusername},#{publishTime},#{content},#{level},#{receivedNum},#{createTime},#{updateTime})")
    void addtz(Notice notice);


    ////分页查询教师人数的
//    @Select("select * from notice order by publish_time desc")
    @Select("select * from notice order by level desc,publish_time desc")
    IPage<Notice> findByAllPage(Page<Notice> page);
    ////分页模糊查询教师人数的
    @Select("select * from notice where username like CONCAT('%',#{username},'%')")
    List<Notice> selectList3(Page<Notice> page, @Param("username") String username);
    ////分页模糊查询教师姓名的
    @Select("select * from notice where type like CONCAT('%',#{type},'%')")
    List<Notice> selectList1(Page<Notice> page, @Param("type") String type);
    ////分页模糊查询教师姓名的
    @Select("select * from notice where username like CONCAT('%',#{username},'%') and type like CONCAT('%',#{type},'%')")
    List<Notice> selectList2(Page<Notice> page,@Param("username") String username, @Param("type") String type);
    //查询长度
    @Select("select count(*) from notice where username like CONCAT('%',#{username},'%')")
    Long selectnum3(@Param("username") String username);
    @Select("select count(*) from notice where type like CONCAT('%',#{type},'%')")
    Long selectnum1(@Param("type") String type);
    @Select("select count(*) from notice where u.username like CONCAT('%',#{username},'%') and type like CONCAT('%',#{type},'%')")
    Long selectnum2(@Param("username") String username, @Param("type") String type);
    //删除通知
    @Delete("delete from notice where notice_id=#{noticeId}")
    void deltz(@Param("noticeId")int noticeId);



    //置顶与取消置顶
    @Update("update notice set level=#{level} where notice_id=#{noticeId}")
    void updateLevel(Notice notice);


    ////查询通知列表
    @Select("select * from notice where re_username=#{reusername} order by level desc,publish_time desc")
    List<Notice> selectLists(@Param("reusername")String reusername);
    @Select("select * from notice where re_username=#{reusername} and type=#{type} order by level desc")
    List<Notice> selectList(@Param("reusername")String reusername, @Param("type")String type);
    //查询xsnotice中为用户名的列表
    @Select("select * from xs_notice where username=#{username}")
    List<XsNotice> selectXxsList1(@Param("username") String username);
//    @Select("select * from notice as n,xs_notice as x where re_username=#{reusername} and x.username=#{username} order by level desc")
//    List<Notice> selectLists(@Param("reusername")String reusername,@Param("username") String username);
//    @Select("select * from notice  as n,xs_notice as x where re_username=#{reusername} and x.username=#{username} and type=#{type} order by level desc")
//    List<Notice> selectList(@Param("reusername")String reusername, @Param("type")String type,@Param("username") String username);
    //查询是否有该id和用户名的人创建置顶
    @Select("select * from xs_notice where username=#{username} and notice_id=#{noticeId}")
    List<XsNotice> selectXsList(@Param("noticeId")int noticeId,@Param("username") String username);
    //学生确认收到/置顶/取消置顶
    @Update("update xs_notice set received=#{received},level=#{xslevel} where notice_id=#{noticeId} and username=#{username}")
    void updateXsSd(XsNotice xsnotice);
    @Insert("insert into xs_notice values(null,#{noticeId},#{username},#{xslevel},#{received})")
    void insertXsSd(XsNotice xsnotice);
    //收到人数加1
    @Select("select * from notice where notice_id=#{noticeId}")
    List<Notice> selectNoticeid(@Param("noticeId")int noticeId);
//    @Update("update notice set received_num=#{receivedNum} where notice_id=#{noticeId}")
    @Update("update notice set received_num=#{receivedNum} where notice_id=#{noticeId} and username=#{username}")
    void updateReceived(Notice notice);


}


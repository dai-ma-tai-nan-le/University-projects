package com.ljp.demo.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.*;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 解惑(Communication)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-09 14:33:46
 */
@Mapper
public interface CommunicationDao {

    //查询心得分享列表
    @Select("select * from communication as c,user as u where reusername=#{reusername} and c.username=u.username order by communication_id desc")
    List<Communication> selectList(@Param("reusername")String reusername);
    //查询我发布心得分享列表
    @Select("select * from communication as c,user as u where c.username=#{username} and c.username=u.username order by communication_id desc")
    List<Communication> selectList1(@Param("username")String username);
    //判断是否已经创建该列表该列
    @Select("select * from hits where username=#{username} and id=#{id} and type=#{type}")
    List<Hits> selectHits(@Param("id")int id,@Param("username") String username, @Param("type")String type);
    //点赞\取消点赞
    @Insert("insert into hits values(null,#{id},#{type},#{username},#{likes},#{createTime},#{updateTime})")
    void insertHits(Hits hits1);
    @Update("update hits set likes=#{likes} where username=#{username} and id=#{id} and type=#{type}")
    void updateHits(Hits hits1);
    //找本id点赞的list
    @Select("select * from hits where id=#{id} and likes=1 and type=#{type}")
    List<Hits> selectHits1(@Param("id")int id, @Param("type")String type);
    @Select("select * from hits where id=#{id} and type=#{type}")
    List<Hits> selectHits2(@Param("id")int id, @Param("type")String type);
    //删除分享的心得
    @Delete("delete from communication where communication_id=#{id}")
    void delfxxd(@Param("id")int id);
    //删除点赞
    @Delete("delete from hits where id=#{id} and type=#{type}")
    void delfxxd1(@Param("id")int id, @Param("type")String type);
    @Delete("delete from hits where id=#{id}")
    void delfxxd2(@Param("id")int id);
    //发布评论
    @Insert("insert into comment values(null,#{id},#{type},#{username},#{reusername},#{content},#{createTime},#{updateTime})")
    void insertPl(Comment comment);
    //查询评论
    @Select("select * from comment as c,user as u where id=#{id} and type=#{type} and c.username=u.username")
    List<Comment> selectPl(@Param("id")int id, @Param("type")String type);
    @Select("select * from comment as c,user as u where id=#{id} and type=#{type} and c.username=u.username")
    List<Comment1> selectPl1(@Param("id")int id, @Param("type")String type);
    @Select("select * from comment where comment_id=#{jlid}")
    List<Comment> selectPl2(@Param("jlid")int jlid);
    //删除评论
    @Delete("delete from comment where id=#{id} and type=#{type}")
    void delpl(@Param("id")int id, @Param("type")String type);
    @Delete("delete from comment where comment_id=#{id}")
    void zjdelpl(@Param("id")int id);



    //教师查询交流列表
    @Select("select * from communication where username like CONCAT('%',#{username},'%') and reusername like CONCAT('%',#{reusername},'%')")
    List<Communication> selectList2(Page<Communication> page, String username, String reusername);
    @Select("select * from communication where username like CONCAT('%',#{username},'%')")
    List<Communication> selectList3(Page<Communication> page, String username);
    @Select("select * from communication where reusername like CONCAT('%',#{reusername},'%')")
    List<Communication> selectList4(Page<Communication> page, String reusername);
    @Select("select * from communication order by communication_id desc")
    IPage<Communication> findByAllPage(Page<Communication> page);
    //教师查询长度
    @Select("select count(*) from communication where username like CONCAT('%',#{username},'%') and reusername like CONCAT('%',#{reusername},'%')")
    Long selectnum1(String username, String reusername);
    @Select("select count(*) from communication where username like CONCAT('%',#{username},'%')")
    Long selectnum2(String username);
    @Select("select count(*) from communication where reusername like CONCAT('%',#{reusername},'%')")
    Long selectnum3(String reusername);
    //根据id查询心得交流
    @Select("select * from communication where communication_id=#{communicationId}")
    List<Communication> selectJlList(@Param("communicationId")int communicationId);



    //教师查询交流列表
    @Select("select * from communication as c,student as s where c.username=s.username and academy=#{academy} username like CONCAT('%',#{username},'%') and reusername like CONCAT('%',#{reusername},'%')")
    List<Communication> selectList5(Page<Communication> page, String username, String reusername,@Param("academy")String academy);
    @Select("select * from communication as c,student as s where c.username=s.username and academy=#{academy} username like CONCAT('%',#{username},'%')")
    List<Communication> selectList6(Page<Communication> page, String username,@Param("academy")String academy);
    @Select("select * from communication as c,student as s where c.username=s.username and academy=#{academy} reusername like CONCAT('%',#{reusername},'%')")
    List<Communication> selectList7(Page<Communication> page, String reusername,@Param("academy")String academy);
    @Select("select * from communication as c,student as s where c.username=s.username and academy=#{academy} order by communication_id desc")
    IPage<Communication> findByAllPage1(Page<Communication> page,@Param("academy")String academy);
    //教师查询长度
    @Select("select count(*) from communication as c,student as s where c.username=s.username and academy=#{academy} username like CONCAT('%',#{username},'%') and reusername like CONCAT('%',#{reusername},'%')")
    Long selectnum5(String username, String reusername,@Param("academy")String academy);
    @Select("select count(*) from communication as c,student as s where c.username=s.username and academy=#{academy} username like CONCAT('%',#{username},'%')")
    Long selectnum6(String username,@Param("academy")String academy);
    @Select("select count(*) from communication as c,student as s where c.username=s.username and academy=#{academy} reusername like CONCAT('%',#{reusername},'%')")
    Long selectnum7(String reusername,@Param("academy")String academy);
}


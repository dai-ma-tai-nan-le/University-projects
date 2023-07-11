package com.ljp.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 解惑(Communication)表服务接口
 *
 * @author makejava
 * @since 2023-04-09 14:33:50
 */
public interface CommunicationService {

    //查询心得分享列表
    List<Communication> selectList(@Param("reusername")String reusername);
    //查询我发布心得分享列表
    List<Communication> selectList1(@Param("username")String username);
    //判断是否已经创建该列表该列
    List<Hits> selectHits(@Param("id")int id,@Param("username") String username, @Param("type")String type);
    //点赞\取消点赞
    void insertHits(Hits hits1);
    void updateHits(Hits hits1);
    //找本id点赞的list
    List<Hits> selectHits1(@Param("id")int id, @Param("type")String type);
    List<Hits> selectHits2(@Param("id")int id, @Param("type")String type);
    //删除分享的心得
    void delfxxd(@Param("id")int id);
    //删除点赞
    void delfxxd1(@Param("id")int id, @Param("type")String type);
    void delfxxd2(@Param("id")int id);
    //发布评论
    void insertPl(Comment comment);
    //查询评论
    List<Comment> selectPl(@Param("id")int id, @Param("type")String type);
    List<Comment1> selectPl1(@Param("id")int id, @Param("type")String type);
    List<Comment> selectPl2(@Param("jlid")int jlid);
    //删除评论
    void delpl(@Param("id")int id, @Param("type")String type);
    void zjdelpl(@Param("id")int id);


    //教师查询交流列表
    List<Communication> selectList2(Page<Communication> page,@Param("username")String username,@Param("reusername")String reusername);
    List<Communication> selectList3(Page<Communication> page,@Param("username")String username);
    List<Communication> selectList4(Page<Communication> page,@Param("reusername")String reusername);
    IPage<Communication> findByAllPage(Page<Communication> page);
    //教师查询长度
    Long selectnum1(@Param("username")String username,@Param("reusername")String reusername);
    Long selectnum2(@Param("username")String username);
    Long selectnum3(@Param("reusername")String reusername);
    //根据id查询心得交流
    List<Communication> selectJlList(@Param("communicationId")int communicationId);



    //教师查询交流列表
    List<Communication> selectList5(Page<Communication> page,@Param("username")String username,@Param("reusername")String reusername,@Param("academy")String academy);
    List<Communication> selectList6(Page<Communication> page,@Param("username")String username,@Param("academy")String academy);
    List<Communication> selectList7(Page<Communication> page,@Param("reusername")String reusername,@Param("academy")String academy);
    IPage<Communication> findByAllPage1(Page<Communication> page,@Param("academy")String academy);
    //教师查询长度
    Long selectnum5(@Param("username")String username,@Param("reusername")String reusername,@Param("academy")String academy);
    Long selectnum6(@Param("username")String username,@Param("academy")String academy);
    Long selectnum7(@Param("reusername")String reusername,@Param("academy")String academy);
}

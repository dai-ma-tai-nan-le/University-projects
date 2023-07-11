package com.ljp.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.*;
import com.ljp.demo.dao.CommunicationDao;
import com.ljp.demo.service.CommunicationService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 解惑(Communication)表服务实现类
 *
 * @author makejava
 * @since 2023-04-09 14:33:50
 */
@Service("communicationService")
public class CommunicationServiceImpl implements CommunicationService {
    @Resource
    private CommunicationDao communicationDao;


    //查询心得分享列表
    @Override
    public List<Communication> selectList(@Param("reusername")String reusername) {
        return communicationDao.selectList(reusername);
    }
    //查询我发布心得分享列表
    @Override
    public List<Communication> selectList1(@Param("username")String username) {
        return communicationDao.selectList1(username);
    }
    //判断是否已经创建该列表该列
    @Override
    public List<Hits> selectHits(@Param("id")int id,@Param("username") String username, @Param("type")String type) {
        return communicationDao.selectHits(id,username,type);
    }
    //点赞\取消点赞
    @Override
    public void insertHits(Hits hits1) {
        hits1.setCreateTime(new Date());
        hits1.setUpdateTime(new Date());
        communicationDao.insertHits(hits1);
    }
    @Override
    public void updateHits(Hits hits1) {
        communicationDao.updateHits(hits1);
    }
    //找本id点赞的list
    @Override
    public List<Hits> selectHits1(@Param("id")int id, @Param("type")String type) {
        return communicationDao.selectHits1(id,type);
    }
    @Override
    public List<Hits> selectHits2(@Param("id")int id, @Param("type")String type) {
        return communicationDao.selectHits2(id,type);
    }
    //删除分享的心得
    @Override
    public void delfxxd(@Param("id")int id) {
        communicationDao.delfxxd(id);
    }
    //删除点赞
    @Override
    public void delfxxd1(@Param("id")int id, @Param("type")String type) {
        communicationDao.delfxxd1(id,type);
    }
    @Override
    public void delfxxd2(@Param("id")int id) {
        communicationDao.delfxxd2(id);
    }
    //发布评论
    @Override
    public void insertPl(Comment comment) {
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());
        communicationDao.insertPl(comment);
    }
    //查询评论
    @Override
    public List<Comment> selectPl(@Param("id")int id, @Param("type")String type) {
        return communicationDao.selectPl(id,type);
    }
    @Override
    public List<Comment1> selectPl1(@Param("id")int id, @Param("type")String type) {
        return communicationDao.selectPl1(id,type);
    }
    @Override
    public List<Comment> selectPl2(@Param("jlid")int jlid) {
        return communicationDao.selectPl2(jlid);
    }
    //删除评论
    @Override
    public void delpl(@Param("id")int id, @Param("type")String type) {
        communicationDao.delpl(id,type);
    }
    @Override
    public void zjdelpl(@Param("id")int id) {
        communicationDao.zjdelpl(id);
    }



    //教师查询交流列表
    @Override
    public List<Communication> selectList2(Page<Communication> page,@Param("username") String username, @Param("reusername")String reusername) {
        return communicationDao.selectList2(page,username,reusername);
    }
    @Override
    public List<Communication> selectList3(Page<Communication> page, @Param("username")String username) {
        return communicationDao.selectList3(page,username);
    }
    @Override
    public List<Communication> selectList4(Page<Communication> page, @Param("reusername")String reusername) {
        return communicationDao.selectList4(page,reusername);
    }
    @Override
    public IPage<Communication> findByAllPage(Page<Communication> page) {
        return communicationDao.findByAllPage(page);
    }
    //教师查询长度
    @Override
    public Long selectnum1(@Param("username")String username, @Param("reusername")String reusername) {
        return communicationDao.selectnum1(username,reusername);
    }
    @Override
    public Long selectnum2(@Param("username")String username) {
        return communicationDao.selectnum2(username);
    }
    @Override
    public Long selectnum3(@Param("reusername")String reusername) {
        return communicationDao.selectnum3(reusername);
    }
    //根据id查询心得交流
    @Override
    public List<Communication> selectJlList(@Param("communicationId")int communicationId) {
        return communicationDao.selectJlList(communicationId);
    }



    //教师查询交流列表
    @Override
    public List<Communication> selectList5(Page<Communication> page,@Param("username") String username, @Param("reusername")String reusername,@Param("academy")String academy) {
        return communicationDao.selectList5(page,username,reusername,academy);
    }
    @Override
    public List<Communication> selectList6(Page<Communication> page, @Param("username")String username,@Param("academy")String academy) {
        return communicationDao.selectList6(page,username,academy);
    }
    @Override
    public List<Communication> selectList7(Page<Communication> page, @Param("reusername")String reusername,@Param("academy")String academy) {
        return communicationDao.selectList7(page,reusername,academy);
    }
    @Override
    public IPage<Communication> findByAllPage1(Page<Communication> page,@Param("academy")String academy) {
        return communicationDao.findByAllPage1(page,academy);
    }
    //教师查询长度
    @Override
    public Long selectnum5(@Param("username")String username, @Param("reusername")String reusername,@Param("academy")String academy) {
        return communicationDao.selectnum5(username,reusername,academy);
    }
    @Override
    public Long selectnum6(@Param("username")String username,@Param("academy")String academy) {
        return communicationDao.selectnum6(username,academy);
    }
    @Override
    public Long selectnum7(@Param("reusername")String reusername,@Param("academy")String academy) {
        return communicationDao.selectnum7(reusername,academy);
    }
}

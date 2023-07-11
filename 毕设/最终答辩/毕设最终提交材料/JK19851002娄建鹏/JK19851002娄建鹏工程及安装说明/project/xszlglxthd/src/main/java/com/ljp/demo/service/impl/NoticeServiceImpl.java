package com.ljp.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.dao.NoticeDao;
import com.ljp.demo.entity.*;
import com.ljp.demo.service.NoticeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 通知(Notice)表服务实现类
 *
 * @author makejava
 * @since 2023-04-04 16:32:08
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeDao noticeDao;

    //重新学生用户名
    @Override
    public List<User> selectUsernamae() {
        return noticeDao.selectUsername();
    }
    //查询班级
    @Override
    public List<Student> selectClass() {
        return noticeDao.selectClass();
    }
    //查询专业
    @Override
    public List<Student> selectMajor() {
        return noticeDao.selectMajor();
    }
    //查询学院
    @Override
    public List<Student> selectAcademy() {
        return noticeDao.selectAcademy();
    }


    //发布通知
    @Override
    public void addtz(Notice notice) {
        notice.setCreateTime(new Date());
        notice.setUpdateTime(new Date());
        noticeDao.addtz(notice);
    }


    //分页查询教师人数的
    @Override
    public IPage<Notice> findByAllPage(Page<Notice> page) {
        return noticeDao.findByAllPage(page);
    }
    ////分页模糊查询教师人数的
    @Override
    public List<Notice> selectList3(Page<Notice> page, @Param("username") String username) {
        return noticeDao.selectList3(page,username);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Notice> selectList1(Page<Notice> page, @Param("type") String type) {
        return noticeDao.selectList1(page,type);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Notice> selectList2(Page<Notice> page, @Param("username") String username, @Param("type") String type) {
        return noticeDao.selectList2(page,username,type);
    }
    //查询长度
    @Override
    public Long selectnum1(@Param("type") String type) {
        return noticeDao.selectnum1(type);
    }
    @Override
    public Long selectnum2(@Param("username") String username, @Param("type") String type) {
        return noticeDao.selectnum2(username,type);
    }
    @Override
    public Long selectnum3(@Param("username") String username) {
        return noticeDao.selectnum3(username);
    }
    //删除通知
    @Override
    public void deltz(@Param("noticeId")int noticeId) {
        noticeDao.deltz(noticeId);
    }



    //置顶与取消置顶
    @Override
    public void updateLevel(Notice notice) {
        noticeDao.updateLevel(notice);
    }


    ////查询通知列表
    @Override
    public List<Notice> selectLists(@Param("reusername")String reusername) {
        return noticeDao.selectLists(reusername);
    }
    @Override
    public List<Notice> selectList(@Param("reusername")String reusername, @Param("type")String type) {
        return noticeDao.selectList(reusername,type);
    }
    //查询xsnotice中为用户名的列表
    @Override
    public List<XsNotice> selectXsList1(@Param("username") String username) {
        return noticeDao.selectXxsList1(username);
    }
    //    @Override
//    public List<Notice> selectLists(@Param("reusername")String reusername,@Param("username") String username) {
//        return noticeDao.selectLists(reusername,username);
//    }
//    @Override
//    public List<Notice> selectList(@Param("reusername")String reusername, @Param("type")String type,@Param("username") String username) {
//        return noticeDao.selectList(reusername,type,username);
//    }
    //查询是否有该id和用户名的人创建置顶
    @Override
    public List<XsNotice> selectXsList(@Param("noticeId")int noticeId,@Param("username") String username) {
        return noticeDao.selectXsList(noticeId,username);
    }
    //学生确认收到
    @Override
    public void updateXsSd(XsNotice xsnotice) {
        noticeDao.updateXsSd(xsnotice);
    }
    @Override
    public void insertXsSd(XsNotice xsnotice) {
        noticeDao.insertXsSd(xsnotice);
    }
    //收到人数加1
    @Override
    public List<Notice> selectNoticeid(@Param("noticeId")int noticeId) {
        return noticeDao.selectNoticeid(noticeId);
    }
    @Override
    public void updateReceived(Notice notice) {
        noticeDao.updateReceived(notice);
    }
}

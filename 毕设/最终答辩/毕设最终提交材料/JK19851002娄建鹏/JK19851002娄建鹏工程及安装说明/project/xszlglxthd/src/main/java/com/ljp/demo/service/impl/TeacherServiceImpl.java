package com.ljp.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Teacher;
import com.ljp.demo.dao.TeacherDao;
import com.ljp.demo.entity.User;
import com.ljp.demo.service.TeacherService;
import com.ljp.demo.utils.Md5Utils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 教师(Teacher)表服务实现类
 *
 * @author makejava
 * @since 2023-03-16 20:20:29
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherDao teacherDao;

    //分页查询教师人数的
    @Override
    public IPage<Teacher> findByAllPage(Page<Teacher> page) {
        return teacherDao.findByAllPage(page);
    }
    ////分页模糊查询教师人数的
    @Override
    public List<Teacher> selectList(Page<Teacher> page, @Param("username") String username) {
        return teacherDao.selectList(page,username);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Teacher> selectList1(Page<Teacher> page, @Param("teaname") String teaname) {
        return teacherDao.selectList1(page,teaname);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Teacher> selectList2(Page<Teacher> page,@Param("username") String username,@Param("teaname") String teaname) {
        return teacherDao.selectList2(page,username,teaname);
    }
    ///查重名教师
    @Override
    public List<User> findUserByUsername(@Param("username") String username) {
        return teacherDao.findUserByUsername(username);
    }

    //添加教师
    @Override
    public void adduname(User user) {
        // 密码加密Salt
        user.setPassword(Md5Utils.md5(user.getPassword()));
        teacherDao.adduname(user);
    }
    public void addtea(Teacher teacher) {
        teacher.setCreateTime(new Date());
        teacher.setUpdateTime(new Date());
        teacherDao.addtea(teacher);
    }
    //删除教师
    @Override
    public void deltea(@Param("username") String username) {
        teacherDao.deltea(username);
    }
    public void deltea1(@Param("username") String username) {
        teacherDao.deltea1(username);
    }
    //查询教师人数的
    @Override
    public List<Teacher> selectteaList(@Param("username") String username) {
        return teacherDao.selectteaList(username);
    }
    //修改教师
    @Override
    public void modtea(User user) {
        teacherDao.modtea(user);
    }
    @Override
    public void modtea1(Teacher teacher) {
        teacherDao.modtea1(teacher);
    }

    ///查重名教师id
    @Override
    public List<Teacher> findUserTeanumber(@Param("teanumber") int teanumber) {
        return teacherDao.findUserTeanumber(teanumber);
    }



    //教师查询长度
    @Override
    public Long selectnum1(@Param("username") String username,@Param("teaname") String teaname) {
        return teacherDao.selectnum1(username,teaname);
    }
    @Override
    public Long selectnum2(@Param("username") String username) {
        return teacherDao.selectnum2(username);
    }
    @Override
    public Long selectnum3(@Param("teaname") String teaname) {
        return teacherDao.selectnum3(teaname);
    }
}

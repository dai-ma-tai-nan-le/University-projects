package com.ljp.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Student;
import com.ljp.demo.dao.StudentDao;
import com.ljp.demo.entity.Teacher;
import com.ljp.demo.entity.User;
import com.ljp.demo.service.StudentService;
import com.ljp.demo.utils.Md5Utils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 学生(Student)表服务实现类
 *
 * @author makejava
 * @since 2023-03-17 22:11:20
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    //分页查询学生人数的
    @Override
    public IPage<Student> findByAllPage(Page<Student> page) {
        return studentDao.findByAllPage(page);
    }
    ////分页模糊查询学生人数的
    @Override
    public List<Student> selectList(Page<Student> page, @Param("username") String username) {
        return studentDao.selectList(page,username);
    }
    ////分页模糊查询学生姓名的
    @Override
    public List<Student> selectList1(Page<Student> page, @Param("stuname") String stuname) {
        return studentDao.selectList1(page,stuname);
    }
    ////分页模糊查询学生姓名的
    @Override
    public List<Student> selectList2(Page<Student> page, @Param("username") String username, @Param("stuname") String stuname) {
        return studentDao.selectList2(page,username,stuname);
    }
    ///查重名学生
    @Override
    public List<User> findUserByUsername(@Param("username") String username) {
        return studentDao.findUserByUsername(username);
    }
    ///查重名学生id
    @Override
    public List<Student> findUserStunumber(@Param("stunumber") int stunumber) {
        return studentDao.findUserStunumber(stunumber);
    }

    //添加学生
    @Override
    public void adduname(User user) {
        // 密码加密Salt
        user.setPassword(Md5Utils.md5(user.getPassword()));
        studentDao.adduname(user);
    }
    public void addstu(Student student) {
        student.setCreateTime(new Date());
        student.setUpdateTime(new Date());
        studentDao.addstu(student);
    }
    public List<Teacher> findUserTeanumber2(@Param("academy") String academy) {
        return studentDao.findUserTeanumber2(academy);
    }
    //删除学生
    @Override
    public void delstu(@Param("username") String username) {
        studentDao.delstu(username);
    }
    public void delstu1(@Param("username") String username) {
        studentDao.delstu1(username);
    }
    //查询学生人数的
    @Override
    public List<Student> selectstuList(@Param("username") String username) {
        return studentDao.selectstuList(username);
    }
    //修改学生
    @Override
    public void modstu(User user) {
        studentDao.modstu(user);
    }
    @Override
    public void modstu1(Student student) {
        studentDao.modstu1(student);
    }
    //查教师id学院与学生学院是否一样
    @Override
    public List<Student> findUserTeanumber(@Param("username") String username) {
        return studentDao.findUserTeanumber(username);
    }
    public List<Teacher> findUserTeanumber1(@Param("teaNumber") int teaNumber) {
        return studentDao.findUserTeanumber1(teaNumber);
    }


    //教师查询长度
    @Override
    public Long selectnum1(@Param("username") String username, @Param("stuname") String stuname) {
        return studentDao.selectnum1(username,stuname);
    }
    @Override
    public Long selectnum2(@Param("username") String username) {
        return studentDao.selectnum2(username);
    }
    @Override
    public Long selectnum3(@Param("stuname") String stuname) {
        return studentDao.selectnum3(stuname);
    }



    //分页查询学生人数的
    @Override
    public IPage<Student> findByAllPage1(Page<Student> page,@Param("academy") String academy) {
        return studentDao.findByAllPage1(page,academy);
    }
    ////分页模糊查询学生人数的
    @Override
    public List<Student> selectList4(Page<Student> page, @Param("username") String username,@Param("academy") String academy) {
        return studentDao.selectList4(page,username,academy);
    }
    ////分页模糊查询学生姓名的
    @Override
    public List<Student> selectList5(Page<Student> page, @Param("stuname") String stuname,@Param("academy") String academy) {
        return studentDao.selectList5(page,stuname,academy);
    }
    ////分页模糊查询学生姓名的
    @Override
    public List<Student> selectList3(Page<Student> page, @Param("username") String username, @Param("stuname") String stuname,@Param("academy") String academy) {
        return studentDao.selectList3(page,username,stuname,academy);
    }
    //教师查询长度
    @Override
    public Long selectnum4(@Param("username") String username, @Param("stuname") String stuname,@Param("academy") String academy) {
        return studentDao.selectnum4(username,stuname,academy);
    }
    @Override
    public Long selectnum5(@Param("username") String username,@Param("academy") String academy) {
        return studentDao.selectnum5(username,academy);
    }
    @Override
    public Long selectnum6(@Param("stuname") String stuname,@Param("academy") String academy) {
        return studentDao.selectnum6(stuname,academy);
    }

}

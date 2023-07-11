package com.ljp.demo.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.dao.ExperienceDao;
import com.ljp.demo.entity.Communication;
import com.ljp.demo.entity.Experience;
import com.ljp.demo.entity.Goal_plan;
import com.ljp.demo.entity.Study_plan;
import com.ljp.demo.service.ExperienceService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 心得(Experience)表服务实现类
 *
 * @author makejava
 * @since 2023-03-28 12:53:28
 */
@Service("experienceService")
public class ExperienceServiceImpl implements ExperienceService {
    @Resource
    private ExperienceDao experienceDao;

    //添加心得
    @Override
    public void addxd(Experience experience) {
        experience.setUpdateTime(new Date());
        experience.setCreateTime(new Date());
        experienceDao.addxd(experience);
    }


    ////查询心得列表
    @Override
    public List<Experience> selectList(@Param("username") String username, @Param("value1") Date value1,@Param("value2") Date value2) {
        return experienceDao.selectList(username,value1,value2);
    }
    //修改心得
    @Override
    public void modxd(Experience experience) {
        experienceDao.modxd(experience);
    }
    //删除心得
    @Override
    public void delxd(@Param("experienceId")int experienceId) {
        experienceDao.delxd(experienceId);
    }


    //分页查询教师人数的
    @Override
    public IPage<Experience> findByAllPage(Page<Experience> page,@Param("date") Date date,@Param("date2") Date date2) {
        return experienceDao.findByAllPage(page,date,date2);
    }
    ////分页模糊查询教师人数的
    @Override
    public List<Experience> selectList3(Page<Experience> page, @Param("username") String username,@Param("date") Date date,@Param("date2") Date date2) {
        return experienceDao.selectList3(page,username,date,date2);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Experience> selectList1(Page<Experience> page, @Param("value1") Date value1,@Param("value2") Date value2) {
        return experienceDao.selectList1(page,value1,value2);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Experience> selectList2(Page<Experience> page, @Param("username") String username,  @Param("value1") Date value1,@Param("value2") Date value2) {
        return experienceDao.selectList2(page,username,value1,value2);
    }
    //查询长度
    @Override
    public Long selectnum1( @Param("value1") Date value1,@Param("value2") Date value2) {
        return experienceDao.selectnum1(value1,value2);
    }
    @Override
    public Long selectnum2(@Param("username") String username, @Param("value1") Date value1,@Param("value2") Date value2) {
        return experienceDao.selectnum2(username,value1,value2);
    }
    @Override
    public Long selectnum3(@Param("username") String username,@Param("date") Date date,@Param("date2") Date date2) {
        return experienceDao.selectnum3(username,date,date2);
    }



    //分享心得
    @Override
    public void fxxd(Communication communication) {
        communication.setUpdateTime(new Date());
        communication.setCreateTime(new Date());
        experienceDao.fxxd(communication);
    }




    //分页查询教师人数的
    @Override
    public IPage<Experience> findByAllPage1(Page<Experience> page,@Param("date") Date date,@Param("date2") Date date2, @Param("academy") String academy) {
        return experienceDao.findByAllPage1(page,date,date2,academy);
    }
    ////分页模糊查询教师人数的
    @Override
    public List<Experience> selectList5(Page<Experience> page, @Param("username") String username,@Param("date") Date date,@Param("date2") Date date2, @Param("academy") String academy) {
        return experienceDao.selectList5(page,username,date,date2,academy);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Experience> selectList6(Page<Experience> page, @Param("value1") Date value1,@Param("value2") Date value2, @Param("academy") String academy) {
        return experienceDao.selectList6(page,value1,value2,academy);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Experience> selectList4(Page<Experience> page, @Param("username") String username,  @Param("value1") Date value1,@Param("value2") Date value2, @Param("academy") String academy) {
        return experienceDao.selectList4(page,username,value1,value2,academy);
    }
    //查询长度
    @Override
    public Long selectnum6( @Param("value1") Date value1,@Param("value2") Date value2, @Param("academy") String academy) {
        return experienceDao.selectnum6(value1,value2,academy);
    }
    @Override
    public Long selectnum4(@Param("username") String username, @Param("value1") Date value1,@Param("value2") Date value2, @Param("academy") String academy) {
        return experienceDao.selectnum4(username,value1,value2,academy);
    }
    @Override
    public Long selectnum5(@Param("username") String username,@Param("date") Date date,@Param("date2") Date date2, @Param("academy") String academy) {
        return experienceDao.selectnum5(username,date,date2,academy);
    }



    //    查看指定心得
    @Override
    public List<Experience> selectListPname(@Param("username") String username, @Param("value1") Date value1,@Param("value2") Date value2, @Param("planName")String planName) {
        return experienceDao.selectListPname(username,value1,value2,planName);
    }
}

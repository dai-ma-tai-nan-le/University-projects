package com.ljp.demo.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.dao.StudyPlanDao;
import com.ljp.demo.entity.Study_plan;
import com.ljp.demo.entity.Teacher;
import com.ljp.demo.entity.Time;
import com.ljp.demo.entity.Upload;
import com.ljp.demo.service.StudyPlanService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 学习计划(StudyPlan)表服务实现类
 *
 * @author makejava
 * @since 2023-03-23 15:25:21
 */
@Service("studyPlanService")
public class StudyPlanServiceImpl implements StudyPlanService {
    @Resource
    private StudyPlanDao studyPlanDao;

    //查询学习计划列表
    @Override
    public List<Study_plan> selectList(@Param("username") String username) {
        return studyPlanDao.selectList(username);
    }
    //修改计划
    @Override
    public void modplan(Study_plan study_plan) {
        studyPlanDao.modplan(study_plan);
    }
    //添加计划
    @Override
    public void addplan(Study_plan study_plan) {
        study_plan.setCreateTime(new Date());
        study_plan.setUpdateTime(new Date());
        studyPlanDao.addplan(study_plan);
    }
    @Override
    //查重名
    public List<Study_plan> selectplanlist(@Param("planName") String planName,@Param("username") String username) {
        return studyPlanDao.selectplanlist(planName,username);
    }
    //删除计划
    @Override
    public void delplan(@Param("studyPlanId")int studyPlanId) {
        studyPlanDao.delplan(studyPlanId);
    }


    //分页查询教师人数的
    @Override
    public IPage<Study_plan> findByAllPage(Page<Study_plan> page) {
        return studyPlanDao.findByAllPage(page);
    }
    ////分页模糊查询教师人数的
    @Override
    public List<Study_plan> selectList3(Page<Study_plan> page, @Param("username") String username) {
        return studyPlanDao.selectList3(page,username);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Study_plan> selectList1(Page<Study_plan> page, @Param("planName") String planName) {
        return studyPlanDao.selectList1(page,planName);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Study_plan> selectList2(Page<Study_plan> page,@Param("username") String username,@Param("planName") String planName) {
        return studyPlanDao.selectList2(page,username,planName);
    }
    //查询长度
    @Override
    public Long selectnum1(@Param("planName") String planName) {
        return studyPlanDao.selectnum1(planName);
    }
    @Override
    public Long selectnum2(@Param("username") String username, @Param("planName") String planName) {
        return studyPlanDao.selectnum2(username,planName);
    }
    @Override
    public Long selectnum3(@Param("username") String username) {
        return studyPlanDao.selectnum3(username);
    }


    //查询学习计划和未来目标
    @Override
    public List<Time> selectTime(@Param("studyPlanId")int studyPlanId) {
        return studyPlanDao.selectTime(studyPlanId);
    }
    //查询计划
    @Override
    public List<Study_plan> queryplan(@Param("studyPlanId")int studyPlanId) {
        return studyPlanDao.queryplan(studyPlanId);
    }
    //更新时长等等
    @Override
    public void updateplan(Study_plan study_plans) {
        studyPlanDao.updateplan(study_plans);
    }




    //分页查询教师人数的
    @Override
    public IPage<Study_plan> findByAllPage1(Page<Study_plan> page, @Param("academy") String academy) {
        return studyPlanDao.findByAllPage1(page,academy);
    }
    ////分页模糊查询教师人数的
    @Override
    public List<Study_plan> selectList5(Page<Study_plan> page, @Param("username") String username, @Param("academy") String academy) {
        return studyPlanDao.selectList5(page,username,academy);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Study_plan> selectList6(Page<Study_plan> page, @Param("planName") String planName, @Param("academy") String academy) {
        return studyPlanDao.selectList6(page,planName,academy);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Study_plan> selectList4(Page<Study_plan> page,@Param("username") String username,@Param("planName") String planName, @Param("academy") String academy) {
        return studyPlanDao.selectList4(page,username,planName,academy);
    }
    //查询长度
    @Override
    public Long selectnum6(@Param("planName") String planName, @Param("academy") String academy) {
        return studyPlanDao.selectnum6(planName,academy);
    }
    @Override
    public Long selectnum4(@Param("username") String username, @Param("planName") String planName, @Param("academy") String academy) {
        return studyPlanDao.selectnum4(username,planName,academy);
    }
    @Override
    public Long selectnum5(@Param("username") String username, @Param("academy") String academy) {
        return studyPlanDao.selectnum5(username,academy);
    }








    //查询音乐
    @Override
    public List<Upload> selectMusic(@Param("username")String username) {
        return studyPlanDao.selectMusic(username);
    }
}

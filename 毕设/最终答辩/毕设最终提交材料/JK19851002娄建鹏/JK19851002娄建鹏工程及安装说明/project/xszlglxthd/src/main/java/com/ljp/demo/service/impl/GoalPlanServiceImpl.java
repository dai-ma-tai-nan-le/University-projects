package com.ljp.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.dao.GoalPlanDao;
import com.ljp.demo.entity.Goal_plan;
import com.ljp.demo.entity.Study_plan;
import com.ljp.demo.service.GoalPlanService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 目标计划(GoalPlan)表服务实现类
 *
 * @author makejava
 * @since 2023-03-24 19:47:54
 */
@Service("goalPlanService")
public class GoalPlanServiceImpl implements GoalPlanService {
    @Resource
    private GoalPlanDao goalPlanDao;

    ////查询未来目标列表
    @Override
    public List<Goal_plan> selectList(@Param("username")String username) {
        return goalPlanDao.selectList(username);
    }
    //修改计划
    @Override
    public void modplan(Goal_plan study_plan) {
        goalPlanDao.modplan(study_plan);
    }
    //添加计划
    @Override
    public void addplan(Goal_plan study_plan) {
        study_plan.setCreateTime(new Date());
        study_plan.setUpdateTime(new Date());
        goalPlanDao.addplan(study_plan);
    }
    @Override
    //查重名
    public List<Goal_plan> selectplanlist(@Param("goalname") String goalname,@Param("username") String username) {
        return goalPlanDao.selectplanlist(goalname,username);
    }
    //删除计划
    @Override
    public void delplan(@Param("goalPlanId")int goalPlanId) {
        goalPlanDao.delplan(goalPlanId);
    }


    //分页查询教师人数的
    @Override
    public IPage<Goal_plan> findByAllPage(Page<Goal_plan> page) {
        return goalPlanDao.findByAllPage(page);
    }
    ////分页模糊查询教师人数的
    @Override
    public List<Goal_plan> selectList3(Page<Goal_plan> page, @Param("username") String username) {
        return goalPlanDao.selectList3(page,username);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Goal_plan> selectList1(Page<Goal_plan> page, @Param("goalName") String goalName) {
        return goalPlanDao.selectList1(page,goalName);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Goal_plan> selectList2(Page<Goal_plan> page, @Param("username") String username, @Param("goalName") String goalName) {
        return goalPlanDao.selectList2(page,username,goalName);
    }
    //查询长度
    @Override
    public Long selectnum1(@Param("goalName") String goalName) {
        return goalPlanDao.selectnum1(goalName);
    }
    @Override
    public Long selectnum2(@Param("username") String username, @Param("goalName") String goalName) {
        return goalPlanDao.selectnum2(username,goalName);
    }
    @Override
    public Long selectnum3(@Param("username") String username) {
        return goalPlanDao.selectnum3(username);
    }




    //分页查询教师人数的
    @Override
    public IPage<Goal_plan> findByAllPage1(Page<Goal_plan> page, @Param("academy") String academy) {
        return goalPlanDao.findByAllPage1(page,academy);
    }
    ////分页模糊查询教师人数的
    @Override
    public List<Goal_plan> selectList5(Page<Goal_plan> page, @Param("username") String username, @Param("academy") String academy) {
        return goalPlanDao.selectList5(page,username,academy);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Goal_plan> selectList6(Page<Goal_plan> page, @Param("goalName") String goalName, @Param("academy") String academy) {
        return goalPlanDao.selectList6(page,goalName,academy);
    }
    ////分页模糊查询教师姓名的
    @Override
    public List<Goal_plan> selectList4(Page<Goal_plan> page, @Param("username") String username, @Param("goalName") String goalName, @Param("academy") String academy) {
        return goalPlanDao.selectList4(page,username,goalName,academy);
    }
    //查询长度
    @Override
    public Long selectnum6(@Param("goalName") String goalName, @Param("academy") String academy) {
        return goalPlanDao.selectnum6(goalName,academy);
    }
    @Override
    public Long selectnum4(@Param("username") String username, @Param("goalName") String goalName, @Param("academy") String academy) {
        return goalPlanDao.selectnum4(username,goalName,academy);
    }
    @Override
    public Long selectnum5(@Param("username") String username, @Param("academy") String academy) {
        return goalPlanDao.selectnum5(username,academy);
    }


}

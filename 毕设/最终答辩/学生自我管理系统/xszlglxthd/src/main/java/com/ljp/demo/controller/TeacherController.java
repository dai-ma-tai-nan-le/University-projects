package com.ljp.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Teacher;
import com.ljp.demo.entity.User;
import com.ljp.demo.service.TeacherService;
import com.ljp.demo.utils.QueryPageParam;
import com.ljp.demo.utils.Result;
import com.ljp.demo.utils.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 教师(Teacher)表控制层
 *
 * @author makejava
 * @since 2023-03-16 20:20:29
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    /**
     * 服务对象
     */
    @Resource
    private TeacherService teacherService;

    /**
     * 分页查询所有教师
     */
    @PostMapping("/tealist")
    public Result<List<Teacher>> tealist(@RequestBody QueryPageParam query){
//        System.out.println(query+"vdkolpasj");
        HashMap param = query.getParam();
        String username = (String)param.get("username");
        String teaname = (String)param.get("tea_name");
        Page<Teacher> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(teaname)){
            List<Teacher> list=teacherService.selectList2(page,username,teaname);
            Long total=teacherService.selectnum1(username,teaname);
            return Result.suc(list,total);
        }else if(!StringUtils.isEmpty(username)){
            List<Teacher> list=teacherService.selectList(page,username);
            Long total=teacherService.selectnum2(username);
            return Result.suc(list, total);
        }
        else if (!StringUtils.isEmpty(teaname)){
            List<Teacher> list=teacherService.selectList1(page,teaname);
            Long total=teacherService.selectnum3(teaname);
            return Result.suc(list, total);
        }
        else{
            IPage<Teacher> result = teacherService.findByAllPage(page);
//            System.out.println(result.getRecords());
            return Result.suc(result.getRecords(),result.getTotal());
        }
    }

    /**
     * 查重名教师
     */
    @GetMapping("/findByUsername")
    public Result findUserByUsername(@RequestParam Map<String, String> data){
        String username = data.get("username");
        List<User> list=teacherService.findUserByUsername(username);
        if (list.size()>0){
            return Result.fail();
        }else {
            return Result.suc();
        }
    }
    /**
     * 查重名教师id
     */
    @GetMapping("/findByteanumber")
    public Result findByteanumber(@RequestParam Map<String, String> data){
        int teanumber = Integer.parseInt(data.get("tea_number"));
        List<Teacher> list=teacherService.findUserTeanumber(teanumber);
        System.out.println(list);
        if (list.size()>0){
            return Result.fail();
        }else {
            return Result.suc();
        }
    }

    /**
     * 添加教师
     */
    @PostMapping("/addtea")
    public Result addtea(@RequestBody Map<String, String> data)  {
        //接收参数
        String username = data.get("username");
        String password = data.get("password");
        String userGroup = data.get("userGroup");
        String gender = data.get("gender");
        String teaName = data.get("tea_name");
        int teaNumber = Integer.parseInt(data.get("tea_number"));
        String courses = data.get("courses");
        String faculties = data.get("faculties");
        String status="可用";
        String examineState="通过";
        try{
            User user=new User(0,userGroup,username,password,status);
            Teacher teacher=new Teacher(0,teaNumber,teaName,gender,courses,faculties,examineState,username);
            teacherService.adduname(user);
            teacherService.addtea(teacher);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }

    /**
     * 删除教师
     */
    @PostMapping("/deltea")
    public Result deltea(@RequestBody String data){
        String username;
        //将数据字符串转换为JSON对象
        JSONObject jsonObject = (JSONObject) JSONObject.parse(data);
        //将selectedRows对应的值转换为JSON数组
        JSONArray jsonArray = (JSONArray) jsonObject.get("selectedRows");
        try{
            for (int i=0;i<jsonArray.size();i++){
                //将每个元素转换为JSON对象
                JSONObject row = (JSONObject) jsonArray.get(i);
                username = (String) row.get("username");
//                System.out.println(username);
                teacherService.deltea(username);
                teacherService.deltea1(username);
            }
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }

    /**
     * 查询教师
     */
    @PostMapping("/selectmessage")
    public Result selectmessage(@RequestBody Map<String, String> data){
        String username = data.get("username");
        try{
            List<Teacher> list= teacherService.selectteaList(username);
            return Result.suc(list);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }

    /**
     * 修改教师
     */
    @PostMapping("/modtea")
    public Result modtea(@RequestBody Map<String, String> data)  {
        //接收参数
        String username = data.get("username");
        String status = data.get("status");
        String userGroup = data.get("user_group");
        String email = data.get("email");
        String phone = data.get("phone");
        String courses = data.get("courses");
        String examineState = data.get("examineState");
        String faculties = data.get("faculties");
        String gender = data.get("gender");
        int teaNumber = Integer.parseInt(data.get("teaNumber"));
        String teaName = data.get("teaName");
        try{
            User user=new User(0,userGroup,phone,username,status,email);
            teacherService.modtea(user);
            Teacher teacher=new Teacher(0,teaNumber,teaName,gender,courses,faculties,examineState,username);
            teacherService.modtea1(teacher);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }

}


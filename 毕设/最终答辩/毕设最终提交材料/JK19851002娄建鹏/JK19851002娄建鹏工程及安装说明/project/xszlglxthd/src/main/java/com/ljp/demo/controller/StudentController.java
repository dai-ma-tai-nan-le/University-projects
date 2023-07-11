package com.ljp.demo.controller;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Student;
import com.ljp.demo.entity.Teacher;
import com.ljp.demo.entity.User;
import com.ljp.demo.service.StudentService;
import com.ljp.demo.utils.QueryPageParam;
import com.ljp.demo.utils.Result;
import com.ljp.demo.utils.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学生(Student)表控制层
 *
 * @author makejava
 * @since 2023-03-17 22:11:20
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 分页查询所有学生
     */
    @PostMapping("/stulist")
    public Result<List<Student>> stulist(@RequestBody QueryPageParam query){
        HashMap param = query.getParam();
        String username = (String)param.get("username");
        String stuname = (String)param.get("stu_name");
        String userGroup = (String)param.get("userGroup");
        String academy = (String)param.get("academy");
        Page<Student> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        System.out.println(userGroup);
        if (userGroup.equals("教师")){
            if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(stuname)){
                List<Student> list=studentService.selectList3(page,username,stuname,academy);
                Long total=studentService.selectnum4(username,stuname,academy);
                return Result.suc(list, total);
            }else if(!StringUtils.isEmpty(username)){
                List<Student> list=studentService.selectList4(page,username,academy);
                Long total=studentService.selectnum5(username,academy);
                return Result.suc(list, total);
            }
            else if (!StringUtils.isEmpty(stuname)){
                List<Student> list=studentService.selectList5(page,stuname,academy);
                Long total=studentService.selectnum6(stuname,academy);
                return Result.suc(list, total);
            }
            else{
                IPage<Student> result = studentService.findByAllPage1(page,academy);
                return Result.suc(result.getRecords(),result.getTotal());
            }
        }else {
            if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(stuname)){
                List<Student> list=studentService.selectList2(page,username,stuname);
                Long total=studentService.selectnum1(username,stuname);
                return Result.suc(list, total);
            }else if(!StringUtils.isEmpty(username)){
                List<Student> list=studentService.selectList(page,username);
                Long total=studentService.selectnum2(username);
                return Result.suc(list, total);
            }
            else if (!StringUtils.isEmpty(stuname)){
                List<Student> list=studentService.selectList1(page,stuname);
                Long total=studentService.selectnum3(stuname);
                return Result.suc(list, total);
            }
            else{
                IPage<Student> result = studentService.findByAllPage(page);
//            System.out.println(result.getRecords());
                return Result.suc(result.getRecords(),result.getTotal());
            }
        }
    }

    /**
     * 查重名学生
     */
    @GetMapping("/findByUsername")
    public Result findUserByUsername(@RequestParam Map<String, String> data){
        String username = data.get("username");
        List<User> list=studentService.findUserByUsername(username);
        if (list.size()>0){
            return Result.fail();
        }else {
            return Result.suc();
        }
    }
    /**
     * 查重名学生id
     */
    @GetMapping("/findBystunumber")
    public Result findBystunumber(@RequestParam Map<String, String> data){
        int stunumber = Integer.parseInt(data.get("stu_number"));
        List<Student> list=studentService.findUserStunumber(stunumber);
        System.out.println(list);
        if (list.size()>0){
            return Result.fail();
        }else {
            return Result.suc();
        }
    }

    /**
     * 添加学生
     */
    @PostMapping("/addstu")
    public Result addstu(@RequestBody Map<String, String> data)  {
        //接收参数
        String username = data.get("username");
        String password = data.get("password");
        String userGroup = data.get("userGroup");
        String gender = data.get("gender");
        String stuName = data.get("stu_name");
        int stuNumber = Integer.parseInt(data.get("stu_number"));
        String academy = data.get("academy");
        String major = data.get("major");
        String className = data.get("className");
        int teanumber;
        String status="可用";
        if (!StringUtils.isEmpty(academy)){
            List<Teacher> list=studentService.findUserTeanumber2(academy);
            System.out.println(list);
            int size=list.size();
            int num=RandomUtil.randomInt(0, size);
            teanumber=list.get(num).getTeaNumber();
        }else {
            teanumber= Integer.parseInt(null);
        }
        try{
            User user=new User(0,userGroup,username,password,status);
            studentService.adduname(user);
            Student student=new Student(0,stuNumber,stuName,gender,academy,major,className,teanumber,username);
            studentService.addstu(student);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }

    /**
     * 删除学生
     */
    @PostMapping("/delstu")
    public Result delstu(@RequestBody String data){
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
                studentService.delstu(username);
                studentService.delstu1(username);
            }
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }

    /**
     * 查询学生
     */
    @PostMapping("/selectmessage")
    public Result selectmessage(@RequestBody Map<String, String> data){
        String username = data.get("username");
        try{
            List<Student> list= studentService.selectstuList(username);
            return Result.suc(list);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }

    /**
     * 修改学生
     */
    @PostMapping("/modstu")
    public Result modstu(@RequestBody Map<String, String> data)  {
        //接收参数
        String username = data.get("username");
        String status = data.get("status");
        String userGroup = data.get("user_group");
        String email = data.get("email");
        String phone = data.get("phone");
        String academy = data.get("academy");
        String major = data.get("major");
        String className = data.get("className");
        String gender = data.get("gender");
        int stuNumber = Integer.parseInt(data.get("stuNumber"));
        int teaNumber = Integer.parseInt(data.get("teaNumber"));
        String stuName = data.get("stuName");
        try{
            User user=new User(0,userGroup,phone,username,status,email);
            studentService.modstu(user);
            Student student=new Student(0,stuNumber,stuName,gender,academy,major,className,teaNumber,username);
            studentService.modstu1(student);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //查教师学院与学生学院是否一样
    @GetMapping("/findByteanumber")
    public Result findByteanumber(@RequestParam Map<String, String> data){
        int teaNumber = Integer.parseInt(data.get("teaNumber"));
        String username=data.get("username");
        String academy=data.get("academy");
        List<Student> list=studentService.findUserTeanumber(username);
        List<Teacher> list1=studentService.findUserTeanumber1(teaNumber);
        if (!StringUtils.isEmpty(academy)){
            list.get(0).setAcademy(academy);
        }
//        System.out.println(list.get(0).getAcademy());
//        System.out.println(list1.get(0).getFaculties());
        if (!list.get(0).getAcademy().equals(list1.get(0).getFaculties())){
            return Result.fail();
        }else {
            return Result.suc();
        }
    }
}


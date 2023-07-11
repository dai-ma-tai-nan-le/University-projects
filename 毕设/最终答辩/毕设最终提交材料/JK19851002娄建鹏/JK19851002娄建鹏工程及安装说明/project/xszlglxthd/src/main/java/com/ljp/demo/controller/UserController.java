package com.ljp.demo.controller;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Student;
import com.ljp.demo.entity.Teacher;
import com.ljp.demo.entity.User;
import com.ljp.demo.service.StudentService;
import com.ljp.demo.service.TeacherService;
import com.ljp.demo.service.UserService;
import com.ljp.demo.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 用户账户：用于保存用户登录信息(User)表控制层
 *
 * @author makejava
 * @since 2023-03-10 13:25:13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 分页查询所有管理员
     */
    @PostMapping("/glylist")
    public Result<List<User>> glylist(@RequestBody QueryPageParam query){
//        System.out.println(query+"vdkolpasj");
        HashMap param = query.getParam();
        String username = (String)param.get("username");
        Page<User> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        if(!StringUtils.isEmpty(username)){
            List<User> list=userService.selectList(page,username);
            Long total=userService.selectnum1(username);
            return Result.suc(list, (long) total);
        }
        else{
            LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
            IPage<User> result = userService.findByAllPage(page,lambdaQueryWrapper);
//            System.out.println(result.getRecords());
            return Result.suc(result.getRecords(),result.getTotal());
        }
    }
    /**
     * 查重名管理员
     */
    @GetMapping("/findByUsername")
    public Result findUserByUsername(@RequestParam Map<String, String> data){
        String username = data.get("username");
        List<User> list=userService.findUserByUsername(username);
        if (list.size()>0){
            return Result.fail();
        }else {
            return Result.suc();
        }
    }

    /**
     * 添加管理员
     */
    @PostMapping("/addgly")
    public Result addgly(@RequestBody Map<String, String> data)  {
        //接收参数
        String username = data.get("username");
        String password = data.get("password");
        String userGroup = data.get("userGroup");
        String email = data.get("email");
        String phone = data.get("phone");
        String status="可用";
        try{
            User user=new User(0,userGroup,phone,username,password,status,email,"");
            userService.addgly(user);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    /**
     * 删除管理员
     */
    @PostMapping("/delgly")
    public Result delgly(@RequestBody String data){
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
                userService.delgly(username);
            }
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    /**
     * 查询管理员
     */
    @PostMapping("/selectmessage")
    public Result selectmessage(@RequestBody Map<String, String> data){
        String username = data.get("username");
        try{
            List<User> list= userService.selectGlyList(username);
//            System.out.println(list);
            return Result.suc(list);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    /**
     * 修改管理员
     */
    @PostMapping("/modgly")
    public Result modgly(@RequestBody Map<String, String> data)  {
        //接收参数
        String username = data.get("username");
        String status = data.get("status");
        String userGroup = data.get("user_group");
        String email = data.get("email");
        String phone = data.get("phone");
        try{
            User user=new User(0,userGroup,phone,username,status,email);
            userService.modgly(user);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }


    //登录
    @PostMapping("/login")
    public Result login(@RequestBody Map<String, String> data)  {
        //接收参数
        String username = data.get("account");
        String password = data.get("password");
        String token= JWTUtils.getToken(username);
//        System.out.println(token);
        Date loginTime;
        password=Md5Utils.md5(password);
        List<User> list=userService.findUserByUsername(username);
        System.out.println(list);
        if (list.size() == 0){
            return Result.fail1();
        }
        else if (list.get(0).getPassword().equals(password)){
            //就账号状态进行判断
            if (list.get(0).getStatus().equals("可用")){
                if (list.get(0).getUserGroup().equals("管理员")){
                    loginTime=new Date();
                    userService.modlogintime(loginTime,username);
                    return Result.suc(list,token);
                }else if (list.get(0).getUserGroup().equals("学生")){
                    List<Student> students= userService.selectstuList(username);
                    loginTime=new Date();
                    userService.modlogintime(loginTime,username);
                    return Result.suc(students,token);
                }else {
                    List<Teacher> teachers= userService.selectteaList(username);
                    if (teachers.get(0).getExamineState().equals("通过")){
                        loginTime=new Date();
                        userService.modlogintime(loginTime,username);
                        return Result.suc(teachers,token);
                    }else{
                        return Result.fail4();
                    }
                }
            }else {
                return Result.fail3();
            }
        }else{
            return Result.fail2();
        }
    }
    //注册
    @PostMapping("/register")
    public Result register(@RequestBody Map<String, String> data){
        //接收参数
        String username = data.get("username");
        String password = data.get("password");
        String userGroup = data.get("user_group");
        String stuName = data.get("stu_name");
        String academy = data.get("academy");
        String teaName = data.get("tea_name");
        String avatar="";
        int teaNumber;
        String faculties = data.get("faculties");
        String email = data.get("email");
        String status="可用";
        String examineState="未通过";
        try{
            if (userGroup.equals("学生")){
                int stuNumber = Integer.parseInt(data.get("stu_number"));
                //随机给教师编号
                List<Teacher> list=studentService.findUserTeanumber2(academy);
                System.out.println(list);
                int size=list.size();
                int num= RandomUtil.randomInt(0, size);
                teaNumber=list.get(num).getTeaNumber();
                User user=new User(0,userGroup,username,password,status,email,avatar);
                studentService.adduname(user);
                Student student=new Student(0,stuNumber,stuName,academy,teaNumber,username);
                studentService.addstu(student);
                return Result.suc();
            }else {
                teaNumber = Integer.parseInt(data.get("tea_number"));
                User user=new User(0,userGroup,username,password,status,email,avatar);
                Teacher teacher=new Teacher(0,teaNumber,teaName,faculties,examineState,username);
                teacherService.adduname(user);
                teacherService.addtea(teacher);
                return Result.suc();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //查询是否有该用户名
    @GetMapping("/findUsername")
    public Result findUsername(@RequestParam Map<String, String> data){
        String username = data.get("username");
        List<User> list=userService.findUserByUsername(username);
        if (list.size()>0){
            return Result.suc();
        }else {
            return Result.fail();
        }
    }
    //查询邮箱是否对应用户名
    @GetMapping("/findemail")
    public Result findemail(@RequestParam Map<String, String> data){
        String username = data.get("username");
        String email = data.get("email");
        List<User> list=userService.findUserByUsername(username);
        if (list.size()>0){
           if(list.get(0).getEmail().equals(email)){
               return Result.suc();
           }else {
               return Result.fail();
           }
        }else {
            return Result.fail();
        }
    }
    //发送验证码
    @PostMapping("/send")
    public Result send(@RequestBody Map<String, String> data){
        String username = data.get("username");
        String email = data.get("email");
        if (!StringUtils.isEmpty(username)||!StringUtils.isEmpty(email)){
            String code=RandomUtils.createActiveNumber();
            redisTemplate.opsForValue().set(username,code,5, TimeUnit.MINUTES);
//            System.out.println( redisTemplate.opsForValue().get(username)+"==============================");
            EmailUtils.sendEmail(username,email,code);
            return Result.suc();
        }else {
            return Result.fail();
        }
    }
    //忘记密码
    @PostMapping("/forgot")
    public Result forgot(@RequestBody Map<String, String> data){
        String username = data.get("username");
        String code = data.get("code");
        String password = data.get("password");
        String code1= (String) redisTemplate.opsForValue().get(username);
        if (code1.equals("")){
            return Result.fail6();
        }
        else if (code.equals(code1)){
            User user=new User(username,password);
            userService.updatePassword(user);
            return Result.suc();
        }else {
            return Result.fail5();
        }
    }


            //修改密码
    //查询是否是该用户的密码
    @GetMapping("/findpassword")
    public Result findpassword (@RequestParam Map<String, String> data){
        String username = data.get("username");
        String password = data.get("password");
        password=Md5Utils.md5(password);
        List<User> list=userService.findUserByUsername(username);
        if (list.size()>0){
            if(list.get(0).getPassword().equals(password)){
                return Result.suc();
            }else {
                return Result.fail();
            }
        }else {
            return Result.fail();
        }
    }
    //修改密码
    @PostMapping("/modpassword")
    public Result modpassword(@RequestBody Map<String, String> data){
        String username = data.get("username");
        //新密码
        String password = data.get("password");
        //旧密码
        String password1 = data.get("password1");
        System.out.println(password1);
        if (password1.equals("")||password.equals("")){
            return Result.fail7();
        }
        password1=Md5Utils.md5(password1);
        List<User> list=userService.findUserByUsername(username);
        if (list.get(0).getPassword().equals(password1)){
            try{
                User user=new User(username,password);
                userService.updatePassword(user);
                return Result.suc();
            }catch (Exception e){
                e.printStackTrace();
                return Result.fail();
            }
        }else {
            return Result.fail();
        }
    }


}


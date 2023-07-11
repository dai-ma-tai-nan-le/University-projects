package com.liu.covid.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.covid.entity.EmpIs;
import com.liu.covid.mapper.EmpIsMapper;
import com.liu.covid.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.liu.covid.contant.UserConstant.USER_LOGIN_STATE;

@RestController
@RequestMapping("/empis")
public class EmpIsController {
    @Autowired
    private EmpIsMapper mapper;

    @Resource
    private RedisCache redisCache;

    //分页查询
    @GetMapping("/findAll/{page}/{size}")
    public Page<EmpIs> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Object cacheObject = redisCache.getCacheObject(USER_LOGIN_STATE);
        if (cacheObject!=null){
            Page<EmpIs> page1= new Page<>(page,size);
            Page<EmpIs> result=mapper.selectPage(page1,null);
            return result;
        }
        return null;

    }


    @PostMapping("/save")
    public String save(@RequestBody EmpIs empis){
        Format f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(empis.getBegin());
        c.add(Calendar.DAY_OF_MONTH, 14);
        Date end = c.getTime();
        empis.setEnd(end);
        int result = mapper.insert(empis);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public EmpIs findById(@PathVariable("id") Integer id){
        return mapper.selectById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody EmpIs empis){
        Format f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(empis.getBegin());
        c.add(Calendar.DAY_OF_MONTH, 14);
        Date end = c.getTime();
        empis.setEnd(end);
        int result=mapper.updateById(empis);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")Integer id){
        mapper.deleteById(id);
    }

    @GetMapping("/search/{searchkey}/{stext}")
    public List<EmpIs> search(@PathVariable("searchkey")String searchkey, @PathVariable("stext")String stext){
        QueryWrapper<EmpIs> userQueryWrapper = Wrappers.query();
        userQueryWrapper.like(searchkey,stext);
        return mapper.selectList(userQueryWrapper);
    }
}

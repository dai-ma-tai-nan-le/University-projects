package com.liu.covid.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.covid.entity.EmpIs;
import com.liu.covid.entity.MaterialManage;
import com.liu.covid.mapper.MaterialMapper;
import com.liu.covid.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.liu.covid.contant.UserConstant.USER_LOGIN_STATE;

@RestController
@RequestMapping("/Material")
public class MaterialController {

    @Autowired
    private MaterialMapper mapper;

    @Resource
    private RedisCache redisCache;

    //分页查询
    @GetMapping("/findAll/{page}/{size}")
    public Page<MaterialManage> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Object cacheObject = redisCache.getCacheObject(USER_LOGIN_STATE);
        if (cacheObject!=null){
            Page<MaterialManage> page1= new Page<>(page,size);
            Page<MaterialManage> result=mapper.selectPage(page1,null);
            return result;
        }
        return null;

    }

    @PostMapping("/save")
    public String save(@RequestBody MaterialManage material){
        int result = mapper.insert(material);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public MaterialManage findById(@PathVariable("id") Integer id){
        return mapper.selectById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody MaterialManage material){
        int result=mapper.updateById(material);
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
    public List<MaterialManage> search(@PathVariable("searchkey")String searchkey, @PathVariable("stext")String stext){
        QueryWrapper<MaterialManage> userQueryWrapper = Wrappers.query();
        userQueryWrapper.like(searchkey,stext);
        return mapper.selectList(userQueryWrapper);
    }
}

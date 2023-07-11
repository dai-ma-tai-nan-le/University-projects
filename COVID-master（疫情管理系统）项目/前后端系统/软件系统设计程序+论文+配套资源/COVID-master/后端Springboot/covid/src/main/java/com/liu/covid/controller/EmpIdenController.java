package com.liu.covid.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.covid.entity.EmpIden;
import com.liu.covid.mapper.EmpIdenMapper;
import com.liu.covid.service.ChartService;
import com.liu.covid.utils.RedisCache;
import com.liu.covid.vo.LineVO;
import com.liu.covid.vo.PieVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static com.liu.covid.contant.UserConstant.USER_LOGIN_STATE;


@RestController
@RequestMapping("/empiden")
public class EmpIdenController {
    @Autowired
    private ChartService chartService;
    @Autowired
    private EmpIdenMapper mapper;
    @Resource
    private RedisCache redisCache;

    //分页查询
    @GetMapping("/findAll/{page}/{size}")
    public Page<EmpIden> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Object cacheObject = redisCache.getCacheObject(USER_LOGIN_STATE);
        if (cacheObject!=null){
            Page<EmpIden> page1= new Page<>(page,size);
            Page<EmpIden> result=mapper.selectPage(page1,null);
            return result;
        }
        return null;

    }


    @PostMapping("/save")
    public String save(@RequestBody EmpIden empIden){
        int result = mapper.insert(empIden);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/LineVO")
    public LineVO getLineVO(){
        return this.chartService.lineVOList();
    }
    @GetMapping("/PieVO")
    public List<PieVo> getPieVO(){
        return this.chartService.pieVOMap();
    }
    @GetMapping("/findById/{id}")
    public EmpIden findById(@PathVariable("id") Integer id){
        return mapper.selectById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody EmpIden empIden){

        int result=mapper.updateById(empIden);
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
    public List<EmpIden> search(@PathVariable("searchkey")String searchkey, @PathVariable("stext")String stext){
        QueryWrapper<EmpIden> userQueryWrapper = Wrappers.query();
        userQueryWrapper.like(searchkey,stext);
        return mapper.selectList(userQueryWrapper);
    }
}


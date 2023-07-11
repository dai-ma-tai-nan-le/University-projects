package com.ljp.demo.controller;

import com.ljp.demo.entity.Accomplishment;
import com.ljp.demo.service.AccomplishmentService;
import com.ljp.demo.utils.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 成就(Accomplishment)表控制层
 *
 * @author makejava
 * @since 2023-04-26 16:53:09
 */
@RestController
@RequestMapping("/accomplishment")
public class AccomplishmentController {
    /**
     * 服务对象
     */
    @Resource
    private AccomplishmentService accomplishmentService;


    //查询该用户的成就
    @PostMapping("/cjList")
    public Result cjList(@RequestBody Map<String, String> data){
        String username = data.get("username");
        try {
            List<Accomplishment> accomplishments=accomplishmentService.selectAllcj(username);
            for (int i=0;i<accomplishments.size();i++){
                int num=accomplishments.get(i).getAccomplishmentId()%11;
                String cj="http://localhost:8080/cj/"+num+".jpg";
                accomplishments.get(i).setCj(cj);
            }
            return Result.suc(accomplishments);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
}


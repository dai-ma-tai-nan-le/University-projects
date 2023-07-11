package com.ljp.demo.controller;

import com.ljp.demo.entity.Upclock;
import com.ljp.demo.service.UpclockService;
import com.ljp.demo.utils.Result;
import okhttp3.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 打卡(Upclock)表控制层
 *
 * @author makejava
 * @since 2023-03-25 16:38:10
 */
@RestController
@RequestMapping("/upclock")
public class UpclockController {
    /**
     * 服务对象
     */
    @Resource
    private UpclockService upclockService;

    @PostMapping("/daka")
    public Result daka(@RequestBody Map<String, String> data) throws IOException {
        String username = data.get("username");
        Date date = new Date();
        Upclock upclock = new Upclock(0, username, date);
        upclockService.insertclock(upclock);
        List<Upclock> list = upclockService.selectname(username);
        int num = 0;
        for (int i = 0; i < list.size()-1; i++) {
//            System.out.println((list.get(i+1).getUpTime().getTime()-list.get(i).getUpTime().getTime())/86400000);
//            System.out.println(list.get(i).getUpTime());
//            System.out.println(list.get(i).getUpTime().getTime());
            boolean b=(list.get(i+1).getUpTime().getTime()-list.get(i).getUpTime().getTime())/86400000 < 1.5;
//            System.out.println(b);
            if (b){
                num++;
            }else {
                num=1;
            }
        }
        //创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();
        //创建Request对象
        Request request = new Request.Builder()
                .url("https://v.api.aa1.cn/api/yiyan/index.php")
                .build();
        //创建Call对象
        Response response =  client.newCall(request).execute();
        String context=response.body().string();
        return Result.suc((long)num,context);
    }
}


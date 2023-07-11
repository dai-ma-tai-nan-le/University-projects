package com.ljp.demo.controller;

import com.ljp.demo.entity.Sleepclock;
import com.ljp.demo.entity.Upclock;
import com.ljp.demo.service.SleepclockService;
import com.ljp.demo.utils.Result;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 打卡(Sleepclock)表控制层
 *
 * @author makejava
 * @since 2023-03-25 16:37:08
 */
@RestController
@RequestMapping("/sleepclock")
public class SleepclockController {
    /**
     * 服务对象
     */
    @Resource
    private SleepclockService sleepclockService;

    @PostMapping("/daka")
    public Result daka(@RequestBody Map<String, String> data) throws IOException {
        String username = data.get("username");
        Date date = new Date();
        Sleepclock upclock = new Sleepclock(0, username, date);
        sleepclockService.insertclock(upclock);
        List<Sleepclock> list = sleepclockService.selectname(username);
        int num = 0;
        for (int i = 0; i < list.size()-1; i++) {
            boolean b=(list.get(i+1).getSleepTime().getTime()-list.get(i).getSleepTime().getTime())/86400000 < 1.5;
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


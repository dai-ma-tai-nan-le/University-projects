package com.offcn.imovie.service.impl;

import com.offcn.imovie.dao.DataDao;
import com.offcn.imovie.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    DataDao dataDao;

    public Map data(){
        int movienum =dataDao.movieNum();
        int categroynum=dataDao.categoryNum();
        int performernum=dataDao.performerNum();
        int usernum=dataDao.userNum();

        Map<String,Integer> dataMap=new HashMap<String, Integer>();

        dataMap.put("movienum",movienum);
        dataMap.put("categroynum",categroynum);
        dataMap.put("performernum",performernum);
        dataMap.put("usernum",usernum);

        return dataMap;
    }
}

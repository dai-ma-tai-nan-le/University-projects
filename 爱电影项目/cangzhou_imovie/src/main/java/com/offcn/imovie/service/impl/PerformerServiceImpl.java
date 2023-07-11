package com.offcn.imovie.service.impl;

import com.offcn.imovie.dao.PerformerDao;
import com.offcn.imovie.pojo.Performer;
import com.offcn.imovie.service.PerformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformerServiceImpl implements PerformService {

    @Autowired
    PerformerDao performerDao;

    public List<Performer> performerTop5() {
    List<Performer> performers= performerDao.performerTop5();
        return performers;
    }
}

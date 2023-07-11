package com.project.demo.controller;

import com.project.demo.entity.SummaryOfExperience;
import com.project.demo.service.SummaryOfExperienceService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *心得总结：(SummaryOfExperience)表控制层
 *
 */
@RestController
@RequestMapping("/summary_of_experience")
public class SummaryOfExperienceController extends BaseController<SummaryOfExperience,SummaryOfExperienceService> {

    /**
     *心得总结对象
     */
    @Autowired
    public SummaryOfExperienceController(SummaryOfExperienceService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}

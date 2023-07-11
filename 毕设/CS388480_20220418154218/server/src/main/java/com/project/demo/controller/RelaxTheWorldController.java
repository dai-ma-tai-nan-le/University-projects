package com.project.demo.controller;

import com.project.demo.entity.RelaxTheWorld;
import com.project.demo.service.RelaxTheWorldService;
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
 *放松天地：(RelaxTheWorld)表控制层
 *
 */
@RestController
@RequestMapping("/relax_the_world")
public class RelaxTheWorldController extends BaseController<RelaxTheWorld,RelaxTheWorldService> {

    /**
     *放松天地对象
     */
    @Autowired
    public RelaxTheWorldController(RelaxTheWorldService service) {
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

package com.liu.covid.controller;


import com.liu.covid.entity.Department;
import com.liu.covid.mapper.DepartMapper;
import com.liu.covid.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/depart")
public class DepartController {

    @Autowired
    DepartService service;

    @GetMapping("/findAll")
    private List<String>  findAll(){

        System.out.println(123);
        List list = service.getAll();
       return list;
    }
}

//controller层是连接前端和后端的。
//接受前端发来的请求，同时向后端发送请求，——>service 层——>serviceImpl实现service层,同时连接dao层，（在dao层中同样是接口）
// ——>通过dao层去实现对数据库的操作——在XML文件中通过namespace完成连接dao层。
//对于不同的数据库，不同的表操作，可以通过在serviceImple层来变换。然后写不同的dao层和不同的XML文件来操作。

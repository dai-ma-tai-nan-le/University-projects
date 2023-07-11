package com.liu.covid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.covid.entity.Department;

import java.util.List;

//封装方法
public interface DepartService extends IService<Department> {
    public List<String> getAll();
}




//service是业务层，是使用一个或多个模型执行操作的方法。.
// 1. 封装通用的业务逻辑，操作。. 如一些数据的检验，可以通用处理。.
// 2. 与数据层的交互dao。.
// 3. 其他请求：如远程服务获取数据，如第三方api等。
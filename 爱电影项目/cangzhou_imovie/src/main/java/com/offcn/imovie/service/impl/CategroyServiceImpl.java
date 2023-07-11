package com.offcn.imovie.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.offcn.imovie.dao.CategroyDao;
import com.offcn.imovie.pojo.CategroyVO;
import com.offcn.imovie.service.CategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategroyServiceImpl implements CategroyService {
    @Autowired
    CategroyDao categroyDao;

    public List<CategroyVO> vos() {
        List<CategroyVO> vos=new ArrayList<CategroyVO>();
        //所有大分类名称
        List<String> categroyList =categroyDao.categroyList();
        for(String s:categroyList){
            CategroyVO vo=new CategroyVO();
            vo.setCategroy(s);//大分类名称
            List<String> titles=categroyDao.getTitlesByCategroy(s);
            vo.setTitles(titles);
            vos.add(vo);
        }
        return vos;
    }

    //删除所有（一行）
    public void deleteByCategroy(String categroy) {
        if(StringUtils.isEmpty(categroy)){
            throw new RuntimeException("大分类名称不能为空");
        }
        categroyDao.deleteByCategroy(categroy);
    }

    //跳转到一个大分类里的小分类
    public CategroyVO getCategroyVo(String categroy) {
        CategroyVO categroyVO=new CategroyVO();
        categroyVO.setCategroy(categroy);
        List<String> titles=categroyDao.getTitlesByCategroy(categroy);
        categroyVO.setTitles(titles);
        return categroyVO;
    }

    //删除小分类
    public void deleteTitle(String categroy, String title) {
        categroyDao.deleteTitle(categroy,title);
    }
}

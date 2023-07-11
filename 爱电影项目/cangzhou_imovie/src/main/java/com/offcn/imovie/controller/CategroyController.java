package com.offcn.imovie.controller;

import com.offcn.imovie.pojo.CategroyVO;
import com.offcn.imovie.service.CategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategroyController {
    @Autowired
    CategroyService categroyService;

    @RequestMapping("categoryList")
    public String categoryList(Model model){
        List<CategroyVO> vos=categroyService.vos();
        model.addAttribute("voList",vos);
        return "/categoryList.jsp";
    }

    //点击删除按钮，调用该方法
    @RequestMapping("deleteByCategroy")
    public String deleteByCategroy(String categroy){
        categroyService.deleteByCategroy(categroy);
        return "redirect:/category/categoryList";
    }

    @RequestMapping("/toVoPage")
    public String toVoPage(String categroy,Model model){
        CategroyVO vo=categroyService.getCategroyVo(categroy);
        model.addAttribute("vo",vo);
        return "/categoryvo.jsp";
    }

    @RequestMapping("deleteTitle")
    public String deleteTitle(String categroy,String title,Model model){
        //删除小分类
        categroyService.deleteTitle(categroy,title);
        //重新加载当前分类的vo对象
        CategroyVO vo=categroyService.getCategroyVo(categroy);
        model.addAttribute("vo",vo);
        return "/categoryvo.jsp";
    }
}

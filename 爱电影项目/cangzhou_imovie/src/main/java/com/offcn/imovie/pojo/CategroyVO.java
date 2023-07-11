package com.offcn.imovie.pojo;

import java.util.List;

//一行数据封装到一个vo对象中
public class CategroyVO {
    public String getCategroy() {
        return categroy;
    }

    public void setCategroy(String categroy) {
        this.categroy = categroy;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    //大分类名称
    private String categroy;
    //小分类名称集合
    private List<String> titles;
}

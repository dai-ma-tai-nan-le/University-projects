package com.ljp.entity;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    //页码
    private int pageNum;
    //页大小
    private int pageSize;
    //总的数据个数
    private long totalSize;
    //总页数
    private int pageCount;
    //数据
    private List<T> data;
    //开始页码
    private int startPage;
    //结束页码
    private int endPage;

    public PageBean(int pageNum, int pageSize, long totalSize, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.data = data;
        //计算总页数
        this.pageCount= (int) (totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1);
        //计算开始页码和结束页码
        this.startPage=this.pageNum-4;
        this.endPage=this.pageNum+5;
        //最后几页
        if (this.pageNum>this.pageCount-5){
            this.startPage=this.pageNum-9;
            this.endPage=this.pageCount;
        }
        //前几页
        if (this.pageNum>this.pageCount-5){
            this.startPage=1;
            this.endPage=10;
        }
        //页数小于10页
        if (this.pageCount<10){
            this.startPage=1;
            this.endPage=this.pageCount;
        }
    }
}

package com.ljp.demo.utils;


import com.ljp.demo.entity.User;

import java.util.List;

//给返回前端的数据进行封装
public class Result<T> {

    // 200/400
    private Integer code;
    // 成功/失败
    private String mes;
    // 总条数
    private Long total;
    // 数据
    private T data;
    //token
    private String token;


    public static<T> Result<T> fail(){
        return result(400,"失败",0L,null,"");
    }
    //token验证
    public static<T> Result<T> failtoken(int code,String mes){
        return result(code,mes,0L,null,"");
    }
    //没有该用户/用户名输入错误
    public static<T> Result<T> fail1(){
        return result(401,"失败",0L,null,"");
    }
    //密码输入有误
    public static<T> Result<T> fail2(){
        return result(402,"失败",0L,null,"");
    }
    //该账号已被禁用
    public static<T> Result<T> fail3(){
        return result(408,"失败",0L,null,"");
    }
    //该账号还没有通过管理员的审核
    public static<T> Result<T> fail4(){
        return result(409,"失败",0L,null,"");
    }
    //验证码不一致
    public static<T> Result<T> fail5(){
        return result(403,"失败",0L,null,"");
    }
    //验证码已过期，请重新发送
    public static<T> Result<T> fail6(){
        return result(404,"失败",0L,null,"");
    }
    //请输入密码
    public static<T> Result<T> fail7(){
        return result(405,"失败",0L,null,"");
    }
    // 上传的不是图片
    public static<T> Result<T> fail8(){
        return result(406,"失败",0L,null,"");
    }
    //时长不够30分钟
    public static<T> Result<T> fail9(){
        return result(407,"失败",0L,null,"");
    }
    //通过加入码加入
    public static<T> Result<T> fail10(){
        return result(411,"失败",0L,null,"");
    }
    //自习室人数满了
    public static<T> Result<T> fail11(){
        return result(412,"失败",0L,null,"");
    }
    //自习室密码不正确
    public static<T> Result<T> fail12(){
        return result(413,"失败",0L,null,"");
    }
    //问题不能为空
    public static<T> Result<T> fail13(){
        return result(414,"失败",0L,null,"");
    }
    public static<T> Result<T> suc(){
        return result(200,"成功",0L,null,"");
    }
    public static<T> Result<T> suc(Long total){
        return result(200,"成功",total,null,"");
    }
    public static<T> Result<T> suc(T data){
        return result(200,"成功",0L, data,"");
    }
    public static<T> Result<T> suc(T data,Long total){
        return result(200,"成功",total,  data,"");
    }
    public static<T> Result<T> suc(T data,String token){
        return result(200,"成功",0L,data,token);
    }
    public static<T> Result<T> suc(Long total,String token){
        return result(200,"成功",total,null,token);
    }
    public static<T> Result<T> suc1(T data){
        return result(201,"成功",0L, data,"");
    }
    public static<T> Result<T> suc2(T data){
        return result(202,"成功",0L, data,"");
    }
    public static<T> Result<T> suc3(T data){
        return result(203,"成功",0L, data,"");
    }
    public static<T> Result<T> suc4(T data){
        return result(204,"成功",0L, data,"");
    }
    public static<T> Result<T> suc5(T data){
        return result(205,"成功",0L, data,"");
    }
    public static<T> Result<T> suc6(T data){
        return result(206,"成功",0L, data,"");
    }
    public static<T> Result<T> suc7(T data){
        return result(207,"成功",0L, data,"");
    }
    public static<T> Result<T> suc8(T data){
        return result(208,"成功",0L, data,"");
    }
    public static<T> Result<T> suc9(T data){
        return result(209,"成功",0L, data,"");
    }
    public static<T> Result<T> suc10(T data){
        return result(210,"成功",0L, data,"");
    }
    public static<T> Result<T> suc11(){
        return result(211,"成功",0L, null,"");
    }
    public static<T> Result<T> suc12(){
        return result(212,"成功",0L, null,"");
    }
    public static<T> Result<T> suc13(){
        return result(213,"成功",0L, null,"");
    }
    public static<T> Result<T> suc14(){
        return result(214,"成功",0L, null,"");
    }
    public static<T> Result<T> suc15(){
        return result(215,"成功",0L, null,"");
    }
    public static<T> Result<T> suc16(){
        return result(216,"成功",0L, null,"");
    }
    public static<T> Result<T> suc17(){
        return result(217,"成功",0L, null,"");
    }
    public static<T> Result<T> suc18(){
        return result(218,"成功",0L, null,"");
    }
    public static<T> Result<T> suc19(){
        return result(219,"成功",0L, null,"");
    }
    public static<T> Result<T> suc20(){
        return result(220,"成功",0L, null,"");
    }



    private static<T> Result<T> result(Integer code, String mes, Long total, T data,String token) {
        Result<T> res=new Result();
        res.setData(data);
        res.setCode(code);
        res.setMes(mes);
        res.setTotal(total);
        res.setToken(token);
        return res;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", mes='" + mes + '\'' +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}

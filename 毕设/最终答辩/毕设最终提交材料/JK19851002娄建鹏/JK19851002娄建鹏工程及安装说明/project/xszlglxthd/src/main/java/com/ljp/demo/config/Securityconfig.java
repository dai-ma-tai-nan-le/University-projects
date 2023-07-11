package com.ljp.demo.config;

import com.ljp.demo.filter.JWTInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

//security配置类
@Configuration
public class Securityconfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                .allowCredentials(true)//是否发送cookie（允许发送cookie证书）
                .allowedOriginPatterns("*")//允许放行所有的原始域
                .allowedMethods(new String[]{"GET","POST","PUT","DELETE"})//允许放行的方法
                .allowedHeaders("*")//允许放行所有的Header属性
                .exposedHeaders("*");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/findUsername")
                .excludePathPatterns("/user/findemail")
                .excludePathPatterns("/user/send")
                .excludePathPatterns("/teacher/findByUsername")
                .excludePathPatterns("/teacher/findByteanumber")
                .excludePathPatterns("/student/findBystunumber")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/user/forgot")
                .excludePathPatterns("/upload/*");
//                .excludePathPatterns("/upload/")
//                .excludePathPatterns("/upload/avatar");
    }

    @Bean
    public JWTInterceptor jwtInterceptor(){
        return new JWTInterceptor();
    }
}

package com.ljp.demo.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ljp.demo.entity.User;
import com.ljp.demo.service.UserService;
import com.ljp.demo.utils.Exception.ServiceException;
import com.ljp.demo.utils.JWTUtils;
import com.ljp.demo.utils.Result;
import com.ljp.demo.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//去获取token并验证token------拦截器
public class JWTInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String token = request.getHeader("token");
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //否则进行token检查
        if (StringUtils.isEmpty(token)) {
            throw new ServiceException(410,"无token，请重新登录");
        }
        //获取token中的用户username
        String username = request.getHeader("username");
        try {
            username = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new  ServiceException(410,"token验证失败，请重新登录");
        }
        //根据token中的username查询数据库
        List<User> user = userService.findUserByUsername(username);
        if (user.size()==0) {
            throw new ServiceException(410,"用户不存在，请重新登录");
        }
        //验证token
        try {
            DecodedJWT verify = JWTUtils.verify(token);
            if (verify==null){
                throw new ServiceException(410,"token验证失败，请重新登录");
            }
        } catch (JWTVerificationException e) {
            throw new ServiceException(410,"token验证失败，请重新登录");
        }
        return true;
    }
}

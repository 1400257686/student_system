package com.zxl.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object id=request.getSession().getAttribute("id");
        if(id==null){
            response.sendRedirect("/index.html");
            return false;
        }else {
            return true;
        }
    }
}

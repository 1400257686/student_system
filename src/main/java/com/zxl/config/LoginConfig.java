package com.zxl.config;

import com.zxl.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    /**
     * 配置拦截器，对初始页和修改密码页，登录，更新密码的controller放行
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/index.html","/update.html","/","/login","/update","/**/*.css","/**/*.js","/images/*");
    }
}

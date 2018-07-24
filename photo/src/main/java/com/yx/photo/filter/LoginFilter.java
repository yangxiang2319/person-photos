package com.yx.photo.filter;

import com.yx.photo.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录过滤器
 * @author yangxiang
 * @date 2018/6/8 8:23
 */
@Component
public class LoginFilter implements Filter{

    private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        if (url.startsWith("/") && url.length() > 1) {
            url = url.substring(1);
        }

        log.info("接收到请求URL:{}",url);

        if(url.indexOf(".html")!=-1){
            log.info("非法访问静态页面，跳转到登录页面。。。");
            String path = httpRequest.getContextPath();
            String basePath = httpRequest.getScheme()+"://"+httpRequest.getServerName()+":"+httpRequest.getServerPort()+path;
            httpResponse.sendRedirect(basePath+"/goLogin/login.do");
        }else if(url.indexOf("images/")!=-1
                || url.indexOf("css/")!=-1
                || url.indexOf("font/")!=-1
                || url.indexOf("icon/")!=-1
                || url.indexOf("js/")!=-1
                || url.indexOf("lay")!=-1
                || url.equals("goLogin/login.do")
                || url.equals("bus/loginValidate")
                ){
            filterChain.doFilter(httpRequest, httpResponse);
        }else{

            //session验证
            HttpSession session = httpRequest.getSession();
            if(session.getAttribute("user") == null){
                log.info("session信息不存在或已失效，跳转到登录页面");
                String path = httpRequest.getContextPath();
                String basePath = httpRequest.getScheme()+"://"+httpRequest.getServerName()+":"+httpRequest.getServerPort()+path;
                httpResponse.sendRedirect(basePath+"/goLogin/login.do");
            }else{
                filterChain.doFilter(httpRequest, httpResponse);
            }

        }
    }

    @Override
    public void destroy() {

    }
}

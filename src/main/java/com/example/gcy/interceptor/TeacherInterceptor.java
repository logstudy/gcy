package com.example.gcy.interceptor;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class TeacherInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String uri = request.getRequestURI();
        if ((uri.startsWith("/teacher") || uri.startsWith("//*") ) && null == request.getSession().getAttribute("user_teacher")) {
            request.getSession().setAttribute("msg", "请登陆后访问");
            response.sendRedirect(request.getContextPath() + "/");
            return false;
        } else {
            request.getSession().removeAttribute("msg");
            return true;
        }
    }
}

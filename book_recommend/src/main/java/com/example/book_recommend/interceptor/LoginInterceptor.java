package com.example.book_recommend.interceptor;

import com.example.book_recommend.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        String contextPath = session.getServletContext().getContextPath();
        String[] requiredAuthPages = new String[]{
                "index",
        };

        String uri = httpServletRequest.getRequestURI();
        uri = StringUtils.remove(uri, contextPath+"/");
        String page = uri;

        if(beginWith(page, requiredAuthPages)) {
            User user = (User) session.getAttribute("user");
            if(user == null) {
                httpServletResponse.sendRedirect("login");
                return false;
            }
        }
        return  true;
    }

    private boolean beginWith(String page, String[] requiredAuthPages) {
        boolean res = false;
        for(String requiredAuthPage : requiredAuthPages) {
            if(StringUtils.startsWith(page, requiredAuthPage)) {
                res = true;
                break;
            }
        }
        return res;
    }
}

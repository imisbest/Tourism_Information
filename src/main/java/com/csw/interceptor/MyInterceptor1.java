package com.csw.interceptor;

import com.csw.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyInterceptor1 implements Interceptor {
    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "login";
        } else {
            ai.invoke();
            return null;
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

}

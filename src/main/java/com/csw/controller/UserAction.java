package com.csw.controller;

import com.csw.entity.User;
import com.csw.service.UserService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * Created by HIAPAD on 2019/10/22.
 */
@Controller
@Scope(value = "prototype")
public class UserAction {
    HttpSession session = ServletActionContext.getRequest().getSession();
    @Autowired
    private UserService userService;
    private String captchaCode;
    private User user;
    private Integer currPage;
    private String erroMsg;

    public String getErroMsg() {
        return erroMsg;
    }

    public void setErroMsg(String erroMsg) {
        this.erroMsg = erroMsg;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCaptchaCode() {
        return captchaCode;
    }

    public void setCaptchaCode(String captchaCode) {
        this.captchaCode = captchaCode;
    }

    public String regist() {
       User user1 = userService.findUsernameAndPassword(user.getUsername(), user.getPassword());
        String code = (String) session.getAttribute("securityCode");
        System.out.println("user1//:"+user1);
        System.out.println("user1 == null//:"+user1 == null);
        System.out.println("code//:"+code);
        System.out.println("captchaCode//:"+captchaCode);
        System.out.println("code.equals(captchaCode)//:"+code.equals(captchaCode));
        if (user1 == null && code.equals(captchaCode)) {
            System.out.println("user//:"+user);
            userService.add(user);
            return "login";
        } else {
            erroMsg = "用户已经存在";
            return "regist";
        }
    }

    public String login() {
        System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
       User user1 = userService.findUsernameAndPassword(user.getUsername(), user.getPassword());
        String code = (String) session.getAttribute("securityCode");
        System.out.println("user1//:"+user1);
        System.out.println("user1 != null//:"+user1 != null);
        System.out.println("code//:"+code);
        System.out.println("captchaCode//:"+captchaCode);
        System.out.println("code.equals(captchaCode)//:"+code.equals(captchaCode));
        if (user1 != null && code.equals(captchaCode)) {
            session.setAttribute("user",user1);
            return "queryAndPage";
        } else {
            erroMsg = "用户不存在";
            return "login";
        }
    }

    public String safeOut() {
        session.invalidate();
        return "login";
    }
}

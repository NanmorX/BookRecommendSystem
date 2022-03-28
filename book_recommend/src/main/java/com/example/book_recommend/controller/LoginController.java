package com.example.book_recommend.controller;

import com.example.book_recommend.pojo.User;
import com.example.book_recommend.result.Result;
import com.example.book_recommend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping(value = "api/login")
    @CrossOrigin()
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
//            String message = "账号密码错误";
//            System.out.println(message);
            return new Result(400);
        } else {
//            System.out.println("success");
            session.setAttribute("user", user);
            return new Result(200);
        }
    }
}

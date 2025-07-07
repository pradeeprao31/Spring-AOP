package com.rvw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;

@Controller
public class HomeController {
    @RequestMapping("/home.htm")
    public View showHomePage() {
        JstlView jstlView = new JstlView("/WEB-INF/jsp/home.jsp");
        return jstlView;
    }
}

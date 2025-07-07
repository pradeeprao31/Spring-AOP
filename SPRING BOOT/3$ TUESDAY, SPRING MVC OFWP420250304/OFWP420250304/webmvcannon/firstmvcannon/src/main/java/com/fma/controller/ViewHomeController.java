package com.fma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewHomeController {

    @RequestMapping("/home.htm")
    public String showHome() {
        return "home";
    }
}

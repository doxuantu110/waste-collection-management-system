package com.greencity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    // Trang chủ người dùng
    @GetMapping("/web/home")
    public String userHome() {
        return "web/home";
    }

    // Trang chủ admin
    @GetMapping("/admin/home")
    public String adminHome() {
        return "admin/home";
    }
} 
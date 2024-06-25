package com.newdatabase.mydatabase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/Employees")
    public String home() {
        return "index"; // This returns the index.html template
    }
}

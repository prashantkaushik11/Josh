package com.josh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class First {
    @RequestMapping("/")
    public String myName(){
        return "home";
    }
    @RequestMapping("/a")
    public String myName2(){
        return "register";
    }
}

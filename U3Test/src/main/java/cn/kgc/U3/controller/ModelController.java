package cn.kgc.U3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("model")
public class ModelController {

    @RequestMapping("toHome")
    public String toHomePage(){
        return "home";
    }
}

package com.djd.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by HP on 2020/12/18.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "/login";
    }
}

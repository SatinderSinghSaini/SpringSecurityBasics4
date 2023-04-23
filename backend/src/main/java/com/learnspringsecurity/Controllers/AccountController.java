package com.learnspringsecurity.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping(path = "account")
    public String getAccount(){
        return "Account details from DB";
    }
}

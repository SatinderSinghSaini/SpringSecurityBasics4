package com.learnspringsecurity.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping(path = "loans")
    public String getLoans(){
        return "Loans from DB";
    }
}

package com.learnspringsecurity.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    @GetMapping(path = "cards")
    public String getCards(){
        return "Cards from DB";
    }
}

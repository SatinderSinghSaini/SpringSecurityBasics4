package com.learnspringsecurity.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping(path = "contact")
    public String getContacts(){
        return "Contacts from DB";
    }
}

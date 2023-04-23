package com.learnspringsecurity.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping(path = "notices")
    public String getNotices(){
        return "Notices from DB";
    }
}

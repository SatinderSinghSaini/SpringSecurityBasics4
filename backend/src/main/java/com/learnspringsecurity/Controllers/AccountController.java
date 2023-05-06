package com.learnspringsecurity.Controllers;

import com.learnspringsecurity.model.Accounts;
import com.learnspringsecurity.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;
    @GetMapping(path = "account")
    public Accounts getAccount(@RequestParam Long id){
        Accounts accounts = accountsRepository.findByCustomerId(id);

        if(accounts != null){
            return accounts;
        }else{
            return null;
        }
    }
}

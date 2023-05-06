package com.learnspringsecurity.Controllers;

import com.learnspringsecurity.model.AccountTransactions;
import com.learnspringsecurity.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;
    @GetMapping(path = "balance")
    public List<AccountTransactions> getBalance(@RequestParam Long id){
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);
        if(accountTransactions != null){
            return accountTransactions;
        }else{
            return null;
        }
    }
}

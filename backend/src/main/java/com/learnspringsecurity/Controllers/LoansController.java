package com.learnspringsecurity.Controllers;

import com.learnspringsecurity.model.Loans;
import com.learnspringsecurity.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {
    @Autowired
    private LoansRepository loansRepository;

    @GetMapping(path = "loans")
    public List<Loans> getLoans(@RequestParam Long id){
        List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(id);
        if(loans != null){
            return loans;
        }else{
            return null;
        }
    }
}

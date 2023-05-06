package com.learnspringsecurity.Controllers;

import com.learnspringsecurity.model.Customer;
import com.learnspringsecurity.repository.CustomerRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class Register {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        ResponseEntity response = null;
        try{
            customer.setPwd(passwordEncoder.encode(customer.getPwd()));
            customer.setCreateDt(new Date(System.currentTimeMillis()));
            Customer customerFromDb = customerRepository.save(customer);
            if(customerFromDb.getId()>0){
                response = ResponseEntity.status(HttpStatus.CREATED).body("User successfully saved");
            }
        }catch (Exception e){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occurred"+ e.getMessage());
        }
        return response;
    }

    @RequestMapping("/user")
    public Customer getCustomerAfterLogin(Authentication authentication){
        List<Customer> customers = customerRepository.findByEmail(authentication.getName());
        if(customers.size()>0){
            return customers.get(0);
        }else{
            return null;
        }
    }
}

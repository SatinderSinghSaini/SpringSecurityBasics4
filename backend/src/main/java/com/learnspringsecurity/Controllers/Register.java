package com.learnspringsecurity.Controllers;

import com.learnspringsecurity.model.Customer;
import com.learnspringsecurity.repository.CustomerRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
            Customer customerFromDb = customerRepository.save(customer);
            if(customerFromDb.getId()>0){
                response = ResponseEntity.status(HttpStatus.CREATED).body("User successfully saved");
            }
        }catch (Exception e){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occurred"+ e.getMessage());
        }
        return response;
    }
}

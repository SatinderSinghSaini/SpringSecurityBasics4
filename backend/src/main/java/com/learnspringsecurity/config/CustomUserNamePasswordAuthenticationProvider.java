package com.learnspringsecurity.config;

import com.learnspringsecurity.model.Authority;
import com.learnspringsecurity.model.Customer;
import com.learnspringsecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class CustomUserNamePasswordAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        List<Customer> customers = customerRepository.findByEmail(userName);

        if(customers.size()>0){
            if(passwordEncoder.matches(pwd,customers.get(0).getPwd())){
                return new UsernamePasswordAuthenticationToken(userName,pwd,getCustomerAuthorities(customers.get(0).getAuthorities()));
            }else{
                throw new BadCredentialsException("Password does not match.");
            }

        }else{
            throw new BadCredentialsException("User does not exist.");
        }
    }

    List<SimpleGrantedAuthority> getCustomerAuthorities(Set<Authority> authorities){
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities){
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return simpleGrantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

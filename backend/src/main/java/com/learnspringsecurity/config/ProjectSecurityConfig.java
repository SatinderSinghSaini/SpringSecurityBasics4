package com.learnspringsecurity.config;


import com.learnspringsecurity.filter.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.sql.DataSource;
import java.util.Collections;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        CsrfTokenRequestAttributeHandler requestAttributeHandler = new CsrfTokenRequestAttributeHandler();
        requestAttributeHandler.setCsrfRequestAttributeName("_csrf");

        http.securityContext().requireExplicitSave(false).
                and().sessionManagement((session)->session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)) //It tells springsecurity to create JssesionId while initial login using session management and send it back to UI application
                .cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration corsConfiguration = new CorsConfiguration();
                        corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
                        corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
                        corsConfiguration.setAllowCredentials(true);
                        corsConfiguration.setMaxAge(3600L);
                        return corsConfiguration;
                    }
                }).and()
                .csrf((csrf)->csrf.csrfTokenRequestHandler(requestAttributeHandler).ignoringRequestMatchers("/contact","/register")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))//It will generate csrf token
                        .addFilterAfter(new CsrfCookieFilter(),BasicAuthenticationFilter.class)//CsrfCookieFilter will add csrf token to response header after basic authentication completed.
                .authorizeHttpRequests()
//                .requestMatchers("/account").hasAuthority("VIEWACCOUNT")
//                .requestMatchers("/balance").hasAnyAuthority("VIEWACCOUNT","VIEWBALANCE")
//                .requestMatchers("/cards").hasAuthority("VIEWCARDS")
//                .requestMatchers("/loans").hasAuthority("VIEWLOANS")

                //Configuring Roles and removed authorities
                //In Database, save roles with prefix ROLE as a spring standard. For e.g: ROLE_USER, ROLE_ADMIN
                .requestMatchers("/account").hasRole("USER")
                .requestMatchers("/balance").hasAnyRole("USER","ADMIN")
                .requestMatchers("/cards").hasRole("USER")
                .requestMatchers("/loans").hasRole("USER")
                .requestMatchers("/user").authenticated()
                .requestMatchers("/contact","/notices","/register").permitAll()
        .and().formLogin()
        .and().httpBasic();
        return (SecurityFilterChain)http.build();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

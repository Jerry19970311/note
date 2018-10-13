package com.example.note.server.config;

import com.example.note.server.controller.service.UserDetailServiceImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Setter(onMethod = @__({@Autowired}))
    private UserDetailServiceImpl userDetailService;
    @Setter(onMethod = @__({@Autowired}))
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void configure(WebSecurity web) throws Exception {

    }

    @Override
    public void configure(HttpSecurity http) {

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder);
    }
}

package com.example.note.server.config;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Setter(onMethod = @__({@Autowired}))
    private BCryptPasswordEncoder passwordEncoder;
    @Setter(onMethod = @__({@Autowired}))
    private DataSource dataSource;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.debug(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").anonymous()
                .antMatchers("/example").authenticated()
                .and()
                .csrf().disable()
                .formLogin()
                //TODO: change form login url.
                .loginProcessingUrl("/")
                //TODO: Set userNameParameter here.
                .usernameParameter("")
                //TODO: Set passwordParameter here.
                .passwordParameter("")
                .and()
                .logout()
                //TODO: change logout url
                .logoutUrl("/logout")
                //TODO: change logout success url
                .logoutSuccessUrl("/")
        ;
    }

    // Custom SQL here
    // TODO: Complete SQL.
    @Bean
    public JdbcUserDetailsManager userDetailsManager() {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
        userDetailsManager.setDataSource(dataSource);

        return userDetailsManager;
    }

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsManager())
                .passwordEncoder(passwordEncoder);
    }
}

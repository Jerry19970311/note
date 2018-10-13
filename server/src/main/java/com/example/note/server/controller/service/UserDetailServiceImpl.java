package com.example.note.server.controller.service;

import com.example.note.server.model.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailServiceImpl implements UserDetailsService {
    @Setter(onMethod = @__({@Autowired}))
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        String user = userRepository.getPasswordByEmail(email);
        if (user.equals("")) {
            throw new UsernameNotFoundException("User cannot found");
        }
        User.UserBuilder builder = User.withUsername(email);
        builder.password(userRepository.getPasswordByEmail(email));
        builder.roles(userRepository.getRoleByEmail(email).toString());
        return builder.build();
    }
}

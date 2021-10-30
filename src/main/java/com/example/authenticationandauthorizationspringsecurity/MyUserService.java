package com.example.authenticationandauthorizationspringsecurity;

import com.example.authenticationandauthorizationspringsecurity.Repository.UserRepository;
import com.example.authenticationandauthorizationspringsecurity.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserService implements UserDetailsService {
    @Autowired
    //here the class makes use of userRepository instance
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new com.example.authenticationandauthorizationspringsecurity.models.UserDetails(user);
    }
}

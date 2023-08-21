package com.socialmedia.project.service;

import com.socialmedia.project.model.User;
import com.socialmedia.project.repo.UserRepository;
import com.socialmedia.project.security.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service// не нужен??
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String login) {
        return this.userRepository.findByUsername(login);
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User person = findByUsername(s);

        if (person == null)
            throw new UsernameNotFoundException("User not found");

        return new UserDetails(person);
    }
}
package com.boppo.user.codingtask.userdetails;

import com.boppo.user.codingtask.entity.User;
import com.boppo.user.codingtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailId(username);
        if(user == null) throw new UsernameNotFoundException("User with "+ username + " not found.");

        return new CustomUserDetails(user);
    }
}

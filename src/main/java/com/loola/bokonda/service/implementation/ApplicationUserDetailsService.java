/*
package com.loola.bokonda.service.implementation;

import com.loola.bokonda.model.User;
import com.loola.bokonda.repository.UserRepository;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Collections;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(()->
                new EntityNotFoundException("User not founded with this email",))
        return new User("", "", Collections.emptyList());
    }
}
*/

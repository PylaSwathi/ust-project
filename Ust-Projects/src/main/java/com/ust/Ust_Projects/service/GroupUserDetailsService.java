package com.ust.Ust_Projects.service;

import com.ust.Ust_Projects.model.Person;
import com.ust.Ust_Projects.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupUserDetailsService implements UserDetailsService {
    @Autowired
    private PersonRepo personRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
        {
          Optional<Person> user = personRepo.findByUsername(username);
          return user.map(GroupUserDetails::new)
                  .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        }

}

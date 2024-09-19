package com.ust.Ust_Projects.controller;

import com.ust.Ust_Projects.common.PersonConstant;
import com.ust.Ust_Projects.model.Person;
import com.ust.Ust_Projects.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepo repo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerPerson(@RequestBody Person person) {
//        person.setRoles(PersonConstant.DEFAULT_ROLE)
        String encodedPassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encodedPassword);
        repo.save(person);
        return "hi "+person.getUsername()+" registration successful";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Secured("ROLE_ADMIN")
    @GetMapping("/getAllPersons")
    public List<Person> getAllPersons() {
        return repo.findAll();
    }



}

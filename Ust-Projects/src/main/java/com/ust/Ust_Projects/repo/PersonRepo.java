package com.ust.Ust_Projects.repo;

import com.ust.Ust_Projects.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person,Integer> {
    Optional<Person> findByUsername(String username);
}

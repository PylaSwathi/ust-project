package com.ust.Ust_Projects.repo;

import com.ust.Ust_Projects.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project,Integer> {
}

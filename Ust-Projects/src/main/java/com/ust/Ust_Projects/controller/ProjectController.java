package com.ust.Ust_Projects.controller;

import com.ust.Ust_Projects.common.PersonConstant;
import com.ust.Ust_Projects.model.Project;
import com.ust.Ust_Projects.model.ProjectStatus;
import com.ust.Ust_Projects.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/projects")
public class ProjectController {


    @Autowired
    public ProjectRepo repo;


    @PostMapping("/addProject")
    public String addProject(@RequestBody Project project, Principal principal) {
        project.setProjectStatus(ProjectStatus.INPROGRESS);
        System.out.println("principal "+ principal);
        project.setUsername(principal.getName());
        repo.save(project);
        return principal.getName() + " Your post published successfully , Required ADMIN/MODERATOR Action !";


    }
@PreAuthorize("hasAuthority('ROLE_ADMIN') OR hasAuthority('ROLE_MODERATOR')")
    @GetMapping("/approveAl")
    public String approveAl(){
        repo.findAll().stream()
                .filter(pr -> pr.getProjectStatus().equals(ProjectStatus.INPROGRESS))
                .forEach(pr ->{
                    pr.setProjectStatus(ProjectStatus.COMPLETED);
                    repo.save(pr);

                });
        return "All projects are approved";

    }









}

package com.ust.Ust_Projects.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="project")
public class Project {
    @Id
    private int projectId;
    private String psnumber;
    private String username;
    private String projectName;
    private String projectDescription;
    private String projectLink;
    @Enumerated(value = EnumType.STRING)
    private ProjectStatus projectStatus;
}

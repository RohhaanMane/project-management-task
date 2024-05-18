package com.app.projectmanagement.controller;


import com.app.projectmanagement.dto.ProjectRequestDto;
import com.app.projectmanagement.model.Project;
import com.app.projectmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    // Add new Project
    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody ProjectRequestDto projectDTO){
        Project savedProject = projectService.addProject(projectDTO);
        return ResponseEntity.ok(savedProject);
    }
    // Retrive All projects

    // Retrive project by Id

    // Update Existing Project by id

    // Delete Project by Id
}


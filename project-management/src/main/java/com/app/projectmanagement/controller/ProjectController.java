package com.app.projectmanagement.controller;


import com.app.projectmanagement.dto.ProjectRequestDto;
import com.app.projectmanagement.dto.ProjectResponseDto;
import com.app.projectmanagement.model.Project;
import com.app.projectmanagement.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Add new Project
    @PostMapping
    public ResponseEntity<ProjectResponseDto> addProject(@RequestBody @Valid ProjectRequestDto projectDTO) {
        ProjectResponseDto savedProject = projectService.addProject(projectDTO);
        return ResponseEntity.ok(savedProject);
    }

    // Retrive All projects
    @GetMapping
    public ResponseEntity<List<ProjectResponseDto>> getAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    // Retrive project by Id
    @GetMapping("/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable Long id) {
        return new ResponseEntity<>(projectService.getProjectById(id), HttpStatus.OK);
    }

    // Update Existing Project by id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Long id, @RequestBody ProjectRequestDto projectRequestDto) {
        return new ResponseEntity<>(projectService.updateProject(id, projectRequestDto), HttpStatus.OK);
    }

    // Delete Project by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        return new ResponseEntity<>(projectService.deleteProject(id), HttpStatus.OK);
    }
}


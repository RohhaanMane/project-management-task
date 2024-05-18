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
    public ResponseEntity<ProjectResponseDto> addProject(@RequestBody @Valid ProjectRequestDto projectDTO){
        ProjectResponseDto savedProject = projectService.addProject(projectDTO);
        return ResponseEntity.ok(savedProject);
    }
    // Retrive All projects
    @GetMapping
    public ResponseEntity<List<ProjectResponseDto>> getAllProjects(){
        try {

            return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Retrive project by Id
    @GetMapping("/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable Long id){
        try{
            return new ResponseEntity<>(projectService.getProjectById(id), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update Existing Project by id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Long id, @RequestBody ProjectRequestDto projectRequestDto){
        try{
            return new ResponseEntity<>(projectService.updateProject(id, projectRequestDto), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete Project by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id){
        try{

            return new ResponseEntity<>(projectService.deleteProject(id), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


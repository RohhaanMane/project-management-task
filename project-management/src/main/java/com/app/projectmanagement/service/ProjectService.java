package com.app.projectmanagement.service;

import com.app.projectmanagement.dto.ProjectRequestDto;
import com.app.projectmanagement.dto.ProjectResponseDto;
import com.app.projectmanagement.model.Project;

import java.util.List;

public interface ProjectService {
    ProjectResponseDto addProject(ProjectRequestDto projectRequestDto);
    List<ProjectResponseDto> getAllProjects();

    ProjectResponseDto getProjectById(Long id);

    ProjectResponseDto updateProject(Long id, ProjectRequestDto projectRequestDto);

    String deleteProject(Long id);

}

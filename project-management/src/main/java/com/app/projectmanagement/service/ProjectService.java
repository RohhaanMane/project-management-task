package com.app.projectmanagement.service;

import com.app.projectmanagement.dto.ProjectRequestDto;
import com.app.projectmanagement.model.Project;

public interface ProjectService {
    Project addProject(ProjectRequestDto projectRequestDto);
}

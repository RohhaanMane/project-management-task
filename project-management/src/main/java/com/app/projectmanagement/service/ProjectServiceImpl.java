package com.app.projectmanagement.service;
import com.app.projectmanagement.dto.ProjectRequestDto;
import com.app.projectmanagement.model.Project;
import com.app.projectmanagement.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Project addProject(ProjectRequestDto projectDTO) {
        Project project = projectRepository.save(modelMapper.map(projectDTO, Project.class));


        return project;
    }
}

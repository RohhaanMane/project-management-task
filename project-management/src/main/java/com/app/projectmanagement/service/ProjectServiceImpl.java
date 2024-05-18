package com.app.projectmanagement.service;

import com.app.projectmanagement.custom_exceptions.ResourseNotFoundException;
import com.app.projectmanagement.dto.ProjectRequestDto;
import com.app.projectmanagement.dto.ProjectResponseDto;
import com.app.projectmanagement.model.Project;
import com.app.projectmanagement.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProjectResponseDto addProject(ProjectRequestDto projectDTO) {
        Project project = projectRepository.save(modelMapper.map(projectDTO, Project.class));
        return modelMapper.map(project, ProjectResponseDto.class);
    }

    @Override
    public List<ProjectResponseDto> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(project -> modelMapper.map(project, ProjectResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponseDto getProjectById(Long id) {
        Project project = projectRepository.findById(id).get();
        return modelMapper.map(project, ProjectResponseDto.class);

//        Optional<Project> project = projectRepository.findById(id);
//        if(project.isPresent()){
//            return modelMapper.map(project.get(), ProjectResponseDto.class);
//        }
//        return null;
    }

    @Override
    public ProjectResponseDto updateProject(Long id, ProjectRequestDto projectRequestDto) {
        Optional<Project> projectData = projectRepository.findById(id);
        if (projectData.isPresent()) {
            Project updatedProject = projectData.get();
            updatedProject.setName(projectRequestDto.getName());
            updatedProject.setDescription(projectRequestDto.getDescription());
            updatedProject.setStartDate(projectRequestDto.getStartDate());
            updatedProject.setEndDate(projectRequestDto.getEndDate());

            ProjectResponseDto projRespObj = modelMapper.map(projectRepository.save(updatedProject), ProjectResponseDto.class);
            return projRespObj;
        } else {
            throw new ResourseNotFoundException("Project Id is Invalid");
        }
    }

    @Override
    public String deleteProject(Long id) {
        Project project = projectRepository.findById(id).get();
        projectRepository.deleteById(id);
        return "Project with Id" + id + " deleted Successfully";
    }
}

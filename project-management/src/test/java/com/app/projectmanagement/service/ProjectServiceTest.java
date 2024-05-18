package com.app.projectmanagement.service;

import com.app.projectmanagement.dto.ProjectRequestDto;
import com.app.projectmanagement.dto.ProjectResponseDto;
import com.app.projectmanagement.model.Project;
import com.app.projectmanagement.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProjectServiceTest {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ModelMapper modelMapper;

    private Project project1;
    private ProjectRequestDto projectRequestDto1;
    private ProjectResponseDto projectResponseDto1;

    @Test
    public void testAddProject() {
        // Save project directly (assuming in-memory database for testing)
        projectRepository.save(project1);

        ProjectResponseDto response = projectService.addProject(projectRequestDto1);


        assertNotNull(response);
        assertEquals(projectResponseDto1.getId(), response.getId());
        assertEquals(projectResponseDto1.getName(), response.getName());
        assertEquals(projectResponseDto1.getDescription(), response.getDescription());

        projectRepository.deleteById(project1.getId());
    }

    @Test
    public void testGetAllProjects() {
        List<Project> projects = Arrays.asList(project1, new Project("Another Project", "Another description", null, null));
        projectRepository.saveAll(projects);

        List<ProjectResponseDto> response = projectService.getAllProjects();

        assertEquals(2, response.size());
        assertEquals(projectResponseDto1.getId(), response.get(0).getId());
        assertEquals(projectResponseDto1.getName(), response.get(0).getName());

        projectRepository.deleteAll();
    }

    @Test
    public void testGetProjectById() {
        projectRepository.save(project1);

        ProjectResponseDto response = projectService.getProjectById(project1.getId());

        assertNotNull(response);
        assertEquals(projectResponseDto1.getId(), response.getId());
        assertEquals(projectResponseDto1.getName(), response.getName());

        projectRepository.deleteById(project1.getId());
    }

    @Test
    public void testUpdateProject() {
        projectRepository.save(project1);
        Project updatedProject = new Project("Updated Project", "Updated description", null, null);

        // Modify project directly (assuming in-memory database)
        project1.setName(updatedProject.getName());
        project1.setDescription(updatedProject.getDescription());
        projectRepository.save(project1);

        ProjectRequestDto updateDto = new ProjectRequestDto("Updated Project", "Updated description", null, null);
        ProjectResponseDto response = projectService.updateProject(project1.getId(), updateDto);

        assertNotNull(response);
        assertEquals("Updated Project", response.getName());
        assertEquals("Updated description", response.getDescription());

        projectRepository.deleteById(project1.getId());
    }

    @Test
    public void testDeleteProject() {
        projectRepository.save(project1);

        String response = projectService.deleteProject(project1.getId());

        assertEquals("Project with Id" + project1.getId() + " deleted Successfully", response);
        assertEquals(Optional.empty(), projectRepository.findById(project1.getId()));
    }
}

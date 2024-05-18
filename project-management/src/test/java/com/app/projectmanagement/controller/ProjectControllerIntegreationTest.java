package com.app.projectmanagement.controller;

import com.app.projectmanagement.dto.ProjectRequestDto;
import com.app.projectmanagement.dto.ProjectResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectControllerIntegreationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl = "http://localhost:";

    @LocalServerPort
    private int port;

    @Test
    public void testAddProject() throws Exception {
        ProjectRequestDto projectDTO = new ProjectRequestDto("Test Project", "Test Description", null, null);

        String url = baseUrl + port + "/projects";
        ResponseEntity<ProjectResponseDto> response = restTemplate.postForEntity(url, projectDTO, ProjectResponseDto.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody().getId());
        assertEquals(projectDTO.getName(), response.getBody().getName());
    }

    @Test
    public void testGetProjectById() throws Exception {
        Long projectId = 1L;
        String url = baseUrl + port + "/projects/" + projectId;
        ResponseEntity<ProjectResponseDto> response = restTemplate.getForEntity(url, ProjectResponseDto.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}

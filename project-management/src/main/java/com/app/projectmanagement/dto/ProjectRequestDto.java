package com.app.projectmanagement.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Valid
public class ProjectRequestDto {
    @NotBlank(message = "Project name is mandatory")
    private String name;
    @NotBlank(message = "Project description is mandatory")
    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;
    @PastOrPresent(message = "Start date cannot be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @Future(message = "End date can be present or future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
}

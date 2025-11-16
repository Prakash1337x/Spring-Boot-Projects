package com.project.todoapp.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Todo
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull
    @NotBlank
    @Schema(name = "title", example = "Spring Boot")
    private String title;
    @NotNull
    @NotBlank
    @Schema(name = "description", example = "A simple Spring Boot To-Do app")
    private String description;
    @Schema(name = "complete", example = "true")
    private boolean complete;
}

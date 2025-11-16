package com.example.demo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.http.HttpStatusCode;

//@Size(min = 10, max = 20)
//@Pattern(regexp = ) //
//@Min(20)
//@Max(30)
//@Getter
//@Setter
//@AllArgsConstructor // select all fields
//@NoArgsConstructor // select no field
//@Schema(name = "title", example = "Spring") // denoted as a sample input

@Entity // mark the class as table
@Data
public class Todo
{
    @Id // mark as an primary key
    @GeneratedValue // Auto Generated
    Long id;
    @NotBlank
    @Schema(name = "title", example = "Spring")
    String title;
    @Schema(name = "complete", example = "true")
    boolean complete;
//    @NotBlank
//    @Schema(name = "description", example = "Spring Boot")
//    String description;
//    @Email
//    @Schema(name = "email", example = "sample123@gmail.com")
//    String email;
}

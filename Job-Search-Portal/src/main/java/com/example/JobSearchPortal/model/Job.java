package com.example.JobSearchPortal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Job")
public class Job {

    @Id
    private Long id;
    private String title;
    private String description;
    private String location;

    @Min(value = 20000)
    private Double salary;

    @Email
    private String companyEmail;

    private String companyName;
    private String employerName;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private LocalDate appliedDate;
}

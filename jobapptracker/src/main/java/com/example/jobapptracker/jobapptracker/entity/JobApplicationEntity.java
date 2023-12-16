package com.example.jobapptracker.jobapptracker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "applications")
public class JobApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String postingTitle;
    private String submissionDate;
    private String postingUrl;
    private String companyName;
    private String result;


}

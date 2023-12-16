package com.example.jobapptracker.jobapptracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApplication {
    private long id;
    private String postingTitle;
    private String submissionDate;
    private String postingUrl;
    private String companyName;
    private String result;
}

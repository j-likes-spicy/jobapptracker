package com.example.jobapptracker.jobapptracker.services;

import com.example.jobapptracker.jobapptracker.model.JobApplication;

import java.util.List;

public interface JobApplicationService {
   JobApplication createJobApplication(JobApplication jobApplication);

   List<JobApplication> getAllJobApplications();

   boolean deleteJobApplication(Long id);

   JobApplication getJobApplicationById(Long id);

   JobApplication updateJobApplication(Long id, JobApplication jobApplication);
}

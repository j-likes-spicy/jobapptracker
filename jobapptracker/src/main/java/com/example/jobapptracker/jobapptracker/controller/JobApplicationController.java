package com.example.jobapptracker.jobapptracker.controller;

import com.example.jobapptracker.jobapptracker.model.JobApplication;
import com.example.jobapptracker.jobapptracker.services.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/main/api")
public class JobApplicationController {
    @Autowired
    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping("/applications")
    public JobApplication createJobApplication(@RequestBody JobApplication jobApplication) {
        return jobApplicationService.createJobApplication(jobApplication);
    }

    @GetMapping("/applications")
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationService.getAllJobApplications();
    }

    @DeleteMapping("/applications/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteJobApplication(@PathVariable Long id) {
        boolean deleted = false;
        deleted = jobApplicationService.deleteJobApplication(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<JobApplication> getJobApplicationById(@PathVariable Long id) {
        JobApplication jobApplication = null;
        jobApplication = jobApplicationService.getJobApplicationById(id);
        return ResponseEntity.ok(jobApplication);
    }

    @PutMapping("/applications/{id}")
    public ResponseEntity<JobApplication>
            updateJobApplication(@PathVariable Long id, @RequestBody JobApplication jobApplication) {
        jobApplication = jobApplicationService.updateJobApplication(id, jobApplication);
        return ResponseEntity.ok(jobApplication);
    }
}

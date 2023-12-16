package com.example.jobapptracker.jobapptracker.services;

import com.example.jobapptracker.jobapptracker.entity.JobApplicationEntity;
import com.example.jobapptracker.jobapptracker.model.JobApplication;
import com.example.jobapptracker.jobapptracker.repository.JobApplicationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    private JobApplicationRepository jobApplicationRepository;

    public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    public JobApplication createJobApplication(JobApplication jobApplication) {
        JobApplicationEntity jobApplicationEntity = new JobApplicationEntity();

        BeanUtils.copyProperties(jobApplication, jobApplicationEntity);
        jobApplicationRepository.save(jobApplicationEntity);
        return jobApplication;
    }

    @Override
    public List<JobApplication> getAllJobApplications() {
        List<JobApplicationEntity> jobApplicationEntities = jobApplicationRepository.findAll();

        List<JobApplication> jobApplications = jobApplicationEntities
                .stream().map(job -> new JobApplication(
                        job.getId(),
                        job.getPostingTitle(),
                        job.getSubmissionDate(),
                        job.getPostingUrl(),
                        job.getCompanyName(),
                        job.getResult()))
                .collect(Collectors.toList());
        return jobApplications;
    }

    @Override
    public boolean deleteJobApplication(Long id) {
        JobApplicationEntity jobApplication = jobApplicationRepository.findById(id).get();
        jobApplicationRepository.delete(jobApplication);
        return true;
    }

    @Override
    public JobApplication getJobApplicationById(Long id) {
        JobApplicationEntity jobApplicationEntity = jobApplicationRepository.findById(id).get();
        JobApplication jobApplication = new JobApplication();
        BeanUtils.copyProperties(jobApplicationEntity, jobApplication);
        return jobApplication;
    }

    @Override
    public JobApplication updateJobApplication(Long id, JobApplication jobApplication) {
        JobApplicationEntity jobApplicationEntity = jobApplicationRepository.findById(id).get();
        jobApplicationEntity.setSubmissionDate(jobApplication.getSubmissionDate());
        jobApplicationEntity.setPostingUrl(jobApplication.getPostingUrl());
        jobApplicationEntity.setCompanyName(jobApplication.getCompanyName());
        jobApplicationEntity.setResult(jobApplication.getResult());

        jobApplicationRepository.save(jobApplicationEntity);
        return jobApplication;

    }
}

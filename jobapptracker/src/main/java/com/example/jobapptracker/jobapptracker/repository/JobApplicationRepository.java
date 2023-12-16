package com.example.jobapptracker.jobapptracker.repository;

import com.example.jobapptracker.jobapptracker.entity.JobApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplicationEntity, Long> {
}

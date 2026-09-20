package com.example.job.Repository;

import com.example.job.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<Job,Integer> {

    Job findJobById(Integer id);












}

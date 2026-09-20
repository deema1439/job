package com.example.job.Service;

import com.example.job.Model.Job;
import com.example.job.Repository.JobApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplictionService {
    private final JobApplicationRepository jobApplicationRepository;

    public List<Job>getJobs(){
        return jobApplicationRepository.findAll();
    }

    public void addJobs(Job job){
        jobApplicationRepository.save(job);
    }

    public boolean updateJob(Integer id,Job job){
        Job oldJob=jobApplicationRepository.findJobById(id);
        if(oldJob==null){
            return false;
        }
        oldJob.setJobPostId(job.getJobPostId());
        oldJob.setUserId(job.getUserId());
        jobApplicationRepository.save(oldJob);
        return true;
    }


    public boolean deleteJob(Integer id){
        Job oldJob=jobApplicationRepository.findJobById(id);
        if(oldJob==null){
            return false;
        }
        jobApplicationRepository.delete(oldJob);
        return true;
    }

















}

package com.example.job.Service;


import com.example.job.Model.JobPost;
import com.example.job.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {
 private final JobPostRepository jobPostRepository;

 public List<JobPost>getJobPosts(){
     return jobPostRepository.findAll();
 }



 public void addPostJob(JobPost jobPost){
     jobPostRepository.save(jobPost);
 }


 public boolean updatePostJob(Integer id, JobPost jobPost){
     JobPost oldPostJob=jobPostRepository.findJobPostsById(id);

     if(oldPostJob==null){
         return false;
     }
     oldPostJob.setDescription(jobPost.getDescription());
     oldPostJob.setLocation(jobPost.getLocation());
     oldPostJob.setPostingDate(jobPost.getPostingDate());
     oldPostJob.setSalary(jobPost.getSalary());
     oldPostJob.setTitle(jobPost.getTitle());
     jobPostRepository.save(oldPostJob);
     return true;
 }


 public boolean deletePostJob(Integer id){
     JobPost findJobPostsById=jobPostRepository.findJobPostsById(id);
     if(findJobPostsById==null){
         return false;
     }
     jobPostRepository.delete(findJobPostsById);
     return true;
 }
















}

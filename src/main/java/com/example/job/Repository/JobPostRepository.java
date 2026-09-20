package com.example.job.Repository;

import com.example.job.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost,Integer> {

JobPost findJobPostsById(Integer id);


}

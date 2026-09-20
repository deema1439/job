package com.example.job.Controller;

import com.example.job.Api.ApiResponse;
import com.example.job.Model.JobPost;
import com.example.job.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobpost")
@RequiredArgsConstructor
public class JobPostController {

    private final JobPostService jobPostService;

    @GetMapping("/get")
    ResponseEntity<?>gatJobPost(){
        List<JobPost>getJobPosts=jobPostService.getJobPosts();
        return ResponseEntity.status(200).body(getJobPosts);
    }


    @PostMapping("/add")
    ResponseEntity<?>addJobPost(@Valid @RequestBody JobPost jobPost, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobPostService.addPostJob(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("jobPost Has Been Added"));

    }

    @PutMapping("/update/{id}")
    ResponseEntity<?>updateJobPost(@PathVariable Integer id,@RequestBody @Valid JobPost jobPost,Errors errors ){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean updatePostJob=jobPostService.updatePostJob(id,jobPost);

        if(!updatePostJob){
            return ResponseEntity.status(400).body(new ApiResponse("id not found"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("Job Post Has Been Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteJobPost(@PathVariable Integer id){
        boolean deletePostJob=jobPostService.deletePostJob(id);
        if(!deletePostJob){
            return ResponseEntity.status(400).body(new ApiResponse("id not found"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("job post has been deleted"));
    }















}

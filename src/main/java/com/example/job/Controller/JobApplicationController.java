package com.example.job.Controller;

import com.example.job.Api.ApiResponse;
import com.example.job.Model.Job;
import com.example.job.Service.JobApplictionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/job")
public class JobApplicationController {

    private final JobApplictionService jobApplictionService;

    @GetMapping("/get")
    public ResponseEntity<?>getJobs(){
        List<Job> getJobs=jobApplictionService.getJobs();
        return ResponseEntity.status(200).body(getJobs);
    }

    @PostMapping("/add")
    public ResponseEntity<?>addJobs(@RequestBody @Valid Job job, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobApplictionService.addJobs(job);
        return ResponseEntity.status(200).body(new ApiResponse("job has been added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateJob(@PathVariable Integer id,@RequestBody @Valid Job job,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean updateJob=jobApplictionService.updateJob(id,job);
        if(!updateJob){
            return ResponseEntity.status(400).body(new ApiResponse("id Not Found"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("Job Has Been Updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable Integer id) {
        boolean deleteJob = jobApplictionService.deleteJob(id);
        if (!deleteJob) {
            return ResponseEntity.status(400).body(new ApiResponse("Job Id Not Found"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("job has been deleted "));


    }

}

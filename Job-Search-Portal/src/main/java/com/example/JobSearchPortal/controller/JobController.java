package com.example.JobSearchPortal.controller;

import com.example.JobSearchPortal.model.Job;
import com.example.JobSearchPortal.model.JobType;
import com.example.JobSearchPortal.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class JobController {
    @Autowired
    JobService jobService;

    @PostMapping("jobs")
    public String addJobs(@RequestBody @Valid List<Job> job){
        return jobService.addJobs(job);
    }
    @PostMapping("job")
    public String addJob(@RequestBody @Valid Job job){
        return jobService.addJob(job);
    }

    @GetMapping("jobs")
    public Iterable<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @PutMapping("job/{id}/{jobType}")
    public String updateJobTypeById(@PathVariable Long id,@PathVariable JobType jobType){
        return jobService.updateJobTypeById(id,jobType);
    }

    @DeleteMapping("job/{id}")
    public String deleteJobById(@PathVariable Long id){
        return jobService.deleteJobById(id);
    }


    //get all jobs by description
    @GetMapping("jobs/description/{description}")
    public List<Job> getAllJobsByDescription(@PathVariable String description){
        return jobService.getAllJobsByDescription(description);
    }

    //get all jobs by location
    @GetMapping("jobs/location/{location}")
    public List<Job> getAllJobsByLocation(@PathVariable String location){
        return jobService.getAllJobsByLocation(location);
    }

   //get all jobs by location
    @GetMapping("jobs/title/{title}")
    public List<Job> getAllJobsByTitle(@PathVariable String title){
        return jobService.getAllJobsByTitle(title);
    }
    //get all jobs by Job Type
    @GetMapping("job/jobType/{jobType}")
    public List<Job> getAllJobByType(@PathVariable JobType jobType){
        return jobService.getAllJobByType(jobType);
    }

    //get job by id
    @GetMapping("job/{id}")
    public Job getJobById(@PathVariable Integer id){
        return jobService.getRoomById(id);
    }



    //update job by company Name
    @PutMapping("jobUpdate/{id}/{companyName}")
    public void updateJobByCompanyName(@PathVariable Long id,@PathVariable String companyName){
         jobService.updateJobByCompanyName(id,companyName);
    }

    //update job by Employer Name
    @PutMapping("jobUpdate/employerName/{id}/{employerName}")
    public void updateJobByEmployerName(@PathVariable Long id,@PathVariable String employerName){
        jobService.updateJobByEmployerName(id,employerName);
    }

    //delete job Info by Id
    @DeleteMapping("job/id/{id}")
    public String deleteAllInfoOfJobById(@PathVariable Long id){
        return jobService.deleteAllInfoOfJobById(id);
    }

}

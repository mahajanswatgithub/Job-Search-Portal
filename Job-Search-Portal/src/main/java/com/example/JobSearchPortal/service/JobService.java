package com.example.JobSearchPortal.service;

import com.example.JobSearchPortal.model.Job;
import com.example.JobSearchPortal.model.JobType;
import com.example.JobSearchPortal.repository.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    IJobRepo jobRepo;

    public String addJobs(List<Job> job) {
        jobRepo.saveAll(job);
        return "Jobs Are Added";
    }
    public String addJob(Job job) {
        jobRepo.save(job);
        return "Job Is Added";
    }

    public Iterable<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    public String updateJobTypeById(Long id, JobType jobType) {

        Optional<Job> job = jobRepo.findById(id);

        Job j = null;
        if(job.isPresent())
        {
            j = job.get();
        }
        else {
            return "Id not Found!!!";
        }
        j.setJobType(jobType);
        jobRepo.save(j);
        return "Job type updated";
    }

    public String deleteJobById(Long id) {
        jobRepo.deleteById(id);
        return "Job Deleted Successfully";
    }


    public List<Job> getAllJobsByDescription(String description) {
        return jobRepo.findJobsByDescription(description);
    }

    public List<Job> getAllJobsByLocation(String location) {
        return jobRepo.findJobsByLocation(location);
    }

    public List<Job> getAllJobsByTitle(String title) {
        return jobRepo.findJobsByTitle(title);
    }
    public List<Job> getAllJobByType(JobType jobType) {
        return jobRepo.findJobsByJobType(jobType);
    }

    public Job getRoomById(Integer id) {
        return jobRepo.getAllJobById(id);
    }

    public void updateJobByCompanyName(Long id,String companyName) {
         jobRepo.updateJobByCompanyName(id,companyName);
    }

    public void updateJobByEmployerName(Long id, String employerName) {
        jobRepo.updateJobByEmployerName(id,employerName);
    }

    public String deleteAllInfoOfJobById(Long id) {
        jobRepo.deleteAllInfoOfJobById(id);
        return "Job Info Deleted Successfully";
    }


}

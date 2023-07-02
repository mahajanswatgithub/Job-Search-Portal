package com.example.JobSearchPortal.repository;

import com.example.JobSearchPortal.model.Job;
import com.example.JobSearchPortal.model.JobType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job,Long> {
    List<Job> findJobsByDescription(String description);

    List<Job> findJobsByLocation(String location);

    List<Job> findJobsByTitle(String title);

    List<Job> findJobsByJobType(JobType jobType);

    @Query(value = "select * from Job where id = :id" , nativeQuery = true)
    Job getAllJobById(Integer id);


    @Modifying
    @Transactional
    @Query(value = "update Job set Company_Name = :companyName where id = :id" , nativeQuery = true)
    void updateJobByCompanyName(Long id,String companyName);


    @Modifying
    @Transactional
    @Query(value = "update Job set Employer_Name = :employerName where id = :id" , nativeQuery = true)
    void updateJobByEmployerName(Long id, String employerName);

    @Modifying
    @Transactional
    @Query(value = "delete from Job where id = :id" , nativeQuery = true)
    void deleteAllInfoOfJobById(Long id);



}

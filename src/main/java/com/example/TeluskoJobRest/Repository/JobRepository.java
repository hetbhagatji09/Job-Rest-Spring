package com.example.TeluskoJobRest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TeluskoJobRest.model.JobPost;

@Repository
public interface JobRepository extends JpaRepository<JobPost,Integer> {

    List<JobPost>findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);


}
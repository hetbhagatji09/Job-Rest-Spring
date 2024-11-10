package com.example.TeluskoJobRest.Controller;


import com.example.TeluskoJobRest.Services.JobService;
import com.example.TeluskoJobRest.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService jobService;

    @GetMapping("/jobposts")

    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();

    }
    @GetMapping("/jobpost/{id}")
    public JobPost getPost(@PathVariable int id){
        return jobService.getJob(id);

    }
    @PostMapping("/jobpost")
    public void addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);

    }
    @PutMapping("/jobpost")
    public void updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);

    }
    @DeleteMapping("jobpost/{id}")
    public void deleteJob(@PathVariable int id){
        jobService.deleteJob(id);
    }
    @GetMapping("/jobposts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable String keyword){
        return jobService.search(keyword);
    }
    @GetMapping("/load")
    public void loadData(){
        jobService.load();

    }


}

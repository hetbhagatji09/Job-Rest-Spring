package com.example.TeluskoJobRest.Services;

import com.example.TeluskoJobRest.Repository.JobRepository;
import com.example.TeluskoJobRest.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;
    public void addJob(JobPost jobPost){
        jobRepository.save(jobPost);

    }
    public List<JobPost> getAllJobs(){
        return  jobRepository.findAll();
    }

    public JobPost getJob(int id) {
        return jobRepository.findById(id).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        jobRepository.save(jobPost);
    }

    public void deleteJob(int id) {
        jobRepository.deleteById(id);
    }

    public void load() {
        JobPost job1 = new JobPost(
                1,
                "Java Developer",
                "Responsible for developing backend services in Java.",
                3,
                Arrays.asList("Java", "Spring Boot", "Hibernate")
        );

        JobPost job2 = new JobPost(
                2,
                "Frontend Developer",
                "Develop and maintain the front-end of our web application.",
                2,
                Arrays.asList("JavaScript", "React", "CSS")
        );

        JobPost job3 = new JobPost(
                3,
                "Data Scientist",
                "Analyze data and build predictive models.",
                4,
                Arrays.asList("Python", "Machine Learning", "Pandas", "Scikit-Learn")
        );

        // Adding JobPost objects to a list
        List<JobPost> jobList = new ArrayList<>();
        jobList.add(job1);
        jobList.add(job2);
        jobList.add(job3);
        jobRepository.saveAll(jobList   );
    }

    public List<JobPost> search(String keyword) {
        return jobRepository.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}

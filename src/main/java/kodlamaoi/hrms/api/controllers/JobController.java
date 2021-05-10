package kodlamaoi.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaoi.hrms.business.abstracts.JobService;
import kodlamaoi.hrms.entities.concrete.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
	private JobService jobService;
	@Autowired
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@GetMapping("/getall")
	public List<Job> getAll(){
		return jobService.getAll();
	}
}

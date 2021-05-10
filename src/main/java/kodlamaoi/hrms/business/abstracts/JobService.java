package kodlamaoi.hrms.business.abstracts;

import java.util.List;

import kodlamaoi.hrms.entities.concrete.Job;

public interface JobService {

	List<Job> getAll();
}

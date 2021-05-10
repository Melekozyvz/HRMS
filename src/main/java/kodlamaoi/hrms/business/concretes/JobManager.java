package kodlamaoi.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaoi.hrms.business.abstracts.JobService;
import kodlamaoi.hrms.dataaccess.abstracts.JobDao;
import kodlamaoi.hrms.entities.concrete.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public List<Job> getAll() {
		return jobDao.findAll();
	}

}

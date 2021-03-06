package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concrete.Job;

public interface JobService {

	DataResult<List<Job>> getAll();
	
	public Result add(Job job);
}

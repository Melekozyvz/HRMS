package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concrete.Candidate;

public interface UserCheckService {

	Result checkRealPerson(Candidate candidate);
	
}

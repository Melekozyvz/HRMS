package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concrete.Candidate;
import kodlamaio.hrms.entities.concrete.Employer;
import kodlamaio.hrms.entities.concrete.User;

public interface AuthService {

	Result registerCandidate(Candidate candidate,String confirmPassword);
	
	Result registerEmployer(Employer employer,String confirmPassword);
}

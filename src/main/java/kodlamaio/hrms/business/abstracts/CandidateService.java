package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concrete.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateDto;

public interface CandidateService {

	DataResult<List<Candidate>> getall();
	DataResult<List<CandidateDto>> getallWithDetails();

	Result add(Candidate candidate);
	
	DataResult<Candidate> getByTcNoOrEmail(String tcNo,String email);
}

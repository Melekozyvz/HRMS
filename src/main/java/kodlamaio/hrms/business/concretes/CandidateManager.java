package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserCheckService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.messages.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataaccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concrete.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateDto;
@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserService userService;
	@Autowired
	public CandidateManager(CandidateDao candidateDao,UserService userService) {
		this.candidateDao=candidateDao;
		this.userService=userService;
	}
	@Override
	public DataResult<List<Candidate>> getall() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),Messages.candidatesListed);
	}
	@Override
	public Result add(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult(Messages.candidadeAdded);
		
	}
	@Override
	public DataResult<List<CandidateDto>> getallWithDetails(){
		return new SuccessDataResult<List<CandidateDto>>(this.candidateDao.getAllCandidatesWithDetails(),Messages.candidatesWithDetailListed);
	}
	@Override
	public DataResult<Candidate> getByTcNoOrEmail(String tcNo,String email) {
		Candidate candidate=candidateDao.getByTcNoOrUser_Email(tcNo, email);
		if (candidate==null) {
			return null;
		}
		return new SuccessDataResult<Candidate>(candidate);
	}
	
}

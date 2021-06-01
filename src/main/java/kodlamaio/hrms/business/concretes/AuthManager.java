package kodlamaio.hrms.business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserCheckService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.messages.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validation.VerificationService;
import kodlamaio.hrms.dataaccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concrete.Candidate;
import kodlamaio.hrms.entities.concrete.Employer;
import kodlamaio.hrms.entities.concrete.User;
@Service
public class AuthManager implements AuthService {

	private CandidateService candidateService;
	private VerificationService verificationService;
	private EmployerService employerService;
	private UserCheckService userCheckService;
	private UserService userService;
	@Autowired
	public AuthManager(CandidateService candidateService,UserService userService,VerificationService verificationService,EmployerService employerService,UserCheckService userCheckService) {
		this.candidateService=candidateService;
		this.userCheckService=userCheckService;
		this.verificationService=verificationService;
		this.employerService=employerService;
		this.userService=userService;
	}
	@Override
	public Result registerCandidate(Candidate candidate,String confirmPassword) {
		User user=candidate.getUser();
		Result result=BusinessRules.run(checkIfConfirmPassword(user.getPassword(), confirmPassword),isEmailValidation(user.getEmail()),checkUserExists(candidate.getTcNo(), user.getEmail()),userCheckService.checkRealPerson(candidate));
		if (result!=null) {
			return result;
		}
		
		Result verificationResult=verificationService.sendVerificationCode(user.getEmail());
		if(!verificationResult.isSuccess()) {
			return verificationResult;
		}
		this.userService.add(user);
		return this.candidateService.add(candidate);
	}
	
	private Result checkIfConfirmPassword(String password , String confirmPassword) {
		if(!password.equals(confirmPassword)) {
			return new ErrorResult("Password does not match. Please re-enter your password.");
		}
		return new SuccessResult();
	}
	public Result isEmailValidation(String email) {
	    Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	   
	    if (EMAIL_REGEX.matcher(email).matches()) {
			return new SuccessResult();
		}
	    return new ErrorResult();	    		
	}
	@Override
	public Result registerEmployer(Employer employer,String confirmPassword) {
		
		Result result= verificationService.sendVerificationCode(employer.getUser().getEmail());
		if (result.isSuccess()) {
			this.userService.add(employer.getUser());
			return this.employerService.add(employer);
		}
		return result;
	}
	public Result checkUserExists(String tcNo,String email) {
		if (candidateService.getByTcNoOrEmail(tcNo, email)==null) {
			return new SuccessResult();
		}
		return new ErrorResult(Messages.candidateAlreadyExist);
	}

}

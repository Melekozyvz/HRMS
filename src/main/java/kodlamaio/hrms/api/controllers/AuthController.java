package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.concretes.AuthManager;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concrete.Candidate;
import kodlamaio.hrms.entities.concrete.Employer;
import kodlamaio.hrms.entities.concrete.User;
import kodlamaio.hrms.entities.dtos.CandidateDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	
	private AuthManager authManager;
	
	@Autowired
	public AuthController(AuthManager authManager){
	
		this.authManager=authManager;
	}
	@PostMapping("/candidateRegister")
	public Result registerCandidate(Candidate candidate,String confirmPassword) {
			
		return authManager.registerCandidate(candidate,confirmPassword);
	
	}
	@PostMapping("/employerRegister")
	public Result registerEmployer(Employer employer,String confirmPassword) {
			
		return authManager.registerEmployer(employer,confirmPassword);
	
	}
}

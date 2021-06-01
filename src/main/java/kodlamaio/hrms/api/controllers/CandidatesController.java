package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concrete.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateDto;

@RestController
@RequestMapping("/api/candidates/")
public class CandidatesController {

	private CandidateService candidateService;
	
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		this.candidateService=candidateService;
	}
	@GetMapping("getall")
	public DataResult<List<Candidate>>  getAll(){
		return candidateService.getall();
	}
	@GetMapping("getallWithDetails")
	public DataResult<List<CandidateDto>>  getAllWithDetails(){
		return candidateService.getallWithDetails();
	}
	@GetMapping("getByTcNoOrEmail")
	public DataResult<Candidate> getByTcNoOrEmail(String tcNo,String email){
		return candidateService.getByTcNoOrEmail(tcNo, email);
	}
}

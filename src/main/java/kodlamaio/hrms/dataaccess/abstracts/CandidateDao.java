package kodlamaio.hrms.dataaccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concrete.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateDto;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	@Query("Select new kodlamaio.hrms.entities.dtos.CandidateDto(c.id,c.firstName,c.lastName,c.tcNo,c.birthDate,u.email,u.password) From Candidate c Inner Join c.user u")
	List<CandidateDto> getAllCandidatesWithDetails();

	Candidate getByTcNoOrUser_Email(String tcNo,String email);
}

package kodlamaio.hrms.dataaccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrete.Job;


public interface JobDao extends JpaRepository<Job, Integer> {

}

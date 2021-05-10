package kodlamaoi.hrms.dataaccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaoi.hrms.entities.concrete.Job;

public interface JobDao extends JpaRepository<Job, Integer> {

}

package kodlamaio.hrms.entities.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name = "job_name")
	private String jobName;
	
	
	public Job(int id, String jobName) {
		this.id = id;
		this.jobName = jobName;
	}
	public Job() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
}

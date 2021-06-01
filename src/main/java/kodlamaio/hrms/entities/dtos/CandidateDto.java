package kodlamaio.hrms.entities.dtos;

import java.util.Date;

public class CandidateDto {
	private int id;

	private String firstName;

	private String lastName;

	private String tcNo;

	private Date birthDate;

	private String email;

	private String password;

	public CandidateDto(int id, String firstName, String lastName, String tcNo, Date birthDate, String email,
			String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tcNo = tcNo;
		this.birthDate = birthDate;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTcNo() {
		return tcNo;
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

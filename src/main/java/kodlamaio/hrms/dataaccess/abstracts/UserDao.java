package kodlamaio.hrms.dataaccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrete.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User getByEmail(String email);
}

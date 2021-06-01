package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concrete.User;

public interface BaseUserCheckService {

	boolean alreadyExist(User user);
}

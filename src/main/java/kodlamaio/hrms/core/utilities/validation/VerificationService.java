package kodlamaio.hrms.core.utilities.validation;

import kodlamaio.hrms.core.utilities.results.Result;

public interface VerificationService {

	Result sendVerificationCode(String email);
}

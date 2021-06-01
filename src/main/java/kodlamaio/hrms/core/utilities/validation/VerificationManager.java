package kodlamaio.hrms.core.utilities.validation;

import java.util.UUID;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
@Service
public class VerificationManager implements VerificationService {

	@Override
	public Result sendVerificationCode(String email) {
		 UUID uuid = UUID.randomUUID();
		    String code= uuid.toString();
			System.out.println(email +" Verification code sent to address . Verification code:" + code );
			return new SuccessResult("Verification Code is Sended to "+email);
	}

}

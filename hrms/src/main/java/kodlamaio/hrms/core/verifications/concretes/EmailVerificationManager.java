package kodlamaio.hrms.core.verifications.concretes;

import kodlamaio.hrms.core.verifications.abstracts.EmailVerificationService;

public class EmailVerificationManager implements EmailVerificationService {

	@Override
	public boolean isVerifed(String email) {
		
		return true;
	}

}

package kodlamaio.hrms.core.verifications.abstracts;

public interface EmailVerificationService {

	boolean isVerifed(String email);
	
	boolean checkEmailFormat(String email);
}

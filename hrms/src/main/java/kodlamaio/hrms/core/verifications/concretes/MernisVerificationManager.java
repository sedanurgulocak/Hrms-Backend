package kodlamaio.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.verifications.abstracts.MernisVerificationService;

@Service
public class MernisVerificationManager implements MernisVerificationService{

	@Override
	public boolean checkIfRealPerson() {
		return true;
	}

	
}

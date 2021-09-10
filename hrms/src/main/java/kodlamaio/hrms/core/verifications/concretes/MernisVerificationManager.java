package kodlamaio.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.verifications.abstracts.MernisVerificationService;
import kodlamaio.hrms.entities.concretes.dtos.CandidateDto;

@Service
public class MernisVerificationManager implements MernisVerificationService{

	@Override
	public boolean checkIfRealPerson(CandidateDto candidate) {
		return true;
	}

	
}

package kodlamaio.hrms.core.verifications.abstracts;

import kodlamaio.hrms.entities.concretes.dtos.CandidateDto;

public interface MernisVerificationService {

	boolean checkIfRealPerson(CandidateDto candidateDto);
}

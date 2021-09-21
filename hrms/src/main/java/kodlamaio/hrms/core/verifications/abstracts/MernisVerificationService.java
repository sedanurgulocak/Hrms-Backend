package kodlamaio.hrms.core.verifications.abstracts;

import kodlamaio.hrms.entities.concretes.dtos.userDtos.CandidateDto;

public interface MernisVerificationService {

	boolean checkIfRealPerson(CandidateDto candidateDto);
}

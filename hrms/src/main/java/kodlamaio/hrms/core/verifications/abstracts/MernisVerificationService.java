package kodlamaio.hrms.core.verifications.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisVerificationService {

	boolean checkIfRealPerson(Candidate candidate);
}

package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.users.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{

	boolean existsCandidateByEmail(String email);
	boolean existsCandidateByNationalIdentity(String nationalIdentity);
}

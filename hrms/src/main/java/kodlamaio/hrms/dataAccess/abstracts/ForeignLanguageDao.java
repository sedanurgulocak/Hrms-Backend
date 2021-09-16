package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cvs.ForeignLanguage;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer>{

	ForeignLanguage deleteById(int id);
	
	List<ForeignLanguage> getForeignLanguageListByCandidateId(int candidateId);
	
}

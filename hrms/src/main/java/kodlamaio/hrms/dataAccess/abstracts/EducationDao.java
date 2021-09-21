package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cvs.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{

	List<Education> getEducationListByCandidateId(int candidateId);
	
	List<Education> findAllByCandidateIdOrderByEndDateDesc(int candidateId);
}

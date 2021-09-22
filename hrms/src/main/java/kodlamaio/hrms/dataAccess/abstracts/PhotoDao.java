package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cvs.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer>{
	
	Photo getByCandidateId(int candidateId);

}

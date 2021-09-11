package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cvs.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer>{

}

package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cvs.SocialLink;

public interface SocialLinkDao extends JpaRepository<SocialLink, Integer>{

	SocialLink getByCandidateId(int candidateId);
}

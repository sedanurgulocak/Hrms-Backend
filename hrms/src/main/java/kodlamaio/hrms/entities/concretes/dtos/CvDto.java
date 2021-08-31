package kodlamaio.hrms.entities.concretes.dtos;

import java.util.List;

import javax.persistence.Entity;

import kodlamaio.hrms.entities.concretes.cvs.CoverLetter;
import kodlamaio.hrms.entities.concretes.cvs.Education;
import kodlamaio.hrms.entities.concretes.cvs.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.cvs.JobExperience;
import kodlamaio.hrms.entities.concretes.cvs.Skill;
import kodlamaio.hrms.entities.concretes.cvs.SocialLink;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CvDto {
	
	private Candidate candidate;
	
	private List<Education> educations;
	
	private List<JobExperience> jobExperiences;
	
	private List<ForeignLanguage> foreignLanguages;
	
	private List<SocialLink> socialLinks;
	
	private List<Skill> skills;
	
	private CoverLetter coverLetter;
	
	

}

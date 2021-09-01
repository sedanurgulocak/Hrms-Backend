package kodlamaio.hrms.entities.concretes.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.concretes.cvs.CoverLetter;
import kodlamaio.hrms.entities.concretes.cvs.Education;
import kodlamaio.hrms.entities.concretes.cvs.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.cvs.JobExperience;
import kodlamaio.hrms.entities.concretes.cvs.Photo;
import kodlamaio.hrms.entities.concretes.cvs.Skill;
import kodlamaio.hrms.entities.concretes.cvs.SocialLink;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "educations", "jobExperiences", "foreignLanguages", "socialLinks", "skills"})
public class Candidate extends User{

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="national_identity")
	private String nationalIdentity;
	
	@Column(name="date_of_birth")
	private String dateOfBirth;
	
	@OneToMany(mappedBy="candidate")
	private List<Education> educations;
	
	@OneToMany(mappedBy="candidate")
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy="candidate")
	private List<ForeignLanguage> foreignLanguages;
	
	@OneToMany(mappedBy="candidate")
	private List<SocialLink> socialLinks;
	
	@OneToMany(mappedBy="candidate")
	private List<Skill> skills;
	
	@OneToOne(mappedBy="candidate")
	private CoverLetter coverLetter;
	
	@OneToOne(mappedBy="candidate")
	private Photo photo;
	
	
}

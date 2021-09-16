package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.JobExperienceDto;

public interface JobExperienceService {
	
	Result add(JobExperienceDto jobExperienceDto);

}

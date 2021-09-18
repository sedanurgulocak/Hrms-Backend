package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.JobExperienceDto;

public interface JobExperienceService {
	
	Result add(JobExperienceDto jobExperienceDto);
	
	DataResult<List<JobExperienceDto>> getJobExperienceListByCandidateId(int candidateId);
	
	DataResult<List<JobExperienceDto>> findAllByCandidateIdOrderByEndDateDesc(int candidateId);

}

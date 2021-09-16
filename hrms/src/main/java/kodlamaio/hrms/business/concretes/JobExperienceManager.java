package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.modelMapper.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.cvs.JobExperience;
import kodlamaio.hrms.entities.concretes.dtos.JobExperienceDto;

@Service
public class JobExperienceManager implements JobExperienceService{
	
	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Autowired
	private DtoConverterService dtoConverterService;

	@Override
	public Result add(JobExperienceDto jobExperienceDto) {
		JobExperience jobExperience =(JobExperience) this.dtoConverterService.dtoToEntity(jobExperienceDto, JobExperience.class);
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Is tecrubesi eklendi");
	}

}

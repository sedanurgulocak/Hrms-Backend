package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.modelMapper.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
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

	@Override
	public DataResult<List<JobExperienceDto>> getJobExperienceListByCandidateId(int candidateId) {
		return new SuccessDataResult<List<JobExperienceDto>>(this.dtoConverterService.entityToDto(this.jobExperienceDao.getJobExperienceListByCandidateId(candidateId), JobExperienceDto.class), "İş tecrübeleri listelendi");
	}

	@Override
	public DataResult<List<JobExperienceDto>> findAllByCandidateIdOrderByEndDateDesc(int candidateId) {
		return new SuccessDataResult<List<JobExperienceDto>>(this.dtoConverterService.entityToDto(this.jobExperienceDao.findAllByCandidateIdOrderByEndDateDesc(candidateId), JobExperienceDto.class), "İş tecrübeleri sıralandı");
	}

	@Override
	public Result deleteById(int id) {
		
		this.jobExperienceDao.deleteById(id);
		return new SuccessResult("İş kaydı silindi");
	}

}

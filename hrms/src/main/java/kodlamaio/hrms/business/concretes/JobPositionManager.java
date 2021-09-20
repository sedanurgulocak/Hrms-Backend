package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.modelMapper.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.dtos.jobsDto.JobPositionDto;
import kodlamaio.hrms.entities.concretes.jobs.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	@Autowired
	private DtoConverterService dtoConverterService;

	@Override
	public DataResult<List<JobPositionDto>> getAll() {
		return new SuccessDataResult<List<JobPositionDto>>(this.dtoConverterService.entityToDto(this.jobPositionDao.findAll(), JobPositionDto.class), "Data listelendi") ;
	}

	@Override
	public Result add(JobPositionDto jobPositionDto) {
		if(this.jobPositionDao.existsJobByTitle(jobPositionDto.getTitle())) {
			return new ErrorResult("Bu iş başlığı zaten var");
		}
		
		JobPosition jobPosition = (JobPosition) this.dtoConverterService.dtoToEntity(jobPositionDto, JobPosition.class);
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş başlığı eklendi");
	}
	
	
}

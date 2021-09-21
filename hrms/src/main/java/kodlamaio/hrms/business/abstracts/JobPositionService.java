package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.jobsDto.JobPositionDto;

public interface JobPositionService {

	DataResult<List<JobPositionDto>> getAll();
	
	Result add(JobPositionDto jobPosition);
}

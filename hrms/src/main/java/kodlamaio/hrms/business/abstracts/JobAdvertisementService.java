package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.jobsDto.JobAdvertisementDto;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisementDto jobAdvertisementDto);

	DataResult<List<JobAdvertisementDto>> getAll();
	
	DataResult<List<JobAdvertisementDto>> getAllActives();
	
	DataResult<List<JobAdvertisementDto>> getAllSortedDate();
	
	DataResult<List<JobAdvertisementDto>> getAllActiveAndByCompany(String companyName);
	
	Result setJobAdvertisementStatus(int id);
}

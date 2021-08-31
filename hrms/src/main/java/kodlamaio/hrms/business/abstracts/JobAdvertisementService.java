package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.jobs.JobAdvertisement;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisement jobAdvertisement);

	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getAllActives();
	
	DataResult<List<JobAdvertisement>> getAllSortedDate();
	
	DataResult<List<JobAdvertisement>> getAllActiveAndByCompany(String companyName);
	
	Result setJobAdvertisementStatus(int id);
}

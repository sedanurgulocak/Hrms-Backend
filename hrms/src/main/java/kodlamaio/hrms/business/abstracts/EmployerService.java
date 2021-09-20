package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.userDtos.EmployerDto;

public interface EmployerService {
	
	DataResult<List<EmployerDto>> getAll();

	Result add(EmployerDto employerDto);
	
	boolean doEmailAndWebsiteHaveTheSameDomain(String email, String website);
}

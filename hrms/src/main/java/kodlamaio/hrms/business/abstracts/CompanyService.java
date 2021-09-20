package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.jobsDto.CompanyDto;

public interface CompanyService {

	Result add(CompanyDto companyDto);
}

package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.jobs.Company;

public interface CompanyService {

	Result add(Company company);
}

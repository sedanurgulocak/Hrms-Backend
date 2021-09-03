package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.Education;

public interface EducationService {
	
	Result add(Education education);

}

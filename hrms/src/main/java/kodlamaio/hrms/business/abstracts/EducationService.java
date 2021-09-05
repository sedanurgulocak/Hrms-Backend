package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.Education;

public interface EducationService {
	
	Result add(Education education);
	
	List<Education> getListEducationByCandidateId(int candidateId);
	
	DataResult<List<Education>> sortEducation(int candidateId);

}

package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvs.Education;
import kodlamaio.hrms.entities.concretes.dtos.EducationDto;

public interface EducationService {
	
	Result add(EducationDto educationDto);
	
	List<Education> getListEducationByCandidateId(int candidateId);
	
	DataResult<List<Education>> sortEducation(int candidateId);

}

package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.cvDtos.EducationDto;

public interface EducationService {
	
	Result add(EducationDto educationDto);
	
	DataResult<List<EducationDto>> getListEducationByCandidateId(int candidateId);
	
	DataResult<List<EducationDto>> findAllByCandidateIdOrderByEndDateDesc(int candidateId);

}

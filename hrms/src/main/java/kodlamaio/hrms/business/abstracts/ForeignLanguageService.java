package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.ForeignLanguageDto;

public interface ForeignLanguageService {
	
	Result add(ForeignLanguageDto foreignLanguageDto);

	Result deleteById(int id);
	
	DataResult<List<ForeignLanguageDto>> getForeignLanguageListByCandidateId(int candidateId);
}

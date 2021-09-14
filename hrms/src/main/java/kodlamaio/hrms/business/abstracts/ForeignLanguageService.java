package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.ForeignLanguageDto;

public interface ForeignLanguageService {
	
	Result add(ForeignLanguageDto foreignLanguageDto);

}

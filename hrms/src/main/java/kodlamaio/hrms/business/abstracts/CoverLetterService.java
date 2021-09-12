package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.CoverLetterDto;

public interface CoverLetterService {
	
	Result add(CoverLetterDto coverLetterDto);
	
	Result update(int candidateId, String text);

}

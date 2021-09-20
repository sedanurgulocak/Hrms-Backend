package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.userDtos.CandidateDto;
import kodlamaio.hrms.entities.concretes.users.Candidate;

public interface CandidateService {

	DataResult<List<CandidateDto>> getAll();
	
	Result add(CandidateDto candidateDto);
	
	Candidate getById(int id);
}

package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.cvDtos.SkillDto;

public interface SkillService {
	
	Result add(SkillDto skillDto);

	Result deleteById(int id);
	
	DataResult<List<SkillDto>> getSkillListByCandidateId(int candidateId);
}

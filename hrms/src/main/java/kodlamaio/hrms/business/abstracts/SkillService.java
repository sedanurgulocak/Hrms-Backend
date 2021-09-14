package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.SkillDto;

public interface SkillService {
	
	Result add(SkillDto skillDto);

	DataResult<SkillDto> deleteById(int id);
	
	DataResult<List<SkillDto>> getSkillListByCandidateId(int candidateId);
}
package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.SkillDto;

public interface SkillService {
	
	Result add(SkillDto skillDto);

}

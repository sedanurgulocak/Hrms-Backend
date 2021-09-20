package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.jobsDto.CityDto;

public interface CityService {

	DataResult<List<CityDto>> getAll();
	
	Result add(CityDto cityDto);
}

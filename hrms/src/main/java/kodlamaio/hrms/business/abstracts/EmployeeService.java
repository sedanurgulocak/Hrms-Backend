package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.userDtos.EmployeeDto;

public interface EmployeeService {

	DataResult<List<EmployeeDto>> getAll();
	
	Result add(EmployeeDto employeeDto);
}

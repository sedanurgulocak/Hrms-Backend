package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.modelMapper.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.dtos.userDtos.EmployeeDto;
import kodlamaio.hrms.entities.concretes.users.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}
	
	@Autowired
	private DtoConverterService dtoConverterService;


	@Override
	public DataResult<List<EmployeeDto>> getAll() {
		return new SuccessDataResult<List<EmployeeDto>>(this.dtoConverterService.entityToDto(this.employeeDao.findAll(), EmployeeDto.class), "Çalışanlar listelendi");
	}


	@Override
	public Result add(EmployeeDto employeeDto) {
		Employee employee = (Employee) dtoConverterService.dtoToEntity(employeeDto, Employee.class);
		this.employeeDao.save(employee);
		return new SuccessResult("Çalışan eklendi");
	}

}

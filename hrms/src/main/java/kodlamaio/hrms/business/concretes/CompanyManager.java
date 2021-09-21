package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.modelMapper.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.entities.concretes.dtos.jobsDto.CompanyDto;
import kodlamaio.hrms.entities.concretes.jobs.Company;

@Service
public class CompanyManager implements CompanyService{

	private CompanyDao companyDao;
	
	@Autowired
	public CompanyManager(CompanyDao companyDao) {
		super();
		this.companyDao = companyDao;
	}
	
	@Autowired
	private DtoConverterService dtoConverterService;

	@Override
	public Result add(CompanyDto companyDto) {
		if(this.companyDao.existsCompanyByName(companyDto.getName())) {
			return new ErrorResult("Bu şirket zaten kayıtlı");
		}
		Company company = (Company) this.dtoConverterService.dtoToEntity(companyDto, Company.class);
		this.companyDao.save(company);
		return new SuccessResult("Şirket kaydedildi");
	}

}

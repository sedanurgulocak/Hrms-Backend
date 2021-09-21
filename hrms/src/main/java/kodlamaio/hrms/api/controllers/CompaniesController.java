package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.jobsDto.CompanyDto;

@RestController
@RequestMapping("api/companies")
public class CompaniesController {
	
	private CompanyService companyService;

	@Autowired
	public CompaniesController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CompanyDto companyDto) {
		return this.companyService.add(companyDto);
	}

}

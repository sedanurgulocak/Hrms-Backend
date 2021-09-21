package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.jobsDto.JobAdvertisementDto;

@RestController
@RequestMapping("api/jobAdvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementDto jobAdvertisementDto) {
		return this.jobAdvertisementService.add(jobAdvertisementDto);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisementDto>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getAllActives")
	public DataResult<List<JobAdvertisementDto>> getAllActives(){
		return this.jobAdvertisementService.getAllActives();
	}
	
	@GetMapping("/getAllSortedDate")
	public DataResult<List<JobAdvertisementDto>> getAllSortedDate(){
		return this.jobAdvertisementService.getAllSortedDate();
	}
	
	@GetMapping("/getAllActiveAndByCompany")
	public DataResult<List<JobAdvertisementDto>> getAllActiveAndByCompany(String companyName){
		return this.jobAdvertisementService.getAllActiveAndByCompany(companyName);
	}
	
	@PutMapping("/setStatus/{id}")
	public Result setJobAdvertisementStatus(@PathVariable int id) {
		return this.jobAdvertisementService.setJobAdvertisementStatus(id);
	}

}

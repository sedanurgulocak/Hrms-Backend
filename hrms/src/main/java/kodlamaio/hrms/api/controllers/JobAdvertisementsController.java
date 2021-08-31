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
import kodlamaio.hrms.entities.concretes.jobs.JobAdvertisement;

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
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getAllActives")
	public DataResult<List<JobAdvertisement>> getAllActives(){
		return this.jobAdvertisementService.getAllActives();
	}
	
	@GetMapping("/getAllSortedDate")
	public DataResult<List<JobAdvertisement>> getAllSortedDate(){
		return this.jobAdvertisementService.getAllSortedDate();
	}
	
	@GetMapping("/getAllActiveAndByCompany")
	public DataResult<List<JobAdvertisement>> getAllActiveAndByCompany(String companyName){
		return this.jobAdvertisementService.getAllActiveAndByCompany(companyName);
	}
	
	@PutMapping("/setStatus/{id}")
	public Result setJobAdvertisementStatus(@PathVariable int id) {
		return this.jobAdvertisementService.setJobAdvertisementStatus(id);
	}

}

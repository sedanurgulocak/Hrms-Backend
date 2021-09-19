package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.JobExperienceDto;

@RestController
@RequestMapping("/api/jobExperieces")
public class JobExperiencesController {
	
	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobExperienceDto jobExperienceDto) {
		
		return this.jobExperienceService.add(jobExperienceDto);
	}

	@GetMapping("/getJobExperienceListByCandidateId")
	public DataResult<List<JobExperienceDto>> getJobExperienceListByCandidateId(@RequestParam int candidateId){
		
		return this.jobExperienceService.getJobExperienceListByCandidateId(candidateId);
	}
	
	@GetMapping("/findAllByCandidateIdOrderByEndDateDesc")
	public DataResult<List<JobExperienceDto>> findAllByCandidateIdOrderByEndDateDesc(@RequestParam int candidateId){
		
		return this.jobExperienceService.findAllByCandidateIdOrderByEndDateDesc(candidateId);
	}
	
	@DeleteMapping("/delete/{id}")
	public Result deleteById(@PathVariable("id") int id) {
		
		return this.jobExperienceService.deleteById(id);
	}
}

package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.CoverLetterDto;

@RestController
@RequestMapping("api/coverLetter")
public class CoverLettersControllers {
	
	private CoverLetterService coverLetterService;
	
	@Autowired
	public CoverLettersControllers(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CoverLetterDto coverLetterDto) {
		
		return this.coverLetterService.add(coverLetterDto);
	}
	
	@PutMapping("/update")
	public Result update(@RequestParam int candidateId, @RequestParam String text) {
		
		return this.coverLetterService.update(candidateId, text);
	}
	
	@DeleteMapping("/delete/{id}")
	public Result deletebyId(@PathVariable("id") int id){
		
		return this.coverLetterService.deleteById(id);
	}

}

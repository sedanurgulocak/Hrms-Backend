package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.CoverLetterDto;

@RestController
@RequestMapping("api/coverLetter")
public class CoverLettersControllers {
	
	private CoverLetterService coverLetterService;
	
	@PostMapping("/add")
	public Result add(@RequestBody CoverLetterDto coverLetterDto) {
		
		return this.coverLetterService.add(coverLetterDto);
	}

}

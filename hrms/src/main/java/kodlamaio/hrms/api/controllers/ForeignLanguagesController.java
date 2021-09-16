package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.ForeignLanguageDto;

@RestController
@RequestMapping("/api/foreignLanguages")
public class ForeignLanguagesController {
	
	private ForeignLanguageService foreignLanguageService;

	@Autowired
	public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ForeignLanguageDto foreignLanguageDto) {
		
		return this.foreignLanguageService.add(foreignLanguageDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public Result deleteById(@PathVariable("id") int id){
		
		return this.foreignLanguageService.deleteById(id);
	}
	
	@GetMapping("/getForeignLanguageListByCandidateId")
	public DataResult<List<ForeignLanguageDto>> getForeignLanguageListByCandidateId(int candidateId){
		
		return this.foreignLanguageService.getForeignLanguageListByCandidateId(candidateId);
	}

}

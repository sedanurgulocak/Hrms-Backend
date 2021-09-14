package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.SkillDto;

@RestController
@RequestMapping("api/skills")
public class SkillsController {
	
	private SkillService skillService;

	@Autowired
	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SkillDto skillDto) {
		
		return this.skillService.add(skillDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public DataResult<SkillDto> deleteById(@PathVariable("id") int id){
		
		return this.skillService.deleteById(id);
	}

}

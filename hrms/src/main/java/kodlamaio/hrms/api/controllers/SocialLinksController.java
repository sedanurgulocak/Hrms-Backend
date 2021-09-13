package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SocialLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.SocialLinkDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/socialLinks")
public class SocialLinksController {

	private SocialLinkService socialLinkService;

	@Autowired
	public SocialLinksController(SocialLinkService socialLinkService) {
		super();
		this.socialLinkService = socialLinkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SocialLinkDto socialLinkDto) {
		
		return this.socialLinkService.add(socialLinkDto);
	}
	
	@PutMapping("/update")
	public DataResult<SocialLinkDto> update(@RequestParam int candidateId, @RequestParam String githubLink, @RequestParam String linkedinLink){
		
		return this.socialLinkService.update(candidateId, githubLink, linkedinLink);
	}
}

package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/photos")
public class PhotosController {
	
	private PhotoService photoService;

	@Autowired
	public PhotosController(PhotoService photoService) {
		super();
		this.photoService = photoService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam String photoLink, @RequestParam int candidateId) {
		return this.photoService.add(photoLink, candidateId);
	}

}

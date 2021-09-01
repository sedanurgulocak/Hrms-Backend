package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.adapters.CloudinaryAdapter;
import kodlamaio.hrms.core.adapters.PhotoUploadManager;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.entities.concretes.cvs.Photo;
import kodlamaio.hrms.entities.concretes.users.Candidate;

@Service
public class PhotoManager implements PhotoService{

	private PhotoDao photoDao;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao) {
		super();
		this.photoDao = photoDao;
	}
	
	@Autowired
	private CandidateService candidateService;
	

	@Override
	public Result add(String link, int candidateId) {
		PhotoUploadManager photoUploadManager = new PhotoUploadManager(new CloudinaryAdapter());
		photoUploadManager.uploadToPhoto(link);
		
		Candidate candidate = this.candidateService.getById(candidateId);
		Photo photo = new Photo();
		photo.setCandidate(candidate);
		photo.setPhotoUrl(link);
		this.photoDao.save(photo);
		
		return new SuccessResult("Adayın fotoğrafı eklendi");
	}

}

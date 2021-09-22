package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.adapters.CloudinaryAdapterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
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
	
	@Autowired
	private CloudinaryAdapterService cloudinaryAdapterService;

	@Override
	public Result add(String link, int candidateId) {

		this.cloudinaryAdapterService.uploadToPhoto(link);
		
		Candidate candidate = this.candidateService.getById(candidateId);
		Photo photo = new Photo();
		photo.setCandidate(candidate);
		photo.setPhotoUrl(this.cloudinaryAdapterService.getUrl());
		this.photoDao.save(photo);
		
		return new SuccessResult("Adayın fotoğrafı eklendi");
	}


	@Override
	public DataResult<String> getPhotoUrlByCandidateId(int candidateId) {
		Photo photo = this.photoDao.getByCandidateId(candidateId);
		return new SuccessDataResult<String>(photo.getPhotoUrl(), "Aday fotoğrafı getirildi");
		
	}

}

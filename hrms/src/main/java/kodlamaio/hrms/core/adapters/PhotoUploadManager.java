package kodlamaio.hrms.core.adapters;

public class PhotoUploadManager implements PhotoUploadService{

	private PhotoUploadService photoUploadService;
	
	public PhotoUploadManager(PhotoUploadService photoUploadService) {
		super();
		this.photoUploadService = photoUploadService;
	}

	@Override
	public void uploadToPhoto(String photoUrl) {
		photoUploadService.uploadToPhoto(photoUrl);
		
	}

}

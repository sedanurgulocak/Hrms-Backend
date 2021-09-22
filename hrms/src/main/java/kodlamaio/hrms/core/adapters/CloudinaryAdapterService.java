package kodlamaio.hrms.core.adapters;


public interface CloudinaryAdapterService {

	void uploadToPhoto(String photoUrl);
	
	String getUrl();
	
}

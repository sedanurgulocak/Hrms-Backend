package kodlamaio.hrms.core.adapters;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryAdapterManager implements CloudinaryAdapterService{
	
	String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void uploadToPhoto(String photoUrl) {
		try {
			FileReader fileReader = new FileReader("C:/Users/sedan/git/javaKampHrms/hrms/src/main/resources/cloudinarySettings.properties");
			Properties properties = new Properties();
			properties.load(fileReader);
			
			Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
					"cloud_name", properties.getProperty("cloud_name"),
					"api_key", properties.getProperty("api_key"),
					"api_secret", properties.getProperty("api_secret")
					));
			 Map<?, ?> uploadResult = cloudinary.uploader().upload(photoUrl, ObjectUtils.asMap());
			 
			 setUrl((String) uploadResult.get("url"));
			 
			 //setUrl(cloudinary.url());
			 
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Fotoğraf yüklenemedi");
		}
		
	}

		

}

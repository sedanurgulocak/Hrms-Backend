package kodlamaio.hrms.core.adapters;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryAdapter implements PhotoUploadService{

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
			cloudinary.uploader().upload(photoUrl, ObjectUtils.asMap());
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Fotoğraf yüklenemedi");
		}
		
	}

}

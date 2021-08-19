package kodlamaio.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kodlamaio.hrms.core.verifications.abstracts.EmailVerificationService;

@Service
public class EmailVerificationManager implements EmailVerificationService {

	@Override
	public boolean isVerifed(String email) {
		
		  if(!checkEmailFormat(email)) { 
			  return false; }
		 
		return true;
	}
	
	
	@Override public boolean checkEmailFormat(String email) { 
		  String regex ="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		  Pattern pattern = Pattern.compile(regex); 
		  Matcher matcher = pattern.matcher(email); 
		  return matcher.matches(); 
	}
	 

}

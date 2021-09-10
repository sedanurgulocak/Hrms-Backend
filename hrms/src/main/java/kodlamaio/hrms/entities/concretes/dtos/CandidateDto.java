package kodlamaio.hrms.entities.concretes.dtos;

import lombok.Data;

@Data
public class CandidateDto {
	
	public String firstName;
	
	public String lastName;
	
	public String email;
	
	public String password;
	
	public String passwordAgain;
	
	public String type;
	
	public String nationalIdentity;
	
	public String dateOfBirth;

}

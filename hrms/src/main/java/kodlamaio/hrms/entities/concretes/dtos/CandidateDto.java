package kodlamaio.hrms.entities.concretes.dtos;

import lombok.Data;

@Data
public class CandidateDto {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String passwordAgain;
	
	private String type;
	
	private String nationalIdentity;
	
	private String dateOfBirth;

}

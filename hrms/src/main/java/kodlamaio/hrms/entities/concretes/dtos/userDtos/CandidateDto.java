package kodlamaio.hrms.entities.concretes.dtos.userDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

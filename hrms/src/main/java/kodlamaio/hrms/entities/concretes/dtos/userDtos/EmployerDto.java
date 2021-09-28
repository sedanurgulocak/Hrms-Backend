package kodlamaio.hrms.entities.concretes.dtos.userDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto {
	
	private String companyName;
	
	private String webAddress;
	
	private String phoneNumber;
	
	private String email;
	
	private String password;
	
	private String passwordAgain;
	
	private String type;


}

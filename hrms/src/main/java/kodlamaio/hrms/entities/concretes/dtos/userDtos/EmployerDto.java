package kodlamaio.hrms.entities.concretes.dtos.userDtos;

import lombok.Data;

@Data
public class EmployerDto {
	
	private String companyName;
	
	private String webAddress;
	
	private String phoneNumber;
	
	private String email;
	
	private String password;
	
	private String passwordAgain;
	
	private String type;


}

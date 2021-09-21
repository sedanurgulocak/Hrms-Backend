package kodlamaio.hrms.entities.concretes.dtos.userDtos;

import lombok.Data;

@Data
public class EmployeeDto {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String passwordAgain;
	
	private String type;


}

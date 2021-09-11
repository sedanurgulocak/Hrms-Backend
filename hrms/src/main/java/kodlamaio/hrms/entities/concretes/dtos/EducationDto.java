package kodlamaio.hrms.entities.concretes.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class EducationDto {
	
	private int candidateId;
	
	private String schoolName;
	
	private String degree;
	
	private String schoolDepartment;
	
	private Date startDate;
	
	private Date endDate;
	
	private boolean isGraduated;
	
	private double grade;

}

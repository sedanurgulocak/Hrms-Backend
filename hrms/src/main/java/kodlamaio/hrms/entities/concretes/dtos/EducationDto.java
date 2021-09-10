package kodlamaio.hrms.entities.concretes.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class EducationDto {
	
	public int candidateId;
	
	public String schoolName;
	
	public String degree;
	
	public String schoolDepartment;
	
	public Date startDate;
	
	public Date endDate;
	
	public boolean isGraduated;
	
	public double grade;

}

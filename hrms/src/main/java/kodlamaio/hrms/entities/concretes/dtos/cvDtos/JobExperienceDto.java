package kodlamaio.hrms.entities.concretes.dtos.cvDtos;

import java.util.Date;

import lombok.Data;

@Data
public class JobExperienceDto {

	private int candidateId;
	
	private String businessName;
	
	private String jobPositionName;
	
	private Date startDate;
	
	private Date endDate;
	
	private boolean isContinue;
	
}

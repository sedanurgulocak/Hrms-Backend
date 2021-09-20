package kodlamaio.hrms.entities.concretes.dtos.jobsDto;

import java.util.Date;

import lombok.Data;

@Data
public class JobAdvertisementDto {
	
	private int employerId;
	
	private int jobPositionId;
	
	private int companyId;
	
	private int cityId;
	
	private String description;
	
	private int numberOfOpenPosition;
	
	private boolean status;
	
	private Date createDate;
	
	private Date endDate;
	
	private int salaryMin;
	
	private int salaryMax;

}

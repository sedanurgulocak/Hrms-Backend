package kodlamaio.hrms.entities.concretes.dtos.cvDtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceDto {

	private int candidateId;
	
	private String businessName;
	
	private String jobPositionName;
	
	private Date startDate;
	
	private Date endDate;
	
	private boolean isContinue;
	
}

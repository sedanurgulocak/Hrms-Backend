package kodlamaio.hrms.entities.concretes.dtos.cvDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForeignLanguageDto {
	
	private int candidateId;
	
	private String language;
	
	private int level;
	

}

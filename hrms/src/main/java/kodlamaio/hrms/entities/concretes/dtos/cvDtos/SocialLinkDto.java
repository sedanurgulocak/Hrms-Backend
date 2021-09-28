package kodlamaio.hrms.entities.concretes.dtos.cvDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialLinkDto {

	private int candidateId;
	
	private String githubLink;
	
	private String linledinLink;
}

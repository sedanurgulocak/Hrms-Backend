package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.SocialLinkDto;

public interface SocialLinkService {
	
	Result add(SocialLinkDto socialLinkDto);

}

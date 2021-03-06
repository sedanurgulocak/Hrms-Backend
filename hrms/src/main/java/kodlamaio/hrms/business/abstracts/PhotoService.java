package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public interface PhotoService {

	Result add(String link, int candidate_id);
	
	DataResult<String> getPhotoUrlByCandidateId(int candidateId);
}

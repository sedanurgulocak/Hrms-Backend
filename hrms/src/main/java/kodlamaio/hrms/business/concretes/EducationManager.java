package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.cvs.Education;
import kodlamaio.hrms.entities.concretes.dtos.EducationDto;

@Service
public class EducationManager implements EducationService{

	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(EducationDto educationDto) {
		this.educationDao.save(educationDto);
		return new SuccessResult("Eğitim bilgisi eklendi");
	}


	@Override
	public List<Education> getListEducationByCandidateId(int candidateId) {
		List<Education> educationsByCandidate = new ArrayList<Education>();
		educationsByCandidate = this.educationDao.getByCandidateId(candidateId);
		return educationsByCandidate;
		
	}

	@Override
	public DataResult<List<Education>> sortEducation(int candidateId) {
		
		Collections.sort(this.getListEducationByCandidateId(candidateId), Collections.reverseOrder());
		return new SuccessDataResult<List<Education>>(this.getListEducationByCandidateId(candidateId),"Adayın eğitim bilgileri sıralandı");
	}

}

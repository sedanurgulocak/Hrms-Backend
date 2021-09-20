package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.modelMapper.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.cvs.Education;
import kodlamaio.hrms.entities.concretes.dtos.cvDtos.EducationDto;

@Service
public class EducationManager implements EducationService{

	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}
	
	@Autowired
	private DtoConverterService dtoConverterService;


	@Override
	public Result add(EducationDto educationDto) {
		Education education = (Education) this.dtoConverterService.dtoToEntity(educationDto, Education.class);
		this.educationDao.save(education);
		return new SuccessResult("Eğitim bilgisi eklendi");
	}

	@Override
	public DataResult<List<Education>> getListEducationByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getByCandidateId(candidateId));
	}


	@Override
	public DataResult<List<Education>> findAllByCandidateIdOrderByEndDateDesc(int candidateId) {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAllByCandidateIdOrderByEndDateDesc(candidateId), "Eğitimler mezuniyet yılına göre sıralandı");
	}

}

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
	public DataResult<List<EducationDto>> getListEducationByCandidateId(int candidateId) {
		return new SuccessDataResult<List<EducationDto>>(this.dtoConverterService.entityToDto(this.educationDao.getEducationListByCandidateId(candidateId), EducationDto.class),"adayın eğitimleri listelendi");
	}


	@Override
	public DataResult<List<EducationDto>> findAllByCandidateIdOrderByEndDateDesc(int candidateId) {
		return new SuccessDataResult<List<EducationDto>>(this.dtoConverterService.entityToDto(this.educationDao.findAllByCandidateIdOrderByEndDateDesc(candidateId), EducationDto.class), "Eğitimler mezuniyet yılına göre sıralandı");
	}

}

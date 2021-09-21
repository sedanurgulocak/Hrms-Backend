package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.modelMapper.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ForeignLanguageDao;
import kodlamaio.hrms.entities.concretes.cvs.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.dtos.cvDtos.ForeignLanguageDto;

@Service
public class ForeignLanguageManager implements ForeignLanguageService{
	
	private ForeignLanguageDao foreignLanguageDao;

	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
	}
	
	@Autowired
	private DtoConverterService dtoConverterService;

	@Override
	public Result add(ForeignLanguageDto foreignLanguageDto) {
		ForeignLanguage foreignLanguage = (ForeignLanguage) this.dtoConverterService.dtoToEntity(foreignLanguageDto, ForeignLanguage.class);
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Yabancı dil eklendi");
	}

	@Override
	public Result deleteById(int id) {
		this.foreignLanguageDao.deleteById(id);
		return new SuccessResult("Yabancı dil silindi");
	}

	@Override
	public DataResult<List<ForeignLanguageDto>> getForeignLanguageListByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<ForeignLanguageDto>>(this.dtoConverterService.entityToDto(this.foreignLanguageDao.getForeignLanguageListByCandidateId(candidateId), ForeignLanguageDto.class), "Yabancı diller listelendi");
	}

}

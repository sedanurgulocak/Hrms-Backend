package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.modelMapper.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ForeignLanguageDao;
import kodlamaio.hrms.entities.concretes.cvs.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.dtos.ForeignLanguageDto;

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

}

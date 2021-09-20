package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.modelMapper.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.dtos.jobsDto.CityDto;
import kodlamaio.hrms.entities.concretes.jobs.City;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}
	
	@Autowired 
	private DtoConverterService dtoConverterService;

	@Override
	public Result add(CityDto cityDto) {
		if(this.cityDao.existsCityByName(cityDto.getName())) {
			return new ErrorResult("Bu şehir zaten kayıtlı");
		}
		
		City city = (City) this.dtoConverterService.dtoToEntity(cityDto, City.class);
		this.cityDao.save(city);
		return new SuccessResult("Şehir kaydedildi");
	}

	@Override
	public DataResult<List<CityDto>> getAll() {
		return new SuccessDataResult<List<CityDto>>(this.dtoConverterService.entityToDto(this.cityDao.findAll(), CityDto.class), "Data listelendi");
	}

}

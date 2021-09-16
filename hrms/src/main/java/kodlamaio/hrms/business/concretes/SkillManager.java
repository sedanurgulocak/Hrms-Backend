package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.modelMapper.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillDao;
import kodlamaio.hrms.entities.concretes.cvs.Skill;
import kodlamaio.hrms.entities.concretes.dtos.SkillDto;

@Service
public class SkillManager implements SkillService{
	
	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}
	
	@Autowired
	private DtoConverterService dtoConverterService;

	@Override
	public Result add(SkillDto skillDto) {
		Skill skill = (Skill) this.dtoConverterService.dtoToEntity(skillDto, Skill.class);
		this.skillDao.save(skill);
		return new SuccessResult("Yetenek eklendi");
		
	}

	@Override
	public Result deleteById(int id) {
		this.skillDao.deleteById(id);
		return new SuccessResult("Yetenek silindi");
	}

	@Override
	public DataResult<List<SkillDto>> getSkillListByCandidateId(int candidateId) {
		return new SuccessDataResult<List<SkillDto>>(this.dtoConverterService.entityToDto(this.skillDao.getSkillListByCandidateId(candidateId), SkillDto.class), "Yetenekler listelendi");
	}

}

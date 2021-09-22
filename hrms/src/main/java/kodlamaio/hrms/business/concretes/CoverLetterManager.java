package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.modelMapper.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.entities.concretes.cvs.CoverLetter;
import kodlamaio.hrms.entities.concretes.dtos.cvDtos.CoverLetterDto;

@Service
public class CoverLetterManager implements CoverLetterService{
	
	private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}
	
	@Autowired
	private DtoConverterService dtoConverterService;


	@Override
	public Result add(CoverLetterDto coverLetterDto) {
		CoverLetter coverLetter = (CoverLetter) this.dtoConverterService.dtoToEntity(coverLetterDto, CoverLetter.class);
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Ön yazı eklendi");
	}


	@Override
	public Result update(int candidateId, String text) {
		CoverLetter coverLetter = this.coverLetterDao.getByCandidateId(candidateId);
		coverLetter.setText(text);
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Ön yazı güncellendi");
	}


	@Override
	public Result deleteById(int id) {
		this.coverLetterDao.deleteById(id);
		return new SuccessResult("On yazi silindi");
	}


	@Override
	public DataResult<CoverLetterDto> getByCandidateId(int candidateId) {
		CoverLetterDto coverLetterDto = (CoverLetterDto) this.dtoConverterService.dtoToEntity(this.coverLetterDao.getByCandidateId(candidateId), CoverLetterDto.class);
		return new SuccessDataResult<CoverLetterDto>(coverLetterDto, "Cv ön yazısı getirildi");
	}

}

package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SocialLinkService;
import kodlamaio.hrms.core.utilities.modelMapper.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SocialLinkDao;
import kodlamaio.hrms.entities.concretes.cvs.SocialLink;
import kodlamaio.hrms.entities.concretes.dtos.SocialLinkDto;

@Service
public class SocialLinkManager implements SocialLinkService{

	private SocialLinkDao socialLinkDao;
	
	@Autowired
	public SocialLinkManager(SocialLinkDao socialLinkDao) {
		super();
		this.socialLinkDao = socialLinkDao;
	}
	
	@Autowired
	private DtoConverterService dtoConverterService;


	@Override
	public Result add(SocialLinkDto socialLinkDto) {
		SocialLink socialLink = (SocialLink) this.dtoConverterService.dtoToEntity(socialLinkDto, SocialLink.class);
		this.socialLinkDao.save(socialLink);
		return new SuccessResult("Sosyal hesaplar eklendi");
	}


	@Override
	public DataResult<SocialLinkDto> update(int candidateId, String githubLink, String linkedinLink) {
		SocialLink socialLink = this.socialLinkDao.getByCandidateId(candidateId);
		socialLink.setGithubLink(githubLink);
		socialLink.setLinledinLink(linkedinLink);
		this.socialLinkDao.save(socialLink);
		SocialLinkDto socialLinkDto =(SocialLinkDto) this.dtoConverterService.dtoToEntity(socialLink, SocialLinkDto.class);
		return new SuccessDataResult<SocialLinkDto>(socialLinkDto, "Sosyal hesaplar güncellendi");
	}

}

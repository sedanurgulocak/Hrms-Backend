package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.modelMapper.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verifications.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.verifications.abstracts.MernisVerificationService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.dtos.CandidateDto;
import kodlamaio.hrms.entities.concretes.users.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}
	
	@Autowired(required=false)
	private EmailVerificationService emailVerificationService;
	
	@Autowired(required=false)
	private MernisVerificationService mernisVerificationService;
	
	@Autowired
	private DtoConverterService dtoConverterService;


	@Override
	public DataResult<List<CandidateDto>> getAll() {
		return new SuccessDataResult<List<CandidateDto>>(this.dtoConverterService.entityToDto(this.candidateDao.findAll(), CandidateDto.class), "Adaylar listelendi");
	}


	@Override
	public Result add(CandidateDto candidateDto) {
		
		if(candidateDto.getEmail() == null || candidateDto.getPassword() == null || candidateDto.getPasswordAgain() == null || 
				candidateDto.getType() == null || candidateDto.getFirstName() == null || candidateDto.getLastName() == null ||
				candidateDto.getNationalIdentity() == null || candidateDto.getDateOfBirth() == null ) {
			return new ErrorResult("Tüm alanlar zorunlu");
		}else if(!candidateDto.getPassword().equals(candidateDto.getPasswordAgain())) {
			return new ErrorResult("Şifre ve şifre tekrarı eşit değil");
		}else if(!this.emailVerificationService.isVerifed(candidateDto.getEmail())) {
			return new ErrorResult("Email onaylanmadı");
		}else if(!this.mernisVerificationService.checkIfRealPerson(candidateDto)){
			return new ErrorResult("Kullanıcı mernisten onaylanmadı");
		}
		else if(this.candidateDao.existsCandidateByEmail(candidateDto.getEmail())) {
			return new ErrorResult("Email zaten kayıtlı");
		}else if(this.candidateDao.existsCandidateByNationalIdentity(candidateDto.getNationalIdentity())){
			return new ErrorResult("Tc kimlik no zaten kayıtlı");
		}
		
		Candidate candidate = (Candidate) dtoConverterService.dtoToEntity(candidateDto, Candidate.class);
		this.candidateDao.save(candidate);
		return new SuccessResult("Aday eklendi");
	}


	@Override
	public Candidate getById(int id) {
		Candidate candidate = this.candidateDao.getById(id);
		return candidate;
	}

}

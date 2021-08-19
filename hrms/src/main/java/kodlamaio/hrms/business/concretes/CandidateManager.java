package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verifications.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.verifications.abstracts.MernisVerificationService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

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


	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Adaylar listelendi");
	}


	@Override
	public Result add(Candidate candidate) {
		if(candidate.getEmail() == null || candidate.getPassword() == null || candidate.getPasswordAgain() == null || 
				candidate.getType() == null || candidate.getFirstName() == null || candidate.getLastName() == null ||
				candidate.getNationalIdentity() == null || candidate.getDateOfBirth() == null ) {
			return new ErrorResult("Tüm alanlar zorunlu");
		}else if(!candidate.getPassword().equals(candidate.getPasswordAgain())) {
			return new ErrorResult("Şifre ve şifre tekrarı eşit değil");
		}else if(!this.emailVerificationService.isVerifed(candidate.getEmail())) {
			return new ErrorResult("Email onaylanmadı");
		}else if(!this.mernisVerificationService.checkIfRealPerson(candidate)){
			return new ErrorResult("Kullanıcı mernisten onaylanmadı");
		}else if(this.candidateDao.existsCandidateByEmail(candidate.getEmail())) {
			return new ErrorResult("Email zaten kayıtlı");
		}else if(this.candidateDao.existsCandidateByNationalIdentity(candidate.getNationalIdentity())){
			return new ErrorResult("Tc kimlik no zaten kayıtlı");
		}
		
		this.candidateDao.save(candidate);
		return new SuccessResult("Aday eklendi");
	}

}

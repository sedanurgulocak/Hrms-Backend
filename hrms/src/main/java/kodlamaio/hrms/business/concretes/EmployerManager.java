package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verifications.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.verifications.abstracts.EmployeeConfirmService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	
	@Autowired(required=false)
	private EmailVerificationService emailVerificationService;
	
	@Autowired(required=false)
	private EmployeeConfirmService employeeConfirmService;
	
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi");
	}

	@Override
	public Result add(Employer employer) {
		
		if(employer.getCompanyName() == null || employer.getWebAddress() == null || employer.getPhoneNumber() == null
				 || employer.getEmail() == null || employer.getPassword() == null || employer.getPasswordAgain() == null || employer.getType() == null ) {
			return new ErrorResult("Tüm alanlar zorunlu");
			
		}else if(!employer.getPassword().equals(employer.getPasswordAgain())) {
			return new ErrorResult("Şifre ve şifre tekrarı aynı değil");
			
		}else if(!doEmailAndWebsiteHaveTheSameDomain(employer.getEmail(), employer.getWebAddress())){//Email, web adresi ile aynı domaine sahip mi
			return new ErrorResult("Email web site ile aynı domaine sahip değil");
			
		}
		else if(!this.emailVerificationService.isVerifed(employer.getEmail())) {
			return new ErrorResult("Email onaylanmadı");
			
		}
		else if(!this.employeeConfirmService.isConfirmedEmployee(employer)) {
			return new ErrorResult("Sistem personeli onaylamadı");
			
		}
		else if(this.employerDao.existsEmployerByEmail(employer.getEmail())) {
			return new ErrorResult("Email adresi zaten kayıtlı");
		}
		
		this.employerDao.save(employer);
		return new SuccessResult("İş veren eklendi");
	}

	@Override
	public boolean doEmailAndWebsiteHaveTheSameDomain(String email, String website) {
		int index = email.indexOf("@");
		String emailDomain = email.substring(index);
		String websiteDomain = website.replaceFirst("^(https?://)?(www\\.)?", "");
		if(emailDomain.contains(websiteDomain)) {
			return true;
		}else {
			return false;
		}
	}
	
	

}

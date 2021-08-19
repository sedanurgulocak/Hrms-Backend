package kodlamaio.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.verifications.abstracts.EmployeeConfirmService;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployeeConfirmManager implements EmployeeConfirmService  {

	@Override
	public boolean isConfirmedEmployee(Employer employer) {
		
		return true;
	}

}

package kodlamaio.hrms.core.verifications.concretes;

import kodlamaio.hrms.core.verifications.abstracts.EmployeeConfirmService;
import kodlamaio.hrms.entities.concretes.Employer;

public class EmployeeConfirmManager implements EmployeeConfirmService  {

	@Override
	public boolean isConfirmedEmployee(Employer employer) {
		
		return true;
	}

}

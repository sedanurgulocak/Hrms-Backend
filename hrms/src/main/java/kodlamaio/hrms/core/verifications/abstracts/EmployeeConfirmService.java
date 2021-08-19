package kodlamaio.hrms.core.verifications.abstracts;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployeeConfirmService {

	public boolean isConfirmedEmployee(Employer employer);
}

package kodlamaio.hrms.core.verifications.abstracts;

import kodlamaio.hrms.entities.concretes.users.Employer;

public interface EmployeeConfirmService {

	public boolean isConfirmedEmployee(Employer employer);
}

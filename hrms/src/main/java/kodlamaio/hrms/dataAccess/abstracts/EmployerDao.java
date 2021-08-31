package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.users.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

	boolean existsEmployerByEmail(String email);
}

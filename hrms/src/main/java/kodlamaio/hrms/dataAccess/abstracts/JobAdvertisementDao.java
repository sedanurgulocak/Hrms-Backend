package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.jobs.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	
	List<JobAdvertisement> queryJobAdvertisementByStatusTrue();
	
	List<JobAdvertisement> getByCompany_Name(String companyName);
	//List<JobAdvertisement> findByOrderByCreateDateDesc();

}

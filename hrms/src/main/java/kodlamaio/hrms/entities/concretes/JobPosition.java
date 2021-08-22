package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name="job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "job_advertisements"})
public class JobPosition {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	public JobPosition() {
		
	}

	public JobPosition(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
}

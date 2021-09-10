package kodlamaio.hrms.entities.concretes.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
@PrimaryKeyJoinColumn(name="user_id")
public class Employee extends User{
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name= "last_name")
	private String lastName;

}

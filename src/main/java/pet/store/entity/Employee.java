package pet.store.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	private String firstName;
	private String lastName;
	private String jobTitle;
	private int phone;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pet_store_id")
	private PetStore petStore;
}

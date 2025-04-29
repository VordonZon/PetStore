package pet.store.entity;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	private Long customerId;
	private String firstName;
	private String lastName;
	private String email;
	
	@ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST)
	private Set<PetStore> petStores;
}

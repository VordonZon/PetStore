package pet.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity // JPA defines this class to be mapped to a table
@Data // Defines getters and setters for variables in class
public class PetStore {
	@Id // Marks the primary key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generates unique key values for primary key columns
	private Long petStoreId;
	private String name;
	private String adresss;
	private String city;
	private String state;
	private int zip;
	private int phone;

	@EqualsAndHashCode.Exclude // generates the equals() and hashCode() methods for a given class
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "pet_store_customer", joinColumns = @JoinColumn(name = "pet_store_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
	private Set<Customer> customers = new HashSet<>();

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Employee> employees = new HashSet<>();
}

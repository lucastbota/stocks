package br.com.store.stock.adapter.out.jpa.entity;

import br.com.store.stock.domain.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class CustomerJpaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;

	public CustomerJpaEntity() {
	}

	public CustomerJpaEntity(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Métodos de conversão:
	public static CustomerJpaEntity fromDomain(Customer customer) {
		return new CustomerJpaEntity(customer.id(), customer.name(), customer.email());
	}

	public Customer toDomain() {
		return new Customer(id, name, email);
	}
}

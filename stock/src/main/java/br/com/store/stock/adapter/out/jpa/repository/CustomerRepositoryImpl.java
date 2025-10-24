package br.com.store.stock.adapter.out.jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.store.stock.adapter.out.jpa.entity.CustomerJpaEntity;
import br.com.store.stock.domain.Customer;
import br.com.store.stock.ports.out.SaveCustomerPort;

@Repository
public class CustomerRepositoryImpl implements SaveCustomerPort {
	private SpringDataCustomerRepository repository;

	@Override
	public Customer save(Customer customer) {
		var persisted = repository.save(CustomerJpaEntity.fromDomain(customer));
		return new Customer(persisted.getId(), persisted.getName(), persisted.getEmail());
	}

	@Autowired
	public void setRepository(SpringDataCustomerRepository repository) {
		this.repository = repository;
	}

}

package br.com.store.stock.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.stock.domain.Customer;
import br.com.store.stock.ports.in.RegisterCustomerUseCase;
import br.com.store.stock.ports.out.SaveCustomerPort;

@Service
public class CustomerService implements RegisterCustomerUseCase {
	private SaveCustomerPort saveCustomerPort;

	@Override
	public Customer register(Customer customer) {
		//muitas regras de negócios
		return saveCustomerPort.save(customer);
	}

	@Autowired
	private void setSaveCustomerPort(SaveCustomerPort saveCustomerPort) {
		this.saveCustomerPort = saveCustomerPort;
	}
}

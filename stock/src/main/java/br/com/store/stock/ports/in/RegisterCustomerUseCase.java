package br.com.store.stock.ports.in;

import br.com.store.stock.domain.Customer;

public interface RegisterCustomerUseCase {
	Customer register(Customer customer);
}

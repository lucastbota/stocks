package br.com.store.stock.ports.out;

import br.com.store.stock.domain.Customer;

public interface SaveCustomerPort {
	Customer save(Customer customer);
}

package br.com.store.stock.adapter.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.store.stock.domain.Customer;
import br.com.store.stock.ports.in.RegisterCustomerUseCase;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	private RegisterCustomerUseCase registerCustomerUseCase;

	@PostMapping
	public ResponseEntity<Customer> register(@RequestBody Customer customer) {
		return ResponseEntity.ok(registerCustomerUseCase.register(customer));
	}

	@Autowired
	public void setRegisterCustomerUseCase(RegisterCustomerUseCase registerCustomerUseCase) {
		this.registerCustomerUseCase = registerCustomerUseCase;
	}
}

package br.com.store.customer.feign;

import br.com.store.customer.feign.dto.CustomerRequest;
import br.com.store.customer.feign.dto.CustomerResponse;
import feign.Headers;
import feign.RequestLine;

public interface CustomerApi {
	@RequestLine("POST /customers")
    @Headers("Content-Type: application/json")
    CustomerResponse createCustomer(CustomerRequest request);
}

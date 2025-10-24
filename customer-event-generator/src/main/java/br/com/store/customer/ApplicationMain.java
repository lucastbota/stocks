package br.com.store.customer;

import java.time.Instant;

import br.com.store.customer.feign.CustomerApi;
import br.com.store.customer.feign.dto.CustomerRequest;
import br.com.store.customer.feign.dto.CustomerResponse;
import br.com.store.customer.rabbitmq.CustomerEvent;
import br.com.store.customer.rabbitmq.event.RabbitMqPublisher;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public class ApplicationMain {

	 public static void main(String[] args) throws Exception {
	        // Configurar Feign
	        CustomerApi customerApi = Feign.builder()
	                .encoder(new GsonEncoder())
	                .decoder(new GsonDecoder())
	                .target(CustomerApi.class, "http://localhost:8080");

	        // Criar cliente
	        CustomerRequest request = new CustomerRequest("João da Silva", "joao@email.com");
	        CustomerResponse response = customerApi.createCustomer(request);

	        // Criar evento
	        CustomerEvent event = new CustomerEvent(response.id().toString(), "customer_created", Instant.now().toString());

	        // Publicar no RabbitMQ
	        RabbitMqPublisher publisher = new RabbitMqPublisher("localhost", "activity-log-queue");
	        publisher.publish(event);

	        System.out.println("Cliente criado e evento publicado!");
	    }
}

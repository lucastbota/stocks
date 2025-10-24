package br.com.store.customer.rabbitmq;

public record CustomerEvent(String id, String action, String timestamp) {

}

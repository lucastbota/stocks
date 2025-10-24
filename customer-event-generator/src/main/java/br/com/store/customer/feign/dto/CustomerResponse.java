package br.com.store.customer.feign.dto;

public record CustomerResponse(Long id, String name, String email) {
}
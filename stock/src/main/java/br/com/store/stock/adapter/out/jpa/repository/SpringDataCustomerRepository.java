package br.com.store.stock.adapter.out.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.store.stock.adapter.out.jpa.entity.CustomerJpaEntity;

public interface SpringDataCustomerRepository extends JpaRepository<CustomerJpaEntity, Long>{

}

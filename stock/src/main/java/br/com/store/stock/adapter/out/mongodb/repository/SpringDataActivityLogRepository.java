package br.com.store.stock.adapter.out.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.store.stock.adapter.out.mongodb.entity.ActivityLogMongoEntity;

public interface SpringDataActivityLogRepository extends MongoRepository<ActivityLogMongoEntity, String>{

}

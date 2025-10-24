package br.com.store.stock.adapter.out.mongodb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.store.stock.adapter.out.mongodb.entity.ActivityLogMongoEntity;
import br.com.store.stock.domain.ActivityLog;
import br.com.store.stock.ports.out.SaveActivityLogPort;

@Repository
public class ActivityLogRepositoryImpl implements SaveActivityLogPort {
	private   SpringDataActivityLogRepository repository;
	@Override
	public void save(ActivityLog log) {
		repository.save(ActivityLogMongoEntity.fromDomain(log));
	}
	
	@Autowired
	public void setRepository(SpringDataActivityLogRepository repository) {
		this.repository = repository;
	}

	
}

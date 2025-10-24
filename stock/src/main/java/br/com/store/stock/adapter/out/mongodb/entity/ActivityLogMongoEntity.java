package br.com.store.stock.adapter.out.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.store.stock.domain.ActivityLog;

@Document(collection = "activity_logs")
public class ActivityLogMongoEntity {
	@Id
	private String id;
	private String action;
	private String timestamp;

	public ActivityLogMongoEntity() {
	}

	public ActivityLogMongoEntity(String id, String action, String timestamp) {
		super();
		this.id = id;
		this.action = action;
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public static ActivityLogMongoEntity fromDomain(ActivityLog log) {
		return new ActivityLogMongoEntity(log.id(), log.action(), log.timestamp());
	}

	public ActivityLog toDomain() {
		return new ActivityLog(id, action, timestamp);
	}
}

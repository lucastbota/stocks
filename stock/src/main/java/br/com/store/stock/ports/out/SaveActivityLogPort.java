package br.com.store.stock.ports.out;

import br.com.store.stock.domain.ActivityLog;

public interface SaveActivityLogPort {
	void save(ActivityLog log);
}

package br.com.store.stock.ports.in;

import br.com.store.stock.domain.ActivityLog;

public interface RegisterActivityLogUseCase {
	void register(ActivityLog log);
}

package br.com.store.stock.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.stock.domain.ActivityLog;
import br.com.store.stock.ports.in.RegisterActivityLogUseCase;
import br.com.store.stock.ports.out.SaveActivityLogPort;

@Service
public class ActivityLogService implements RegisterActivityLogUseCase {
	private SaveActivityLogPort saveActivityLogPort;

	@Override
	public void register(ActivityLog log) {
		// muitas regras de negócios e validações
		saveActivityLogPort.save(log);
	}

	@Autowired
	public void setSaveActivityLogPort(SaveActivityLogPort saveActivityLogPort) {
		this.saveActivityLogPort = saveActivityLogPort;
	}
}

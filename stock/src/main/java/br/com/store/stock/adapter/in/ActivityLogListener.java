package br.com.store.stock.adapter.in;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.store.stock.domain.ActivityLog;
import br.com.store.stock.ports.in.RegisterActivityLogUseCase;

@Component
public class ActivityLogListener {
	private RegisterActivityLogUseCase registerActivityLogUseCase;

	@RabbitListener(queues = "activity-log-queue")
	public void receiveMessage(ActivityLog activityLog) {
		registerActivityLogUseCase.register(activityLog);
	}

	@Autowired
	public void setRegisterActivityLogUseCase(RegisterActivityLogUseCase registerActivityLogUseCase) {
		this.registerActivityLogUseCase = registerActivityLogUseCase;
	}
}

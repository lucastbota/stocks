package br.com.store.stock.adapter.out.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
	public static final String ACTIVITY_LOG_QUEUE = "activity-log-queue";

	@Bean
	public Queue activityLogQueue() {
		return new Queue(ACTIVITY_LOG_QUEUE, true); // durable
	}
	@Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
	
	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
	        ConnectionFactory connectionFactory,
	        Jackson2JsonMessageConverter messageConverter) {
	    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
	    factory.setConnectionFactory(connectionFactory);
	    factory.setMessageConverter(messageConverter);
	    return factory;
	}
}

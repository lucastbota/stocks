package br.com.store.customer.rabbitmq.event;

import com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import br.com.store.customer.rabbitmq.CustomerEvent;

public class RabbitMqPublisher {
	private final String queueName;
	private final Channel channel;
	private final Gson gson = new Gson();

	public RabbitMqPublisher(String host, String queueName) throws Exception {
		this.queueName = queueName;
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		Connection connection = factory.newConnection();
		this.channel = connection.createChannel();
		// Garante que a fila existe
		channel.queueDeclare(queueName, true, false, false, null);
	}

	public void publish(CustomerEvent event) throws Exception {
		String message = gson.toJson(event);
		channel.basicPublish("", queueName, new AMQP.BasicProperties.Builder()
			    .contentType("application/json")
			    .build(), message.getBytes());
	}
}

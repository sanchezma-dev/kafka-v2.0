package app.kafka.notificacionConsumer.service;

import app.kafka.notificacionConsumer.models.Usuario;

public interface IKafkaConsumerService {

	
	public void consume(final Usuario usuario);
	
}

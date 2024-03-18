package app.kafka.notificacionConsumer.service;

import app.kafka.notificacionConsumer.models.Usuario;

public interface IKafkaConsumerService {

	/** Consume topic message */
	public void consume(final String message);

	/** Se encarga de consumir el topic enviado */
	public void consume(final Usuario usuario);

	
}

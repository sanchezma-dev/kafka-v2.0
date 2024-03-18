package app.kafka.usuarioProducer.service;

import app.kafka.usuarioProducer.models.Usuario;

public interface IKafkaProducerService {

	/**
	 * Envia el mensaje (String) mediante kakfa
	 * @param message
	 */
	public void pushMessageToKafka(final String message);


	/**
	 * Envia el mensaje (Usuario) mediante kakfa
	 * @param usuario
	 */
	public void pushMessageToKafka(final Usuario usuario);
}

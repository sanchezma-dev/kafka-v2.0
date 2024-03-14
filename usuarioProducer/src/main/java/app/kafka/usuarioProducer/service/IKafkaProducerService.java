package app.kafka.usuarioProducer.service;

import app.kafka.usuarioProducer.models.Usuario;

public interface IKafkaProducerService {

	public void envioMessageUsuario(final Usuario usuario);
}

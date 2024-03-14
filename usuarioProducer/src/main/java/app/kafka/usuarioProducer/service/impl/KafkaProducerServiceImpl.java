package app.kafka.usuarioProducer.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import app.kafka.usuarioProducer.models.Usuario;
import app.kafka.usuarioProducer.service.IKafkaProducerService;

@Component
public class KafkaProducerServiceImpl implements IKafkaProducerService {
	
	private Logger log = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);
	
	@Autowired
	private KafkaTemplate<String, Usuario> kafkaTemplate;
	
	@Value("${spring.kafka.topic.name}")
	private String topicName;

	@Override
	public void envioMessageUsuario(Usuario usuario) {
		log.info("Envio de mensaje de usuario con email: " + usuario.getEmail());
		kafkaTemplate.send(topicName, usuario);
	}

}

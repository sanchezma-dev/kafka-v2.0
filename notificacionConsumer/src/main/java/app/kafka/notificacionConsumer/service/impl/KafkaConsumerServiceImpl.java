package app.kafka.notificacionConsumer.service.impl;

import app.kafka.notificacionConsumer.models.Usuario;
import app.kafka.notificacionConsumer.service.IKafkaConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerServiceImpl implements IKafkaConsumerService{

	/** Log */
	private Logger log = LoggerFactory.getLogger(KafkaConsumerServiceImpl.class);

	@Override
	@KafkaListener(topics = "${spring.kafka.topic2.name}", containerFactory = "beanStringContainerFactory", groupId = "${spring.kafka.consumer.message.groupId}")
	public void consume(String message) {
		log.info("Mensaje recibido: {}", message);
	}

	@Override
	@KafkaListener(topics = "${spring.kafka.topic.name}", containerFactory = "beanUserContainerFactory", groupId = "${spring.kafka.consumer.user.groupId}")
    public void consume(Usuario usuario) {
		log.info("Usuario con nombre y email {}/{} recibido", usuario.getNombre(), usuario.getEmail());
    }

}

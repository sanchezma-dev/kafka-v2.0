package app.kafka.notificacionConsumer.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import app.kafka.notificacionConsumer.models.Usuario;
import app.kafka.notificacionConsumer.service.IKafkaConsumerService;

@Component
public class KafkaConsumerServiceImpl implements IKafkaConsumerService{
	
	private Logger log = LoggerFactory.getLogger(KafkaConsumerServiceImpl.class);

	@Override
	@KafkaListener(topics = "${spring.kafka.topic.name}", containerFactory = "kafkaTopic", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Usuario usuario) {
		System.out.print("Entra en consume");
        log.info("Data - " + usuario.toString() + " recieved");
    }

}

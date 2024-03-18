package app.kafka.usuarioProducer.service.impl;

import app.kafka.usuarioProducer.models.Usuario;
import app.kafka.usuarioProducer.service.IKafkaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerServiceImpl implements IKafkaProducerService {
	
	private Logger log = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);

	/** KafkaTemplate para Usuario */
	@Autowired
	private KafkaTemplate<String, Usuario> kafkaTemplate;

	/** KafkaTemplate para message (String) */
	@Autowired
	private KafkaTemplate<String, String> kafkaStringTemplate;

	/** Topic Usuario kafka del envio */
	@Value("${spring.kafka.topic.name}")
	private String topicName;

	/** Topic String kafka del envio */
	@Value("${spring.kafka.topic2.name}")
	private String topicMessage;


	@Override
	public void pushMessageToKafka(String message) {
		log.info("Mensaje enviado: {}", message);
		kafkaStringTemplate.send(topicMessage, message);
	}

	@Override
	public void pushMessageToKafka(final Usuario usuario) {
		log.info("Mensaje enviado del usuario: " + usuario.toString());
		kafkaTemplate.send(topicName, usuario);
	}

}

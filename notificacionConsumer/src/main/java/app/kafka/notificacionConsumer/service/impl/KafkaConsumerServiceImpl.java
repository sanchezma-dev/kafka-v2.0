package app.kafka.notificacionConsumer.service.impl;

import app.kafka.notificacionConsumer.models.Usuario;
import app.kafka.notificacionConsumer.models.UsuarioEntity;
import app.kafka.notificacionConsumer.repository.UsuarioRepository;
import app.kafka.notificacionConsumer.service.IKafkaConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class KafkaConsumerServiceImpl implements IKafkaConsumerService{

	/** Log */
	private Logger log = LoggerFactory.getLogger(KafkaConsumerServiceImpl.class);

	/** Repository */
	@Autowired
	private UsuarioRepository repo;

	/** Constantes usuario */
	private final String NAMEGENERIC = "NAME-GENERICO";
	private final String LASTNAMEGENERIC = "LASTNAME-GENERICO";
	private final String EMAILGENERIC = "NAME-GENERICO";

	@Override
	@KafkaListener(topics = "${spring.kafka.topic2.name}", containerFactory = "beanStringContainerFactory", groupId = "${spring.kafka.consumer.message.groupId}")
	public void consume(String message) {
		log.info("Mensaje recibido: {}", message);
		/** Create user*/
		final UsuarioEntity uEntity = createUserGeneric();
		uEntity.setMessage(message);
		repo.save(uEntity);
		log.info("Usuario guardado: {}", uEntity.getName());

	}

	@Override
	@KafkaListener(topics = "${spring.kafka.topic.name}", containerFactory = "beanUserContainerFactory", groupId = "${spring.kafka.consumer.user.groupId}")
    public void consume(Usuario usuario) {
		log.info("Usuario con nombre y email {}/{} recibido", usuario.getNombre(), usuario.getEmail());
		repo.save(convertUser(usuario));
		log.info("Usuario guardado: {}", usuario.getNombre());
    }

	/* Metodos privados */
	private UsuarioEntity createUserGeneric(){
		final UsuarioEntity u = new UsuarioEntity();
		u.setName(NAMEGENERIC);
		u.setLastName(LASTNAMEGENERIC);
		u.setEmail(EMAILGENERIC);
		u.setFecha(LocalDate.now());

		return u;
	}

	private UsuarioEntity convertUser(final Usuario data){
		final UsuarioEntity u = new UsuarioEntity();
		u.setName(data.getNombre());
		u.setLastName(data.getApellidos());
		u.setEmail(data.getEmail());
		u.setFecha(LocalDate.now());

		return u;
	}

}

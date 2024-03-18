package app.kafka.usuarioProducer.controller;

import app.kafka.usuarioProducer.models.Usuario;
import app.kafka.usuarioProducer.service.IKafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka/v2")
public class UsuarioController {

	/** Servicio producer Kafka */
	@Autowired
	private IKafkaProducerService serviceKafka;

	@PostMapping(value="/sendMessage")
	public ResponseEntity<?> sendMessage(@RequestParam("message") String message) {
		serviceKafka.pushMessageToKafka(message);
		return ResponseEntity.ok("Message kafka envidado");
	}
	
	@PostMapping(value="/sendUser")
	public ResponseEntity<?> sendUser(@RequestBody Usuario usuario) {
		serviceKafka.pushMessageToKafka(usuario);
		return ResponseEntity.ok("Usuario enviado con éxito a Kafka.");
	}
}

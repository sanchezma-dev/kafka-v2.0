package app.kafka.usuarioProducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.kafka.usuarioProducer.models.Usuario;
import app.kafka.usuarioProducer.service.IKafkaProducerService;

@RestController
@RequestMapping("/kafka/v2")
public class UsuarioController {

	
	@Autowired
	private IKafkaProducerService serviceKafka;
	
	@PostMapping(value="/envioUsuario")
	public ResponseEntity<?> sendUser(@RequestBody Usuario usuario) {
		serviceKafka.envioMessageUsuario(usuario);
		return ResponseEntity.ok("Usuario enviado con éxito a Kafka.");
	}
}

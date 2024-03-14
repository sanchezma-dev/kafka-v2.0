package app.kafka.usuarioProducer.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Usuario {
	
	private String nombre;

	private String apellidos;

	private String email;

}

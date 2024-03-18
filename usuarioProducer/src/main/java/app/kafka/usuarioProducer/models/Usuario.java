package app.kafka.usuarioProducer.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class Usuario {
	/** Atributos */
	private String nombre;
	private String apellidos;
	private String email;

}

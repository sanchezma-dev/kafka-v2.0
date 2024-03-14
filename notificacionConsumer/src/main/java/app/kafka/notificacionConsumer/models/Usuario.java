package app.kafka.notificacionConsumer.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Usuario {
	
	private String nombre;

	private String apellidos;

	private String email;

}

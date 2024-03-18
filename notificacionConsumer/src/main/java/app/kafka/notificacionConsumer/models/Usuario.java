package app.kafka.notificacionConsumer.models;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
public class Usuario {
	/** Atributos */
	private String nombre;
	private String apellidos;
	private String email;
	private LocalDate fecha;

}

package app.kafka.notificacionConsumer.models;

import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Clase encargada de deserializar el objeto Usuario y evitar así problemas con la deserialización
 */
public class UsuarioDeserializer implements Deserializer<Usuario>{
	
	/** Interfaz de deserializador personalizado */
	private final JsonDeserializer<Usuario> jsonDeserializer;

	public UsuarioDeserializer() {
		this.jsonDeserializer = new JsonDeserializer<>(new TypeReference<Usuario>() {});
	}

	@Override
	public Usuario deserialize(final String topic, final byte[] data) {
		return this.jsonDeserializer.deserialize(topic, data);
	}

}

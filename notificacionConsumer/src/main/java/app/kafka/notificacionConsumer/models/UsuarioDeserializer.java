package app.kafka.notificacionConsumer.models;

import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.fasterxml.jackson.core.type.TypeReference;

public class UsuarioDeserializer implements Deserializer<Usuario>{
	
	
	private final JsonDeserializer<Usuario> jsonDeserializer;

	public UsuarioDeserializer() {
		this.jsonDeserializer = new JsonDeserializer<>(new TypeReference<Usuario>() {});
	}

	@Override
	public Usuario deserialize(String topic, byte[] data) {
		return this.jsonDeserializer.deserialize(topic, data);
	}

}

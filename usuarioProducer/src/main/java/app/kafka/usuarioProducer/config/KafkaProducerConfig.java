package app.kafka.usuarioProducer.config;

import app.kafka.usuarioProducer.models.Usuario;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

	/** Url del servidor kafka */
	@Value("${spring.kafka.producer.bootstrap-servers}")
	private String kafkaServer;

	/**********************************************************
			Props JsonSerializer (Objecto Usuario)
	 *********************************************************/
	@Bean
	public ProducerFactory<String, Usuario> producerFactory() {
		Map<String, Object> propiedadesProducer = new HashMap<>();
		propiedadesProducer.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
		propiedadesProducer.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		propiedadesProducer.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return new DefaultKafkaProducerFactory<>(propiedadesProducer);
	}

	@Bean
	public KafkaTemplate<String, Usuario> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	/**********************************************************
	 		Props StringSerializer (Cadena message)
	 *********************************************************/

	@Bean
	public ProducerFactory<String, String> producerStringFactory() {
		Map<String, Object> propsStringProducer = new HashMap<>();
		propsStringProducer.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
		propsStringProducer.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		propsStringProducer.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		return new DefaultKafkaProducerFactory<>(propsStringProducer);
	}

	@Bean
	public KafkaTemplate<String, String> kafkaStringTemplate() {
		return new KafkaTemplate<>(producerStringFactory());
	}

}

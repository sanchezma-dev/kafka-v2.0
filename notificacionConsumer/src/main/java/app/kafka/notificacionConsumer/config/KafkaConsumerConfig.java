package app.kafka.notificacionConsumer.config;

import app.kafka.notificacionConsumer.models.Usuario;
import app.kafka.notificacionConsumer.models.UsuarioDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	/** Url del servidor kafka */
	@Value("${spring.kafka.consumer.bootstrap-servers}")
	private String kafkaServer;

	/**********************************************************
		Props JsonSerializer (Objecto Usuario)
	 *********************************************************/
	@Bean
	public ConsumerFactory<String, Usuario> consumerFactory() {
        Map<String, Object> propiedadesConsumer = new HashMap<>();
        propiedadesConsumer.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        propiedadesConsumer.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propiedadesConsumer.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(propiedadesConsumer, new StringDeserializer(), new UsuarioDeserializer());
    }

	@Bean(name = "beanUserContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<String, Usuario> userKafkaListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Usuario> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	/**********************************************************
		Props StringSerializer (Cadena message)
	 *********************************************************/
	@Bean
	public ConsumerFactory<String, String> consumerStringFactory() {
		Map<String, Object> propiedadesConsumer = new HashMap<>();
		propiedadesConsumer.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
		propiedadesConsumer.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		propiedadesConsumer.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(propiedadesConsumer, new StringDeserializer(), new StringDeserializer());
	}

	@Bean(name = "beanStringContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<String, String> stringKafkaListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerStringFactory());
		return factory;
	}






}

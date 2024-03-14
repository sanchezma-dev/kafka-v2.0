package app.kafka.notificacionConsumer.config;

import java.util.HashMap;
import java.util.Map;

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

import app.kafka.notificacionConsumer.models.Usuario;
import app.kafka.notificacionConsumer.models.UsuarioDeserializer;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	@Value("${spring.kafka.consumer.bootstrap-servers}")
	private String kafkaServer;
	
	@Value("${spring.kafka.consumer.group-id}")
	private String idGroup;
	
	@Bean
	public ConsumerFactory<String, Usuario> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        //JsonDeserializer<Usuario> jsonDeserializer = new JsonDeserializer<>();
       //nDeserializer.addTrustedPackages("*");
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        //props.put(ConsumerConfig.GROUP_ID_CONFIG, idGroup);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        //props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
        		new UsuarioDeserializer());
    }

	@Bean(name = "kafkaTopic")
	public ConcurrentKafkaListenerContainerFactory<String, Usuario> userKafkaListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Usuario> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}

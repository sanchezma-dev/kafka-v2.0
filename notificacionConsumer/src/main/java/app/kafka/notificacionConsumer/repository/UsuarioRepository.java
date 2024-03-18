package app.kafka.notificacionConsumer.repository;

import app.kafka.notificacionConsumer.models.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}

package proymet.Repository;

import proymet.Models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    List<UsuarioModel> findByRol(String rol);
}
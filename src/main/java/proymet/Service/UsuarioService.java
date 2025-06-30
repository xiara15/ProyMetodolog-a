package proymet.Service;

import proymet.DTO.UsuarioDto;
import proymet.Models.UsuarioModel;


import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    /**
     * Guarda un nuevo usuario.
     */
    UsuarioModel save(UsuarioDto usuarioDto);

    /**
     * Devuelve todos los usuarios de la base de datos.
     */
    List<UsuarioModel> getAll();

    /**
     * Busca un usuario por ID.
     */
    Optional<UsuarioModel> getById(Long id);

    /**
     * Marca como inactivo a un usuario (baja lógica).
     */
    void bajaLogica(Long id);

    /**
     * Actualiza los datos de un usuario existente.
     */
    UsuarioModel actualizarUsuario(Long id, UsuarioDto dto);

    /**
     * Devuelve una lista de usuarios por su rol.
     */
    List<UsuarioModel> obtenerUsuariosPorRol(String rol);
}

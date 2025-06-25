package Service;


import Usuario.Model.Usuario;
import Usuario.dto.UsuarioDto;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario crearUsuario(UsuarioDto usuarioDto);
    Optional<Usuario> obtenerUsuarioPorId(Long id);
    List<Usuario> obtenerUsuariosPorRol(int rol);
    Usuario actualizarUsuario(Long id, UsuarioDto usuarioDto);
    void eliminarUsuario(Long id);
}
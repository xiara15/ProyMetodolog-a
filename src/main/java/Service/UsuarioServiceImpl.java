package Service;


import Usuario.Models.Usuario;
import Usuario.Repository.UsuarioRepository;
import Usuario.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(UsuarioDto dto) {
        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(dto.getNombreCompleto());
        usuario.setCorreoElectronico(dto.getCorreoElectronico());
        usuario.setRol(dto.getRol());
        usuario.setHoraEntrada(dto.getHoraEntrada());
        usuario.setHoraSalida(dto.getHoraSalida());
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> obtenerUsuariosPorRol(int rol) {
        return usuarioRepository.findByRol(rol);
    }

    @Override
    public Usuario actualizarUsuario(Long id, UsuarioDto dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setNombreCompleto(dto.getNombreCompleto());
        usuario.setCorreoElectronico(dto.getCorreoElectronico());
        usuario.setRol(dto.getRol());
        usuario.setHoraEntrada(dto.getHoraEntrada());
        usuario.setHoraSalida(dto.getHoraSalida());
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
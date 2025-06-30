package proymet.Service;

import proymet.DTO.UsuarioDto;
import proymet.Models.UsuarioModel;
import proymet.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioModel save(UsuarioDto usuarioDto) {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNombreCompleto(usuarioDto.getNombreCompleto());
        usuario.setCorreoElectronico(usuarioDto.getCorreoElectronico());
        usuario.setRol(usuarioDto.getRol());
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<UsuarioModel> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<UsuarioModel> getById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void bajaLogica(Long id) {
        usuarioRepository.findById(id).ifPresent(usuario -> {
            usuario.setHoraEntrada(LocalTime.now()); // Asigna la hora actual
            usuarioRepository.save(usuario);
        });
    }

    @Override
    public UsuarioModel actualizarUsuario(Long id, UsuarioDto dto) {
        UsuarioModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setNombreCompleto(String.valueOf(dto.getClass()));
        usuario.setCorreoElectronico(String.valueOf(dto.getClass()));
        usuario.setRol(dto.getRol());
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<UsuarioModel> obtenerUsuariosPorRol(String rol) {
        return usuarioRepository.findByRol(rol);
    }
}

package proymet.Controller;

import proymet.Models.UsuarioModel;
import proymet.Service.UsuarioService;
import proymet.DTO.UsuarioDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuario Controller", description = "Operaciones relacionadas con usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Crear un nuevo usuario")
    @PostMapping
    public ResponseEntity<UsuarioModel> crearUsuario(@RequestBody UsuarioDto usuarioDto) {
        UsuarioModel nuevoUsuario = usuarioService.save(usuarioDto);
        return ResponseEntity.status(201).body(nuevoUsuario);
    }

    @Operation(summary = "Obtener todos los usuarios")
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> obtenerTodos() {
        List<UsuarioModel> usuarios = usuarioService.getAll();
        return ResponseEntity.ok(usuarios);
    }

    @Operation(summary = "Obtener un usuario por ID")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> obtenerPorId(@PathVariable Long id) {
        return usuarioService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Obtener usuarios por rol")
    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<UsuarioModel>> obtenerPorRol(@PathVariable String rol) {
        List<UsuarioModel> usuarios = usuarioService.obtenerUsuariosPorRol(rol);
        return ResponseEntity.ok(usuarios);
    }

    @Operation(summary = "Actualizar un usuario existente")
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        try {
            UsuarioModel actualizado = usuarioService.actualizarUsuario(id, usuarioDto);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar usuario: " + e.getMessage());
        }
    }

    @Operation(summary = "Eliminar (lógicamente) un usuario")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        try {
            usuarioService.bajaLogica(id);
            return ResponseEntity.ok("Usuario dado de baja correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al dar de baja usuario: " + e.getMessage());
        }
    }
}
package proymet.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private String nombreCompleto;
    private String correoElectronico;
    private String rol;
    private Number horaEntrada;
    private Number horaSalida;

}
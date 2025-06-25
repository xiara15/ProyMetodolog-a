package DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private String nombreCompleto;
    private String correoElectronico;
    private int rol;
    private int horaEntrada;
    private int horaSalida;
}
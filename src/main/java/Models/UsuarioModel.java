package Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_completo", length = 255, nullable = false)
    private String nombreCompleto;

    @Column(name = "correo_electronico", length = 100, nullable = false, unique = true)
    private String correoElectronico;

    @Column(nullable = false)
    private int rol;

    @Column(name = "hora_entrada", nullable = false)
    private int horaEntrada;

    @Column(name = "hora_salida", nullable = false)
    private int horaSalida;
}
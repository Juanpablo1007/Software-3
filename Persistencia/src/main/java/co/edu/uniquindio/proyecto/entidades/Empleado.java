package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empleado implements Serializable {

    @Column(nullable = false, length = 255)
    @Id
    private String id;
    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false,length = 255)
    private String apellido;

    @Column(nullable = false,length = 255)
    private String direccion;

    @Column(nullable = false, length = 255)
    private String correo;
    @Column(length = 20)
    private String telefono;

    @Column(length = 20)
    private String contrasenia;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo_Documento tipoDocumento;
    @OneToMany(mappedBy="empleado", cascade = CascadeType.ALL)
    private List<Factura> facturas;
    public Empleado(String id, String nombre, String apellido, String direccion, String correo,
                    String telefono, String contrasenia, Tipo_Documento tipoDocumento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.tipoDocumento = tipoDocumento;
    }
}
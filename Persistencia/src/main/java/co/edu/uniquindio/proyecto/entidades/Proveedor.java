package co.edu.uniquindio.proyecto.entidades;
import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Proveedor implements Serializable{

    @Column(nullable = false, length = 255)
    @Id
    private String id_proveedor;
    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String direccion;

    @Column(nullable = false, length = 255)
    private String correo;

    @Column(nullable = false, length = 255)
    private String telefono;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo_Documento tipoDocumento;
    @OneToMany(mappedBy="proveedor")
    private List<Producto> productos;
}

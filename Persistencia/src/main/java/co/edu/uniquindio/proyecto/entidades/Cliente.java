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
public class Cliente implements Serializable{
    @Column(nullable = false, length = 255)
    @Id
    private String id_cliente;
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
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo_Documento tipoDocumento;
    @OneToMany(mappedBy="cliente")
    private List<Factura> facturas;
}

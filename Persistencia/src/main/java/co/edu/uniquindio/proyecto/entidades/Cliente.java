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

    @Column(nullable = false, length = 255, unique = true)
    private String correo;
    @Column(length = 20)
    private String telefono;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo_Documento tipoDocumento;
    @OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
    private List<Factura> facturas;
    public Cliente(String id_cliente, String nombre, String apellido, String direccion, String correo, String telefono, Tipo_Documento tipoDocumento) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoDocumento = tipoDocumento;
    }

}

package co.edu.uniquindio.proyecto.entidades;
import javax.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class detalle_Factura implements Serializable{
    @Column(nullable = false, length = 255)
    @Id
    private String facturas_codigo;
    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String direccion;

    @Column(nullable = false, length = 255)
    private String correo;

    @Column(nullable = false, length = 255)
    private String telefono;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Factura
            factura;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto
            producto;
}


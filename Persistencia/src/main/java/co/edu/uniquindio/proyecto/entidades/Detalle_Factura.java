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
public class Detalle_Factura implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 50)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 50)
    private int cantidad;

    @Column(nullable = false, length = 50)
    private double precio_unidad;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Factura factura;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;
}


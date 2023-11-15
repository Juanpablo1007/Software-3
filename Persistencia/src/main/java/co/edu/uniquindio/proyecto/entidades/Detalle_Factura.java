package co.edu.uniquindio.proyecto.entidades;
import javax.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Detalle_Factura implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 50)
    @EqualsAndHashCode.Include
    private Integer codigo;

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
    public Detalle_Factura(int cantidad, double precio_unidad, Factura factura, Producto producto) {
        this.cantidad = cantidad;
        this.precio_unidad = precio_unidad;
        this.factura = factura;
        this.producto = producto;
    }
    @Override
    public String toString() {
        return "Detalle_Factura{" +
                "codigo: " + codigo +
                ", cantidad de productos: " + cantidad +
                ", precio por unidad: " + precio_unidad +
                ", factura: " + (factura != null ? factura.getCodigo() : null) +
                ", producto: " + (producto != null ? producto.getNombre() : null) +
                '}';
    }
}


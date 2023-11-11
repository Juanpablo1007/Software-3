package co.edu.uniquindio.proyecto.entidades;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Factura implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 50)
    @EqualsAndHashCode.Include
    private Integer codigo;
    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false,length = 10)
    private double valor_total;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Empleado empleado;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo_Factura tipoFactura;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<Detalle_Factura> productos;
    public Factura(Date fecha, double valor_total, Cliente cliente, Empleado empleado, Tipo_Factura tipoFactura, List<Detalle_Factura> productos) {
        this.fecha = fecha;
        this.valor_total = valor_total;
        this.cliente = cliente;
        this.empleado = empleado;
        this.tipoFactura = tipoFactura;
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo=" + codigo +
                ", fecha=" + fecha +
                ", valor_total=" + valor_total +
                ", cliente=" + (cliente != null ? cliente.getNombre() : null) +
                ", empleado=" + (empleado != null ? empleado.getNombre() : null) +
                ", tipoFactura=" + tipoFactura +
                ", productos=" + productos +
                '}';
    }








        }

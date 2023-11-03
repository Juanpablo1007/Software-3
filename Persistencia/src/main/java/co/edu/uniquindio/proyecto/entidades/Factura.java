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
    private int codigo;
    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false,length = 10)
    private double valor_total;

    @Column(nullable = false,length = 255)
    private String direccion;

    @Column(nullable = false, length = 255)
    private String correo;
    @Column(length = 20)
    private String telefono;

    @Column(length = 20)
    private String contrasenia;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente
            Cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Empleado
           empleado;

    @Enumerated (EnumType.STRING)
    private Tipo_Factura tipoFactura;
    @OneToMany(mappedBy="factura")
    private List<detalle_Factura> detalleFacturas;


}

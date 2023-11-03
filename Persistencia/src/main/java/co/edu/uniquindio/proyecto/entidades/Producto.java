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
public class Producto  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 50)
    @EqualsAndHashCode.Include
    private int codigo;
    @Column(nullable = false, length = 255)
    private String nombre;
    @Column(nullable = false,length = 10)
    private double precio_maximo;

    @Column(nullable = false,length = 10)
    private double precio_minimo;
    @Column(nullable = false)
    private int stock;


    @Column(nullable = false)

    private Categoria categoria;




    @ManyToOne
    @JoinColumn(nullable = false)
    private Proveedor proveedor;
    @OneToMany(mappedBy="producto")
    private List<detalle_Factura> detalleFacturas;

}


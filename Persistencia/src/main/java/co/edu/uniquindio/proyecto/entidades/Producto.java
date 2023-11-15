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

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 50)
    @EqualsAndHashCode.Include
    private Integer codigo;
    @Column(nullable = false, length = 255,unique = true)
    private String nombre;
    @Column(nullable = false,length = 10)
    private Double precio_maximo;

    @Column(nullable = false,length = 10)
    private Double precio_minimo;
    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "proveedor_documento")
    private Proveedor proveedor;
    @OneToMany(mappedBy="producto", cascade = CascadeType.ALL)
    private List<Detalle_Factura> facturas;

    public Producto(Integer codigo,String nombre,Double precio_minimo,Double precio_maximo,Categoria categoria,Proveedor proveedor,Integer stock) {
        this.codigo = codigo;
        this.nombre =nombre;
        this.precio_maximo =precio_maximo;
        this.precio_minimo = precio_minimo;
        this.categoria=categoria;
        this.proveedor =proveedor;
        this.stock = stock;


    }
    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio_maximo=" + precio_maximo +
                ", precio_minimo=" + precio_minimo +
                ", stock=" + stock +
                ", categoria=" + categoria +
                '}';
    }

}


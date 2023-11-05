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

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Proveedor implements Serializable{

    @Column(nullable = false, length = 255)
    @Id
    private String documento;
    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String direccion;

    @Column(nullable = false, length = 255,unique = true)
    private String correo;

    @Column(nullable = false, length = 255)
    private String telefono;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo_Documento tipoDocumento;
    @OneToMany(mappedBy="proveedor",cascade =  CascadeType.ALL)
    private List<Producto> productos;
    @Override
    public String toString() {
        return "Proveedor{" +
                "documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }


}


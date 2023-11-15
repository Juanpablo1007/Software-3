package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Carrito {
    private int cantindad ;

    private String producto;

    private  Double valorUnidad;

    private  Double valorTotal;

}

package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Detalle_Factura;
import co.edu.uniquindio.proyecto.entidades.Factura;
import co.edu.uniquindio.proyecto.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
public interface Detalle_FacturaRepo extends JpaRepository<Detalle_Factura, Integer> {
    List<Detalle_Factura> findAll();


    Optional<Detalle_Factura> findById(Integer integer);
}

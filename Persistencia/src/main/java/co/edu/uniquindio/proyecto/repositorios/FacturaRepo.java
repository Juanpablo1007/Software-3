package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Factura;
import co.edu.uniquindio.proyecto.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FacturaRepo  extends JpaRepository<Factura, Integer> {
    Optional<Factura> findByCodigo(Integer codigo);
    List<Factura> findAllByEmpleado_Nombre(String nombre);

    List<Factura> findAll();

    List<Factura> findAllByCliente_NombreAndFecha (String nombre, Date fecha);
    List<Factura> findAllByCliente_Nombre(String nombre);

    List<Factura> findAllByFecha ( Date fecha);

    List<Factura> findAllByOrderByCodigoDesc();

    List<Factura> findAllByCodigo(Integer codigo);
}

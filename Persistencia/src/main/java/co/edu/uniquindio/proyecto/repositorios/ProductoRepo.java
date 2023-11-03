package co.edu.uniquindio.proyecto.repositorios;
import co.edu.uniquindio.proyecto.entidades.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
@Repository
public interface ProductoRepo extends  JpaRepository <Producto, Integer> {
    List<Producto> findAll();
    List <Producto> findAllByNombreContainsIgnoreCase(String nombre);
    List <Producto> findByCodigo(Integer Codigo);

    List<Producto> findAllByCategoria(String categoria);



}

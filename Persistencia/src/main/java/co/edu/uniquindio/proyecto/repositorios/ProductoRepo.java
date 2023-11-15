package co.edu.uniquindio.proyecto.repositorios;
import co.edu.uniquindio.proyecto.entidades.*;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;

@Repository
public interface ProductoRepo extends  JpaRepository <Producto, Integer> {
    List<Producto> findAll();
    Optional<Producto> findByNombreAndCodigo(String nombre, Integer codigo);


    Optional<Producto> findById(Integer integer);

    Optional<Producto> findByNombre(String nombre);


    List<Producto> findAllByCategoria(Categoria categoria);
    Optional<Producto> findByNombreAndAndCodigoAndCategoria(String nombre,Integer codigo,Categoria categoria );


    List<Producto> findAllByNombre(String text);




    List<Producto> findAllByCodigo(Integer codigo);

    List<Producto> findAllByNombreAndCodigo(String nombre, Integer codigo);

    List<Producto> findAllByNombreAndCodigoAndCategoria(String nombre, Integer codigo, String categoria);

    List<Producto> findAllByNombreAndCategoria(String nombre, String categoria);

    List<Producto> findAllByCodigoAndCategoria(Integer codigo, String categoria);
}

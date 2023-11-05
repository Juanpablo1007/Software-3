package co.edu.uniquindio.proyecto.repositorios;
import co.edu.uniquindio.proyecto.entidades.*;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;

@Repository
public interface ProductoRepo extends  JpaRepository <Producto, Integer> {
    List<Producto> findAll();


    Optional<Producto> findById(Integer integer);

    Optional<Producto> findByNombre(String nombre);


    List<Producto> findAllByCategoria(Categoria categoria);
    Optional<Producto> findByNombreAndAndCodigoAndCategoria(String nombre,Integer codigo,Categoria categoria );



}

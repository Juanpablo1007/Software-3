package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.*;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import co.edu.uniquindio.proyecto.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Cliente, String> {

    List<Cliente>findAll();


    Optional<Cliente> findById(String s);
    List<Cliente> findAllByNombre(String nombre);

    List<Cliente> findAllByTipoDocumento(Tipo_Documento tipoDocumento);



}

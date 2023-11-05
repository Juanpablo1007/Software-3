package co.edu.uniquindio.proyecto.repositorios;
import co.edu.uniquindio.proyecto.entidades.*;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;

@Repository
public interface EmpleadoRepo extends  JpaRepository <Empleado, String>{

    Optional<Empleado> findByCorreoAndAndContrasenia(String correo, String contrasenia);

    Optional<Empleado> findById(String id);
    Optional<Empleado> findByNombreAndIdAndCorreo(String nombre, String id ,String correo);

    List <Empleado> findAllByNombre(String nombre);
    Optional<Empleado> findByCorreo(String correo);

    List <Empleado> findAll();



}

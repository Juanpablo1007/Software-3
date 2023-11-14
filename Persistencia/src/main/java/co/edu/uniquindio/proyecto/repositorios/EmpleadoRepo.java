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
    List <Empleado> findAllByNombreAndIdAndCorreo(String nombre,String id,String correo);
    Optional<Empleado> findByCorreo(String correo);
    List <Empleado>  findAllByCorreo(String correo);
    List <Empleado> findAllById(String id);
    List <Empleado> findAll();



}

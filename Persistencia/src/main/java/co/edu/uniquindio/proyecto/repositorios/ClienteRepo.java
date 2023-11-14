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


    Optional<Cliente> findByIdcliente(String s);
    List<Cliente>findAllByIdcliente(String s);
    Optional<Cliente> findByCorreo(String correo);
    List<Cliente> findAllByNombre(String nombre);

    List<Cliente> findAllByTipoDocumento(Tipo_Documento tipoDocumento);


    Optional<Cliente> findByIdclienteAndCorreo(String text, String text1);
    Optional<Cliente> findByNombreAndIdclienteAndCorreo(String nombre,String text, String text1);

    List<Cliente> findAllByCorreo(String correo);

    List<Cliente> findAllByNombreAndIdclienteAndCorreo(String nombre, String  id_cliente, String correo);

    List<Cliente> findAllByNombreAndIdcliente(String nombre, String  id_cliente);

    List<Cliente> findAllByNombreAndCorreo(String nombre, String correo);

    List<Cliente> findAllByIdclienteAndCorreo(String  id_cliente, String correo);
}

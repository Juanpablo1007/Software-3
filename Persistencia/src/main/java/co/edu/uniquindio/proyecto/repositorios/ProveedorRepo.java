package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface ProveedorRepo extends JpaRepository <Proveedor, String>{

    List<Proveedor> findAll();
    List<Proveedor> findAllByDocumento(String id);
    List <Proveedor> findAllByNombre(String nombre);
    Optional<Proveedor> findByDocumento(String Documento);

    Optional<Proveedor> findByCorreo(String Correo);
    Optional<Proveedor> findByNombreAndDocumentoAndCorreo(String nombre,String Documento,String Correo);
    List <Proveedor> findAllByTipoDocumento(Tipo_Documento tipoDocumento);

    List <Proveedor> findAllByCorreo(String correo);

    List <Proveedor> findAllByNombreAndDocumentoAndCorreo(String nombre, String id, String correo);

    List <Proveedor> findAllByNombreAndDocumento(String nombre, String id);

    List <Proveedor> findAllByNombreAndCorreo(String nombre, String correo);

    List <Proveedor>findAllByDocumentoAndCorreo(String id, String correo);

    Optional<Proveedor> findByDocumentoAndCorreo(String text, String text1);
}

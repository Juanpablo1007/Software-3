package co.edu.uniquindio.proyecto.Servicios;
import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;

import java.util.List;

public interface ClienteServicio {
    void CrearCliente (Cliente cliente) throws Exception;

    void eliminarCliente (String cedula) throws Exception;

    void actualizarCliente(String nombre, String direccion, String correo, String telefono, String cedula) throws Exception;

    boolean VerificarActualizarcion (String cedula) throws Exception;

Cliente buscarIdCliente (String cedula) throws Exception;
    List<Cliente> buscarClientesNombre (String nombre) throws Exception;

    List<Cliente> buscarClientesTipoDocumento (Tipo_Documento tipoDocumento) throws Exception;

    List<Cliente> buscarClientes () throws Exception;

}

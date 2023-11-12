package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.entidades.Cliente;
import co.edu.uniquindio.proyecto.entidades.Tipo_Documento;
import co.edu.uniquindio.proyecto.repositorios.ClienteRepo;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.validation.constraints.Null;


import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImple implements ClienteServicio {
    private final ClienteRepo clienteRepo;

    public ClienteServicioImple(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @Override
    public void CrearCliente(Cliente cliente) throws Exception {
        Optional <Cliente> buscado = clienteRepo.findById(cliente.getId_cliente());
        if (buscado.isPresent()){
            JOptionPane.showMessageDialog(null,"Ya existe un cliente registrado con esa cedula","Alerta", JOptionPane.WARNING_MESSAGE);
            throw new Exception("Ya existe un cliente registrado con esa cedula");
        }
        Optional <Cliente> buscadoMail = clienteRepo.findByCorreo(cliente.getCorreo());
        if(buscadoMail.isPresent()){
            JOptionPane.showMessageDialog(null,"Ya existe un cliente registrado con ese correo","Alerta", JOptionPane.WARNING_MESSAGE);
            throw new Exception("Ya existe un cliente registrado con ese correo");
        }
Cliente cliente1 = new Cliente(cliente.getId_cliente(),cliente.getNombre(),cliente.getApellido(),cliente.getDireccion(),cliente.getCorreo(), cliente.getTelefono(), cliente.getTipoDocumento());
   clienteRepo.save(cliente1);
        JOptionPane.showMessageDialog(null,"cliente creado :)");
    }

    @Override
    public void eliminarCliente(String cedula) throws Exception {
        Optional <Cliente> buscado = clienteRepo.findById(cedula);
        if (!buscado.isPresent()){
            JOptionPane.showMessageDialog(null,"no existe un cliente registrado con esa cedula","Alerta", JOptionPane.WARNING_MESSAGE);
            throw new Exception("no existe cliente registrado con esa cedula");
        } else{
            clienteRepo.deleteById(cedula);
            JOptionPane.showMessageDialog(null,"cliente eliminado:)");
        }
    }

    @Override
    public void actualizarCliente(String nombre, String direccion, String correo, String telefono, String cedula) throws Exception {
        Optional <Cliente> buscado1 = clienteRepo.findByCorreo(correo);
        if(buscado1.isPresent()){
            JOptionPane.showMessageDialog(null,"ya existe un cliente registrado con ese correo","Alerta", JOptionPane.WARNING_MESSAGE);
            throw new Exception("ya existe un cliente registrado con ese correo\"");
        }
        Cliente cliente1 = buscado1.orElse(null);
        cliente1.setNombre(nombre);
        cliente1.setCorreo(correo);
        cliente1.setDireccion(direccion);
        cliente1.setTelefono(telefono);

        clienteRepo.save(cliente1);
        JOptionPane.showMessageDialog(null,"cliente Actualizado :)");


    }

    @Override
    public boolean VerificarActualizarcion(String cedula) throws Exception {

        Optional <Cliente> buscado1 = clienteRepo.findById(cedula);
        if(buscado1.isEmpty()){
            JOptionPane.showMessageDialog(null,"no existe un cliente registrado con esa cedula","Alerta", JOptionPane.WARNING_MESSAGE);
            throw new Exception("no existe cliente registrado con esa cedula");
        } else{
            return true;
        }
    }

    @Override
    public Cliente buscarIdCliente(String cedula) throws Exception {
        Optional <Cliente> buscado = clienteRepo.findByCorreo(cedula);
        if(buscado.isEmpty()){
            JOptionPane.showMessageDialog(null,"no existe un cliente registrado con esa cedula","Alerta", JOptionPane.WARNING_MESSAGE);
            throw new Exception("no existe cliente registrado con esa cedula");
        }
       Cliente cliente = buscado.orElse(null);
        return cliente;
    }

    @Override
    public List<Cliente> buscarClientesNombre(String nombre) throws Exception {
        List <Cliente> clientes = clienteRepo.findAllByNombre(nombre);
        if(clientes.isEmpty()){
            JOptionPane.showMessageDialog(null,"no existen clientes con ese nombre","Alerta", JOptionPane.WARNING_MESSAGE);
            throw new Exception("no existen clientes con ese nombre");
        }
        return clientes;
    }

    @Override
    public List<Cliente> buscarClientesTipoDocumento(Tipo_Documento tipoDocumento) throws Exception {
        List <Cliente> clientes = clienteRepo.findAllByTipoDocumento(tipoDocumento);
        if(clientes.isEmpty()){
            JOptionPane.showMessageDialog(null,"no existen clientes con ese tipo de documento","Alerta", JOptionPane.WARNING_MESSAGE);
            throw new Exception("no existen clientes con ese tipo de documento");
        }
        return clientes;
    }

    @Override
    public List<Cliente> buscarClientes() throws Exception {
        List <Cliente> clientes = clienteRepo.findAll();

        return clientes;
    }
}

package co.edu.uniquindio.proyecto.Controllers;



import co.edu.uniquindio.proyecto.entidades.Cliente;
import co.edu.uniquindio.proyecto.entidades.Empleado;
import co.edu.uniquindio.proyecto.repositorios.ClienteRepo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ActualizarCController implements Initializable {

    @Autowired
    SceneController sceneController;

    @Autowired
    ClienteRepo clienteRepo;

    Cliente cliente;

    private Empleado empleadoLogin;

    @FXML
    private Label inventarioLabel;

    @FXML
    private Label actualizarLabel;

    @FXML
    private Label historialLabel;

    @FXML
    private Label facturasLabel;

    @FXML
    private Label proveedoresLabel;

    @FXML
    private Label productoLabel;

    @FXML
    private Label empleadosLabel;

    @FXML
    private Label clientesLabel;

    @FXML
    private Label fechaLabel;

    @FXML
    private Label nombreUsuarioLabel;

    @FXML
    private TextField telefonoField;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField direccionField;

    @FXML
    private TextField correoField;


    @FXML
    private void handleInventarioClick(MouseEvent event) {
        abrirVentanaInventario(event, empleadoLogin);
        System.out.println("Inventario label clicado");
    }

    @FXML
    private void handleActualizarClick(MouseEvent event) {
        // Lógica cuando se hace clic en el label de actualizar

        if (nombreField.getText().isEmpty() || telefonoField.getText().isEmpty() || correoField.getText().isEmpty() || direccionField.getText().isEmpty()) {
            mostrarAlerta("No deje campos vacíos", "Error", Alert.AlertType.ERROR);
        } else if (clienteRepo.findByCorreo(correoField.getText()).isPresent()) {
            mostrarAlerta("Ese correo ya está registrado", "Error", Alert.AlertType.ERROR);
        } else {
            cliente.setNombre(nombreField.getText());
            cliente.setDireccion(direccionField.getText());
            cliente.setCorreo(correoField.getText());
            cliente.setTelefono(telefonoField.getText());
            clienteRepo.save(cliente);
            mostrarAlerta("Cliente actualizado :)", "Confirmación", Alert.AlertType.CONFIRMATION);
            // Puedes agregar acciones adicionales aquí después de guardar el cliente
        }
    }

    private void mostrarAlerta(String mensaje, String titulo, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }@FXML
    private void handleHistorialClick(MouseEvent event) {
        abrirVentanaHistorial(event, empleadoLogin);
        System.out.println("Historial label clicado");
    }
    @FXML
    private void handleFacturasClick(MouseEvent event) {
        abrirVentanaFacturas(event, empleadoLogin);
        System.out.println("Facturas label clicado");
    }
    @FXML
    private void handleProveedoresClick(MouseEvent event) {
        abrirVentanaProveedores(event, empleadoLogin);
        System.out.println("Proveedores label clicado");
    }@FXML

    private void handleProductoClick(MouseEvent event) {
        abrirVentanaProducto(event, empleadoLogin);
        System.out.println("Producto label clicado");
    }
    @FXML
    private void handleEmpleadosClick(MouseEvent event) {
        if(!empleadoLogin.getNombre().equalsIgnoreCase("ADMIN")){
            mostrarAlerta("No tiene permisos para acceder a esta ventana", "Error de entrada", Alert.AlertType.ERROR);
        }else{
            abrirVentanaEmpleados(event, empleadoLogin);
        }
        System.out.println("Clic en el label 'Empleados'");
    } @FXML

    private void handleClientesClick(MouseEvent event) {
        if(!empleadoLogin.getNombre().equalsIgnoreCase("ADMIN")){
            mostrarAlerta("No tiene permisos para acceder a esta ventana", "Error de entrada", Alert.AlertType.ERROR);
        }else{
            abrirVentanaClientes(event, empleadoLogin);
        }
        System.out.println("Clic en el label 'Clientes'");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inventarioLabel.setOnMouseClicked(event -> handleInventarioClick(event));
        actualizarLabel.setOnMouseClicked(event -> handleActualizarClick(event));
        historialLabel.setOnMouseClicked(event -> handleHistorialClick(event));
        facturasLabel.setOnMouseClicked(event -> handleFacturasClick(event));
        proveedoresLabel.setOnMouseClicked(event -> handleProveedoresClick(event));
        productoLabel.setOnMouseClicked(event -> handleProductoClick(event));
        empleadosLabel.setOnMouseClicked(event -> handleEmpleadosClick(event));
        clientesLabel.setOnMouseClicked(event -> handleClientesClick(event));
    }
    private void abrirVentanaInventario(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaInventario(event, empleado);
    }
    private void abrirVentanaClientes(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaCliente(event, empleado);
    }

    private void abrirVentanaHistorial(MouseEvent event, Empleado empleado) {
       //  sceneController.(event, empleado);
    }
    private void abrirVentanaProducto(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaProducto(event, empleado);
    }

    private void abrirVentanaFacturas(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaInventario(event, empleado);
    }
    private void abrirVentanaProveedores(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaProveedor(event, empleado);
    }
    private void abrirVentanaEmpleados(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaEmpleado(event, empleado);
    }

    public void displayEmployeeIDUsername(Empleado empleado){
        empleadoLogin = empleado;
        nombreUsuarioLabel.setText(empleado.getNombre());
        fechaLabel.setText("Fecha: " + java.time.LocalDate.now());
    }
    public void displayclienteIDUsername(Cliente clientecito){
        cliente = clientecito;

    }



}

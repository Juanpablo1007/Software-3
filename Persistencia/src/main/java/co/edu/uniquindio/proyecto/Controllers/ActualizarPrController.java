package co.edu.uniquindio.proyecto.Controllers;

import co.edu.uniquindio.proyecto.entidades.Empleado;
import co.edu.uniquindio.proyecto.entidades.Proveedor;
import co.edu.uniquindio.proyecto.repositorios.ProveedorRepo;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import org.springframework.stereotype.Component;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;
@Component
public class ActualizarPrController  implements Initializable {
   @Autowired
    ProveedorRepo proveedorRepo;

   Proveedor proveedor;

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
    public void initialize() {

    }
    @FXML
    private void handleInventarioClick() {
        // Lógica cuando se hace clic en el label de inventario
        System.out.println("Inventario label clicado");
    }
    @FXML
    void handleActualizarClick() {
        // Lógica cuando se hace clic en el label de actualizar

        if (nombreField.getText().isEmpty() || telefonoField.getText().isEmpty() || correoField.getText().isEmpty() || direccionField.getText().isEmpty()) {
            mostrarAlerta("No deje campos vacíos", "Error", Alert.AlertType.ERROR);
        } else if (proveedorRepo.findByCorreo(correoField.getText()).isPresent()) {
            mostrarAlerta("Ese correo ya está registrado", "Error", Alert.AlertType.ERROR);
        } else {
            proveedor.setNombre(nombreField.getText());
            proveedor.setDireccion(direccionField.getText());
            proveedor.setCorreo(correoField.getText());
            proveedor.setTelefono(telefonoField.getText());
            proveedorRepo.save(proveedor);
            mostrarAlerta("Proveedor actualizado :)", "CONFIRMATION", Alert.AlertType.CONFIRMATION);
            // Puedes agregar acciones adicionales aquí después de guardar el proveedor
        }
    }
    private void mostrarAlerta(String mensaje, String titulo, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null); // Puedes establecer un encabezado si lo deseas
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @FXML
    private void handleHistorialClick() {
        // Lógica cuando se hace clic en el label de historial
        System.out.println("Historial label clicado");
    }
    @FXML
    private void handleFacturasClick() {
        // Lógica cuando se hace clic en el label de facturas
        System.out.println("Facturas label clicado");
    }
    @FXML
    private void handleProveedoresClick() {
        // Lógica cuando se hace clic en el label de proveedores
        System.out.println("Proveedores label clicado");
    }
    @FXML
    private void handleProductoClick() {
        // Lógica cuando se hace clic en el label de producto
        System.out.println("Producto label clicado");
    }
    @FXML
    private void handleEmpleadosClick() {
        // Lógica cuando se hace clic en el label de empleados
        System.out.println("Empleados label clicado");
    }
    @FXML
    private void handleClientesClick() {
        // Lógica cuando se hace clic en el label de clientes
        System.out.println("Clientes label clicado");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inventarioLabel.setOnMouseClicked(event -> handleInventarioClick());
        actualizarLabel.setOnMouseClicked(event -> handleActualizarClick());
        historialLabel.setOnMouseClicked(event -> handleHistorialClick());
        facturasLabel.setOnMouseClicked(event -> handleFacturasClick());
        proveedoresLabel.setOnMouseClicked(event -> handleProveedoresClick());
        productoLabel.setOnMouseClicked(event -> handleProductoClick());
        empleadosLabel.setOnMouseClicked(event -> handleEmpleadosClick());
        clientesLabel.setOnMouseClicked(event -> handleClientesClick());
    }

    public void displayEmployeeIDUsername(Empleado empleado){
        empleadoLogin = empleado;
        nombreUsuarioLabel.setText(empleado.getNombre());
        fechaLabel.setText("Fecha: " + java.time.LocalDate.now());
    }
   public  void generarProveedor (Proveedor proveedor1){
        proveedor = proveedor1;
}

}

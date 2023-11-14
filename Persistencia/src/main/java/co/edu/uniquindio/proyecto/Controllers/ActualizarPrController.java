package co.edu.uniquindio.proyecto.Controllers;

import co.edu.uniquindio.proyecto.entidades.Proveedor;
import co.edu.uniquindio.proyecto.repositorios.ProveedorRepo;
import javafx.fxml.Initializable;
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
        inventarioLabel.setOnMouseClicked(event -> handleInventarioClick());
        actualizarLabel.setOnMouseClicked(event -> handleActualizarClick());
        historialLabel.setOnMouseClicked(event -> handleHistorialClick());
        facturasLabel.setOnMouseClicked(event -> handleFacturasClick());
        proveedoresLabel.setOnMouseClicked(event -> handleProveedoresClick());
        productoLabel.setOnMouseClicked(event -> handleProductoClick());
        empleadosLabel.setOnMouseClicked(event -> handleEmpleadosClick());
        clientesLabel.setOnMouseClicked(event -> handleClientesClick());
    }

    private void handleInventarioClick() {
        // Lógica cuando se hace clic en el label de inventario
        System.out.println("Inventario label clicado");
    }

    private void handleActualizarClick() {
        // Lógica cuando se hace clic en el label de actualizar

        if( nombreField.getText().isEmpty() || telefonoField.getText().isEmpty() || correoField.getText().isEmpty()   || direccionField.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(null, "No deje campos vacios");
        }else if(proveedorRepo.findByCorreo(correoField.getText()).isPresent()){
            JOptionPane.showMessageDialog(null, "ese correo ya esta registrado");
        } else{
            proveedor.setNombre(nombreField.getText());
            proveedor.setDireccion(direccionField.getText());
            proveedor.setCorreo(correoField.getText());
            proveedor.setTelefono(telefonoField.getText());
            proveedorRepo.save(proveedor);
            JOptionPane.showMessageDialog(null, "proveedor actualizado :)");

        }
    }

    private void handleHistorialClick() {
        // Lógica cuando se hace clic en el label de historial
        System.out.println("Historial label clicado");
    }

    private void handleFacturasClick() {
        // Lógica cuando se hace clic en el label de facturas
        System.out.println("Facturas label clicado");
    }

    private void handleProveedoresClick() {
        // Lógica cuando se hace clic en el label de proveedores
        System.out.println("Proveedores label clicado");
    }

    private void handleProductoClick() {
        // Lógica cuando se hace clic en el label de producto
        System.out.println("Producto label clicado");
    }

    private void handleEmpleadosClick() {
        // Lógica cuando se hace clic en el label de empleados
        System.out.println("Empleados label clicado");
    }

    private void handleClientesClick() {
        // Lógica cuando se hace clic en el label de clientes
        System.out.println("Clientes label clicado");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}

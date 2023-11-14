package co.edu.uniquindio.proyecto.Controllers;

import co.edu.uniquindio.proyecto.entidades.Cliente;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Proveedor;
import co.edu.uniquindio.proyecto.entidades.Tipo_Documento;
import co.edu.uniquindio.proyecto.repositorios.ClienteRepo;
import co.edu.uniquindio.proyecto.repositorios.ProveedorRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class CrearPrController implements Initializable {
    @Autowired
    ProveedorRepo proveedorRepo;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inventarioLabel.setOnMouseClicked(event -> handleInventarioClick());
        CrearLabel.setOnMouseClicked(event -> handleCrearClick());
        historialLabel.setOnMouseClicked(event -> handleHistorialClick());
        facturasLabel.setOnMouseClicked(event -> handleFacturasClick());
        proveedoresLabel.setOnMouseClicked(event -> handleProveedoresClick());
        productoLabel.setOnMouseClicked(event -> handleProductoClick());
        empleadosLabel.setOnMouseClicked(event -> handleEmpleadosClick());
        clientesLabel.setOnMouseClicked(event -> handleClientesClick());
        ObservableList<String> opciones = FXCollections.observableArrayList("CEDULA_CIUDADANIA",
                "TARJETA_IDENTIDAD",
                "CEDULA_EXTRANJERIA",
                "PASAPORTE",
                "LICENCIA_CONDUCCION",
                "OTRO");
        TipoDocumento.setItems(opciones);
    }
    @FXML
    private Label inventarioLabel;

    @FXML
    private Label CrearLabel;

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
    private TextField cedulaField;

    @FXML
    private ComboBox<String> TipoDocumento;

    // Puedes agregar los métodos y lógica necesarios aquí

    // Por ejemplo, puedes agregar un método que maneje un evento
    @FXML
    private void initialize() {

    }

    // Agrega otros métodos según sea necesario
    @FXML
    private void handleInventarioClick() {
        // Lógica cuando se hace clic en el label de inventario
        System.out.println("Inventario label clicado");
    }
    @FXML
    private void handleCrearClick() {
        if (correoField.getText().isEmpty() || nombreField.getText().isEmpty() || telefonoField.getText().isEmpty() || correoField.getText().isEmpty() || cedulaField.getText().isEmpty() || direccionField.getText().isEmpty()) {
            mostrarAlerta("No deje campos vacíos", "Error", Alert.AlertType.ERROR);
        } else if (proveedorRepo.findById(cedulaField.getText()).isPresent()) {
            mostrarAlerta("Esa cédula ya está registrada", "Error", Alert.AlertType.ERROR);
        } else if (proveedorRepo.findByCorreo(correoField.getText()).isPresent()) {
            mostrarAlerta("Ese correo ya está registrado", "Error", Alert.AlertType.ERROR);
        } else {
            Tipo_Documento tipoDocumento = Traduciropciones(TipoDocumento.getSelectionModel().getSelectedItem());
            List<Producto> productos = new ArrayList<>();

            Proveedor proveedor = new Proveedor(cedulaField.getText(), nombreField.getText(), direccionField.getText(), correoField.getText(), telefonoField.getText(), tipoDocumento, productos);
            proveedorRepo.save(proveedor);
            mostrarAlerta("Proveedor creado con éxito :)", "CONFIRMATION", Alert.AlertType.CONFIRMATION);
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
    public Tipo_Documento Traduciropciones (String opcion){

        if (opcion.equals("CEDULA_CIUDADANIA")){
            return  Tipo_Documento.CEDULA_EXTRANJERIA;
        }else if(opcion.equals("TARJETA_IDENTIDAD")){
            return  Tipo_Documento.TARJETA_IDENTIDAD;
        } else if(opcion.equals("PASAPORTE")){
            return  Tipo_Documento.PASAPORTE;
        }else if(opcion.equals("OTRO")){
            return  Tipo_Documento.OTRO;
        } else{
            return Tipo_Documento.LICENCIA_CONDUCCION;
        }

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
}

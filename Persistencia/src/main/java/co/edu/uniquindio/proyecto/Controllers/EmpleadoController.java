package co.edu.uniquindio.proyecto.Controllers;
import co.edu.uniquindio.proyecto.entidades.Empleado;
import co.edu.uniquindio.proyecto.repositorios.EmpleadoRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class EmpleadoController implements Initializable {
    @Autowired
    EmpleadoRepo empleadoRepo;
    ObservableList<Empleado> listaPersonasObservable = FXCollections.observableArrayList();
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
    private Label eliminarLabel;

    @FXML
    private Label buscarLabel;

    @FXML
    private TextField correoField;

    @FXML
    private TextField idField;

    @FXML
    private TextField nombreField;

    @FXML
    private TableView<Empleado> tablaEmpleados;

    @FXML
    private TableColumn<Empleado, String> nombreColumn;

    @FXML
    private TableColumn<Empleado, String> direccionColumn;

    @FXML
    private TableColumn<Empleado, String> telefonoColumn;

    @FXML
    private TableColumn<Empleado, String> cedulaColumn;

    @FXML
    private TableColumn<Empleado, String> correoColumn;

    // Aquí puedes agregar métodos adicionales según sea necesario

    // Por ejemplo, si necesitas inicializar algo cuando se carga la vista
    @FXML
    private void initialize() {
        // Inicializa la tabla y sus columnas, si es necesario

    }
    @FXML
    private void handleInventarioClick() {
        System.out.println("Clic en el label 'Inventario'");
    }

    @FXML
    private void handleActualizarClick() {
        System.out.println("Clic en el label 'Actualizar'");
    }

    @FXML
    private void handleHistorialClick() {
        System.out.println("Clic en el label 'Historial'");
    }

    @FXML
    private void handleFacturasClick() {
        System.out.println("Clic en el label 'Facturas'");
    }

    @FXML
    private void handleProveedoresClick() {
        System.out.println("Clic en el label 'Proveedores'");
    }

    @FXML
    private void handleProductoClick() {
        System.out.println("Clic en el label 'Producto'");
    }

    @FXML
    private void handleEmpleadosClick() {
        System.out.println("Clic en el label 'Empleados'");
    }

    @FXML
    private void handleClientesClick() {
        System.out.println("Clic en el label 'Clientes'");
    }

    @FXML
    private void handleEliminarClick() {
        System.out.println("Clic en el label 'Eliminar'");
    }

    @FXML
    private void handleBuscarClick() {
       if(nombreField.getText().isEmpty() || idField.getText().isEmpty() || correoField.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "No deje campos vacios");
       }
       else if (nombreField.getText().isEmpty() && idField.getText().isEmpty() && !correoField.getText().isEmpty()){
           listaPersonasObservable.clear();
           cargarEmpleadosPorCorreo( correoField.getText());

       }
    }
    // Puedes agregar otros métodos según lo que necesites para manejar eventos u operaciones

    private void initializeTabla() {
        // Configura la tabla y las columnas según tus necesidades
        // Por ejemplo, podrías enlazar las columnas con los datos del modelo
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        direccionColumn.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        telefonoColumn.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        cedulaColumn.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        correoColumn.setCellValueFactory(new PropertyValueFactory<>("correo"));
    }
    private void cargarEmpleadosPorNombre(String nombre) {
        listaPersonasObservable.addAll(empleadoRepo.findAllByNombre(nombre));
    }

    // Método para cargar empleados por correo
    private void cargarEmpleadosPorCorreo(String correo) {
        listaPersonasObservable.addAll(empleadoRepo.findAllByCorreo(correo));
    }

    // Método para cargar empleados por ID
    private void cargarEmpleadosPorId(String id) {
        listaPersonasObservable.addAll(empleadoRepo.findAllById(id));
    }
    private void refrescarTablaPersonas() {
        listaPersonasObservable.clear();
        listaPersonasObservable.addAll(empleadoRepo.findAll());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTabla();
        refrescarTablaPersonas();
        inventarioLabel.setOnMouseClicked(event -> handleInventarioClick());
        actualizarLabel.setOnMouseClicked(event -> handleActualizarClick());
        historialLabel.setOnMouseClicked(event -> handleHistorialClick());
        facturasLabel.setOnMouseClicked(event -> handleFacturasClick());
        proveedoresLabel.setOnMouseClicked(event -> handleProveedoresClick());
        productoLabel.setOnMouseClicked(event -> handleProductoClick());
        empleadosLabel.setOnMouseClicked(event -> handleEmpleadosClick());
        clientesLabel.setOnMouseClicked(event -> handleClientesClick());
        eliminarLabel.setOnMouseClicked(event ->handleEliminarClick());
        buscarLabel.setOnMouseClicked(event -> handleBuscarClick());
    }
}
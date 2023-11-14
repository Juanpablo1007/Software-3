package co.edu.uniquindio.proyecto.Controllers;
import co.edu.uniquindio.proyecto.entidades.Empleado;
import co.edu.uniquindio.proyecto.entidades.Proveedor;
import co.edu.uniquindio.proyecto.repositorios.EmpleadoRepo;
import co.edu.uniquindio.proyecto.repositorios.ProveedorRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ProveedorController implements Initializable {
    @Autowired
    ProveedorRepo proveedorRepo;
    ObservableList<Proveedor> listaProveedoresObservable = FXCollections.observableArrayList();
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
    private Label CrearLabel;

    @FXML
    private Label buscarLabel;

    @FXML
    private TextField correoField;

    @FXML
    private TextField idField;

    @FXML
    private TextField nombreField;

    @FXML
    private TableView<Proveedor> tablaProveedor;

    @FXML
    private TableColumn<Proveedor, String> nombreColumn;

    @FXML
    private TableColumn<Proveedor, String> direccionColumn;

    @FXML
    private TableColumn<Proveedor, String> telefonoColumn;

    @FXML
    private TableColumn<Proveedor, String> cedulaColumn;

    @FXML
    private TableColumn<Proveedor, String> tipoIdentificacionColumn;

    @FXML
    private TableColumn<Proveedor, String> correoColumn;

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
    private void handleCrearClick() {
        System.out.println("Clic en el label 'crear'");
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

        if (nombreField.getText().isEmpty() && idField.getText().isEmpty() && !correoField.getText().isEmpty()){
            mostrarAlerta("No deje campos vacíos", "Error", Alert.AlertType.ERROR);

        }
        else if (!nombreField.getText().isEmpty() && idField.getText().isEmpty() && correoField.getText().isEmpty()){
            mostrarAlerta("Por favor llene el correo y/o el correo", "INFORMATION", Alert.AlertType.INFORMATION);

        }
        else if (!nombreField.getText().isEmpty() && !idField.getText().isEmpty() && !correoField.getText().isEmpty()){
            Proveedor proveedor = proveedorRepo.findByDocumentoAndCorreo(idField.getText(),correoField.getText()).orElse(null);
            if(proveedor == null){
                mostrarAlerta("ese empleado no existe", "Error", Alert.AlertType.ERROR);
            }else{
                proveedorRepo.delete(proveedor);
                mostrarAlerta("empleado eliminado:)", "CONFIRMATION", Alert.AlertType.CONFIRMATION);
                refrescarTablaPersonas();
            }

        }
        else if (nombreField.getText().isEmpty() && !idField.getText().isEmpty() && !correoField.getText().isEmpty()){
            Proveedor proveedor = proveedorRepo.findByDocumentoAndCorreo(idField.getText(),correoField.getText()).orElse(null);
            if(proveedor == null){
                mostrarAlerta("ese empleado no existe", "Error", Alert.AlertType.ERROR);
            }else{
                proveedorRepo.delete(proveedor);
                mostrarAlerta("proveedor eliminado:)", "CONFIRMATION", Alert.AlertType.CONFIRMATION);
                refrescarTablaPersonas();
            }


        }else if (nombreField.getText().isEmpty() && idField.getText().isEmpty() && !correoField.getText().isEmpty()){
            Proveedor proveedor = proveedorRepo.findByCorreo(correoField.getText()).orElse(null);
            if(proveedor == null){
                mostrarAlerta("ese empleado no existe", "Error", Alert.AlertType.ERROR);
            }else{
                proveedorRepo.delete(proveedor);
                mostrarAlerta("empleado eliminado:)", "CONFIRMATION", Alert.AlertType.CONFIRMATION);
                refrescarTablaPersonas();
            }


        }else if (nombreField.getText().isEmpty() && !idField.getText().isEmpty() && correoField.getText().isEmpty()){
            Proveedor proveedor = proveedorRepo.findById(idField.getText()).orElse(null);
            if(proveedor == null){
                mostrarAlerta("ese empleado no existe", "Error", Alert.AlertType.ERROR);
            }else{
                proveedorRepo.delete(proveedor);
                mostrarAlerta("empleado eliminado:)", "CONFIRMATION", Alert.AlertType.CONFIRMATION);
                refrescarTablaPersonas();
            }

        }
        else{
            mostrarAlerta("ha ocurrido un error :(", "Error", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleBuscarClick() {

         if (nombreField.getText().isEmpty() && idField.getText().isEmpty() && !correoField.getText().isEmpty()){
            listaProveedoresObservable.clear();
            cargarEmpleadosPorCorreo( correoField.getText());

        }
        else if (!nombreField.getText().isEmpty() && idField.getText().isEmpty() && correoField.getText().isEmpty()){
            listaProveedoresObservable.clear();
            cargarEmpleadosPorNombre( nombreField.getText());

        }
        else if (nombreField.getText().isEmpty() && !idField.getText().isEmpty() && correoField.getText().isEmpty()){
            listaProveedoresObservable.clear();
            cargarEmpleadosPorId( idField.getText());

        }
        else if (!nombreField.getText().isEmpty() && !idField.getText().isEmpty() && !correoField.getText().isEmpty()){
            listaProveedoresObservable.clear();
            cargarEmpleadosPorTodo(nombreField.getText(),idField.getText(),correoField.getText());

        }else if (!nombreField.getText().isEmpty() && !idField.getText().isEmpty() && correoField.getText().isEmpty()){
            listaProveedoresObservable.clear();
            cargarEmpleadosPorNombreyId(nombreField.getText(),idField.getText());

        }else if (!nombreField.getText().isEmpty() && idField.getText().isEmpty() && !correoField.getText().isEmpty()){
            listaProveedoresObservable.clear();
            cargarEmpleadosPorNombreyCorreo(nombreField.getText(),correoField.getText());

        }else if (nombreField.getText().isEmpty() && !idField.getText().isEmpty() && !correoField.getText().isEmpty()){
            listaProveedoresObservable.clear();
            cargarEmpleadosPorIdyCorreo(idField.getText(),correoField.getText());

        }
        else{
             listaProveedoresObservable.clear();
             listaProveedoresObservable.addAll(proveedorRepo.findAll());
        }
    }
    private void mostrarAlerta(String mensaje, String titulo, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    // Puedes agregar otros métodos según lo que necesites para manejar eventos u operaciones

    // Puedes agregar otros métodos según lo que necesites para manejar eventos u operaciones

    private void initializeTabla() {
        // Configura la tabla y sus columnas según tus necesidades
        // Por ejemplo, podrías enlazar las columnas con los datos del modelo
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        direccionColumn.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        telefonoColumn.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        cedulaColumn.setCellValueFactory(new PropertyValueFactory<>("documento"));
        tipoIdentificacionColumn.setCellValueFactory(new PropertyValueFactory<>("tipoDocumento"));
        correoColumn.setCellValueFactory(new PropertyValueFactory<>("correo"));

        // Asigna la lista observable a la tabla
        tablaProveedor.setItems(listaProveedoresObservable);
    }
    // Método para cargar empleados por correo
    private void cargarEmpleadosPorCorreo(String correo) {
        listaProveedoresObservable.addAll(proveedorRepo.findAllByCorreo(correo));
    }

    // Método para cargar empleados por ID
    private void cargarEmpleadosPorId(String id) {
        listaProveedoresObservable.addAll(proveedorRepo.findAllByDocumento(id));
    }
    private void cargarEmpleadosPorTodo(String nombre,  String id,String correo) {
        listaProveedoresObservable.addAll(proveedorRepo.findAllByNombreAndDocumentoAndCorreo(nombre,id,correo));
    }
    private void cargarEmpleadosPorNombreyId(String nombre,  String id) {
        listaProveedoresObservable.addAll(proveedorRepo.findAllByNombreAndDocumento(nombre,id));
    }
    private void cargarEmpleadosPorNombreyCorreo(String nombre,  String correo) {
        listaProveedoresObservable.addAll(proveedorRepo.findAllByNombreAndCorreo(nombre,correo));
    }
    private void cargarEmpleadosPorIdyCorreo(  String id,String correo) {
        listaProveedoresObservable.addAll(proveedorRepo.findAllByDocumentoAndCorreo(id,correo));
    }
    private void cargarEmpleadosPorNombre(  String nombre) {
        listaProveedoresObservable.addAll(proveedorRepo.findAllByNombre(nombre));
    }
    private void refrescarTablaPersonas() {
        listaProveedoresObservable.clear();
        listaProveedoresObservable.addAll(proveedorRepo.findAll());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTabla();
        refrescarTablaPersonas();
        CrearLabel.setOnMouseClicked(event -> handleCrearClick());
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
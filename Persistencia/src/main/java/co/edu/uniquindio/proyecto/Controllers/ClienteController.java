package co.edu.uniquindio.proyecto.Controllers;
import co.edu.uniquindio.proyecto.entidades.Cliente;
import co.edu.uniquindio.proyecto.entidades.Empleado;
import co.edu.uniquindio.proyecto.entidades.Proveedor;
import co.edu.uniquindio.proyecto.repositorios.ClienteRepo;
import co.edu.uniquindio.proyecto.repositorios.EmpleadoRepo;
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
public class ClienteController implements Initializable {
    @Autowired
    ClienteRepo clienteRepo;
    ObservableList<Cliente> listaClientesObservable = FXCollections.observableArrayList();

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
    private Label CrearLabel;
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
    private TableView<Cliente> tablaClientes;

    @FXML
    private TableColumn<Cliente, String> nombreColumn;

    @FXML
    private TableColumn<Cliente, String> direccionColumn;

    @FXML
    private TableColumn<Cliente, String> telefonoColumn;

    @FXML
    private TableColumn<Cliente, String> cedulaColumn;

    @FXML
    private TableColumn<Cliente, String> correoColumn;
    @FXML
    private TableColumn<Proveedor, String> tipoIdentificacionColumn;




    @FXML
    private void initialize() {

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

        if (nombreField.getText().isEmpty() && idField.getText().isEmpty() && !correoField.getText().isEmpty()){
            mostrarAlerta("No deje campos vacíos", "Error", Alert.AlertType.ERROR);

        }
        else if (!nombreField.getText().isEmpty() && idField.getText().isEmpty() && correoField.getText().isEmpty()){
            mostrarAlerta("Por favor llene el correo y/o el Identificacion", "INFORMATION", Alert.AlertType.INFORMATION);

        }
        else if (!nombreField.getText().isEmpty() && !idField.getText().isEmpty() && !correoField.getText().isEmpty()){
            Cliente cliente = clienteRepo.findByNombreAndIdclienteAndCorreo(nombreField.getText(),idField.getText(),correoField.getText()).orElse(null);
            if(cliente == null){
                mostrarAlerta("ese cliente no existe", "Error", Alert.AlertType.ERROR);
            }else{
                clienteRepo.delete(cliente);
                mostrarAlerta("cliente eliminado:)", "CONFIRMATION", Alert.AlertType.CONFIRMATION);
                refrescarTablaPersonas();
            }

        }
        else if (nombreField.getText().isEmpty() && !idField.getText().isEmpty() && !correoField.getText().isEmpty()){
            Cliente cliente = clienteRepo.findByIdclienteAndCorreo(idField.getText(),correoField.getText()).orElse(null);
            if(cliente == null){
                mostrarAlerta("ese cliente no existe", "Error", Alert.AlertType.ERROR);
            }else{
                clienteRepo.delete(cliente);
                mostrarAlerta("cliente eliminado:)", "CONFIRMATION", Alert.AlertType.CONFIRMATION);
                refrescarTablaPersonas();
            }


        }else if (nombreField.getText().isEmpty() && idField.getText().isEmpty() && !correoField.getText().isEmpty()){
            Cliente cliente = clienteRepo.findByCorreo(correoField.getText()).orElse(null);
            if(cliente == null){
                mostrarAlerta("ese cliente no existe", "Error", Alert.AlertType.ERROR);
            }else{
                clienteRepo.delete(cliente);
                mostrarAlerta("cliente eliminado:)", "CONFIRMATION", Alert.AlertType.CONFIRMATION);
                refrescarTablaPersonas();
            }


        }else if (nombreField.getText().isEmpty() && !idField.getText().isEmpty() && correoField.getText().isEmpty()){
            Cliente cliente = clienteRepo.findByIdcliente(idField.getText()).orElse(null);
            if( cliente == null){
                mostrarAlerta("ese cliente no existe", "Error", Alert.AlertType.ERROR);
            }else{
                clienteRepo.delete( cliente);
                mostrarAlerta("cliente eliminado:)", "CONFIRMATION", Alert.AlertType.CONFIRMATION);
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
            listaClientesObservable.clear();
            cargarEmpleadosPorCorreo( correoField.getText());

        }
        else if (!nombreField.getText().isEmpty() && idField.getText().isEmpty() && correoField.getText().isEmpty()){
            listaClientesObservable.clear();
            cargarEmpleadosPorNombre( nombreField.getText());

        }
        else if (nombreField.getText().isEmpty() && !idField.getText().isEmpty() && correoField.getText().isEmpty()){
            listaClientesObservable.clear();
            cargarEmpleadosPorId( idField.getText());

        }
        else if (!nombreField.getText().isEmpty() && !idField.getText().isEmpty() && !correoField.getText().isEmpty()){
            listaClientesObservable.clear();
            cargarEmpleadosPorTodo(nombreField.getText(),idField.getText(),correoField.getText());

        }else if (!nombreField.getText().isEmpty() && !idField.getText().isEmpty() && correoField.getText().isEmpty()){
            listaClientesObservable.clear();
            cargarEmpleadosPorNombreyId(nombreField.getText(),idField.getText());

        }else if (!nombreField.getText().isEmpty() && idField.getText().isEmpty() && !correoField.getText().isEmpty()){
            listaClientesObservable.clear();
            cargarEmpleadosPorNombreyCorreo(nombreField.getText(),correoField.getText());

        }else if (nombreField.getText().isEmpty() && !idField.getText().isEmpty() && !correoField.getText().isEmpty()){
            listaClientesObservable.clear();
            cargarEmpleadosPorIdyCorreo(idField.getText(),correoField.getText());

        }
        else{
             listaClientesObservable.clear();
             listaClientesObservable.addAll(clienteRepo.findAll());
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
        // Configura la tabla y las columnas según tus necesidades
        // Por ejemplo, podrías enlazar las columnas con los datos del modelo
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        direccionColumn.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        telefonoColumn.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        cedulaColumn.setCellValueFactory(new PropertyValueFactory<>("idcliente"));
        correoColumn.setCellValueFactory(new PropertyValueFactory<>("correo"));
        tipoIdentificacionColumn.setCellValueFactory(new PropertyValueFactory<>("tipoDocumento"));
        tablaClientes.setItems(listaClientesObservable);
    }
    // Método para cargar empleados por correo
    private void cargarEmpleadosPorCorreo(String correo) {
        listaClientesObservable.addAll(clienteRepo.findAllByCorreo(correo));
    }

    // Método para cargar empleados por ID
    private void cargarEmpleadosPorId(String id) {
        listaClientesObservable.addAll(clienteRepo.findAllByIdcliente(id));
    }
    private void cargarEmpleadosPorTodo(String nombre,  String id,String correo) {
        listaClientesObservable.addAll(clienteRepo.findAllByNombreAndIdclienteAndCorreo(nombre,id,correo));
    }
    private void cargarEmpleadosPorNombreyId(String nombre,  String id) {
        listaClientesObservable.addAll(clienteRepo.findAllByNombreAndIdcliente(nombre,id));
    }
    private void cargarEmpleadosPorNombreyCorreo(String nombre,  String correo) {
        listaClientesObservable.addAll(clienteRepo.findAllByNombreAndCorreo(nombre,correo));
    }
    private void cargarEmpleadosPorIdyCorreo(  String id,String correo) {
        listaClientesObservable.addAll(clienteRepo.findAllByIdclienteAndCorreo(id,correo));
    }
    private void cargarEmpleadosPorNombre(  String nombre) {
        listaClientesObservable.addAll(clienteRepo.findAllByNombre(nombre));
    }
    private void refrescarTablaPersonas() {
        listaClientesObservable.clear();
        listaClientesObservable.addAll(clienteRepo.findAll());

    }
    @FXML
    private void handleCrearClick() {
        System.out.println("Clic en el label 'crear'");
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
    public void displayEmployeeIDUsername(Empleado empleado){
        empleadoLogin = empleado;
        nombreUsuarioLabel.setText(empleado.getNombre());
        fechaLabel.setText("Fecha: " + java.time.LocalDate.now());
    }
}
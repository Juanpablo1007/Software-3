package co.edu.uniquindio.proyecto.Controllers;
import co.edu.uniquindio.proyecto.entidades.Cliente;
import co.edu.uniquindio.proyecto.entidades.Empleado;
import co.edu.uniquindio.proyecto.entidades.Factura;
import co.edu.uniquindio.proyecto.repositorios.EmpleadoRepo;
import co.edu.uniquindio.proyecto.repositorios.FacturaRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

@Component
public class FacturaController implements Initializable {

    @Autowired
    SceneController sceneController;
    @Autowired
    FacturaRepo facturaRepo;
    ObservableList<Factura> listaPersonasObservable = FXCollections.observableArrayList();

    private Empleado empleadoLogin;

    @FXML
    private Label inventarioLabel;



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
    private TextField idField;

    @FXML
    private TextField nombreField;

    @FXML
    private TableView<Factura> tablaFacturas;
    @FXML
    private TableColumn<Factura, Integer> codigoColumn;


    @FXML
    private TableColumn<Factura, Date> fechaColumn;

    @FXML
    private TableColumn<Factura, Double> valorTotalColumn;





    // Aquí puedes agregar métodos adicionales según sea necesario

    // Por ejemplo, si necesitas inicializar algo cuando se carga la vista


    @FXML
    private void initialize() {
        // Inicializa la tabla y sus columnas, si es necesario

    }
    @FXML
    private void handleInventarioClick(MouseEvent event)
    {
        abrirVentanaInventario(event, empleadoLogin);
        System.out.println("Clic en el label 'Inventario'");
    }

    @FXML
    private void handleActualizarClick()
    {
        System.out.println("Clic en el label 'Actualizar'");
    }

    @FXML
    private void handleHistorialClick(MouseEvent event)
    {
        abrirVentanaHistorial(event, empleadoLogin);
        System.out.println("Clic en el label 'Historial'");
    }

    @FXML
    private void handleFacturasClick(MouseEvent event) {
        abrirVentanaFacturas(event, empleadoLogin);
        System.out.println("Clic en el label 'Facturas'");
    }

    @FXML
    private void handleProveedoresClick(MouseEvent event) {
        abrirVentanaProveedores(event, empleadoLogin);
        System.out.println("Clic en el label 'Proveedores'");
    }

    @FXML
    private void handleProductoClick(MouseEvent event) {
        abrirVentanaProducto(event, empleadoLogin);
        System.out.println("Clic en el label 'Producto'");
    }

    @FXML
    private void handleEmpleadosClick(MouseEvent event  ) {
        abrirVentanaEmpleados(event, empleadoLogin);
        System.out.println("Clic en el label 'Empleados'");
    }

    @FXML
    private void handleClientesClick(MouseEvent event   ) {

        abrirVentanaClientes(event, empleadoLogin);
        System.out.println("Clic en el label 'Clientes'");
    }

    @FXML
    private void handleEliminarClick() {
        String codigoText = idField.getText();
        Integer codigo = null;
        try {
            if (!codigoText.isEmpty()) {
                codigo = Integer.parseInt(codigoText);
            }
        } catch (NumberFormatException e) {
            // Maneja la excepción si el código no es un número válido
            mostrarAlerta("El código debe ser un número válido.", "Error de entrada", Alert.AlertType.ERROR);
            return;
        } if(codigoText.isEmpty()){
            mostrarAlerta("escriba el codigo de la factura", "Error de entrada", Alert.AlertType.ERROR);
        }
        else{
            Factura factura = facturaRepo.findByCodigo(codigo).orElse(null);
            if(factura == null){
                mostrarAlerta("esa factura no existe", "Error de entrada", Alert.AlertType.ERROR);
            } else{
                facturaRepo.delete(factura);
                mostrarAlerta("factura eliminada con exito", "Error de entrada", Alert.AlertType.CONFIRMATION);
                refrescarTablaPersonas();
            }
        }
    }

    @FXML
    private void handleBuscarClick() {
        String codigoText = idField.getText();
        Integer codigo = null;
        try {
            if (!codigoText.isEmpty()) {
                codigo = Integer.parseInt(codigoText);
            }
        } catch (NumberFormatException e) {
            // Maneja la excepción si el código no es un número válido
            mostrarAlerta("El código debe ser un número válido.", "Error de entrada", Alert.AlertType.ERROR);
            return;
        }
         if (nombreField.getText().isEmpty() && idField.getText().isEmpty() ){
            listaPersonasObservable.clear();
            cargarFacturasPortodo();

        }

        else if (nombreField.getText().isEmpty() && !idField.getText().isEmpty()){
            listaPersonasObservable.clear();
            cargarFacturasPorCodigo( codigo);

        }


        else if (!nombreField.getText().isEmpty() && !idField.getText().isEmpty() ){
            listaPersonasObservable.clear();
             cargarFacturasPorCodigo( codigo);

        }
        else{
             listaPersonasObservable.clear();
             listaPersonasObservable.addAll(facturaRepo.findAll());
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
        codigoColumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        valorTotalColumn.setCellValueFactory(new PropertyValueFactory<>("valor_total"));
        tablaFacturas.setItems(listaPersonasObservable);
    }
    // Método para cargar empleados por correo


    // Método para cargar empleados por ID
    private void cargarFacturasPortodo() {
        listaPersonasObservable.clear();
        listaPersonasObservable.addAll(facturaRepo.findAll());
    }

    private void cargarFacturasPorCodigo(Integer id) {
        listaPersonasObservable.clear();
        listaPersonasObservable.addAll(facturaRepo.findAllByCodigo(id));
    }
    private void cargarFacturasPorNombreNombre(String nombre) {
        listaPersonasObservable.clear();
        listaPersonasObservable.addAll(facturaRepo.findAllByEmpleado_Nombre(nombre));
    }


    private void refrescarTablaPersonas() {
        listaPersonasObservable.clear();
        listaPersonasObservable.addAll(facturaRepo.findAll());

    }



    private void abrirVentanaClientes(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaCliente(event, empleado);
    }

    private void abrirVentanaInventario(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaInventario(event, empleado);
    }

    private void abrirVentanaHistorial(MouseEvent event, Empleado empleado) {
        // sceneController.(event, empleado);
    }
    private void abrirVentanaProducto(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaProducto(event, empleado);
    }

    private void abrirVentanaFacturas(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaInventario(event, empleado);
    }
    private void abrirVentanaEmpleados(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaEmpleado(event, empleado);
    }

    private void abrirVentanaProveedores(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaProveedor(event, empleado);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTabla();
        refrescarTablaPersonas();
        inventarioLabel.setOnMouseClicked(event -> handleInventarioClick(event));
        historialLabel.setOnMouseClicked(event -> handleHistorialClick(event));
        facturasLabel.setOnMouseClicked(event -> handleFacturasClick(event));
        proveedoresLabel.setOnMouseClicked(event -> handleProveedoresClick(event));
        productoLabel.setOnMouseClicked(event -> handleProductoClick(event));
        empleadosLabel.setOnMouseClicked(event -> handleEmpleadosClick(event));
        clientesLabel.setOnMouseClicked(event -> handleClientesClick(event));
        eliminarLabel.setOnMouseClicked(event ->handleEliminarClick());
        buscarLabel.setOnMouseClicked(event -> handleBuscarClick());
    }
    public void displayEmployeeIDUsername(Empleado empleado){
        empleadoLogin = empleado;
        nombreUsuarioLabel.setText(empleado.getNombre());
        fechaLabel.setText("Fecha: " + java.time.LocalDate.now());
    }
}
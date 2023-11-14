package co.edu.uniquindio.proyecto.Controllers;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
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
public class ProductoController implements Initializable {

    @Autowired
    ProductoRepo productoRepo;

    ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

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
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, String> nombreColumn;

    @FXML
    private TableColumn<Producto, Integer> precioMaximoColumn;

    @FXML
    private TableColumn<Producto, Integer> precioMinimoColumn;

    @FXML
    private TableColumn<Producto, Integer> codigoColumn;

    @FXML
    private TableColumn<Producto, String> categoriaColumn;

    @FXML
    private TableColumn<Producto, Integer> stockColumn;

    @FXML
    void handleActualizarClick() {
        System.out.println("Clic en el label 'Actualizar'");
    }

    @FXML
    void handleClientesClick() {
        System.out.println("Clic en el label 'Clientes'");
    }

    @FXML
    void handleEliminarClick() {
        // Lógica para eliminar producto
    }

    @FXML
    void handleEmpleadosClick() {
        System.out.println("Clic en el label 'Empleados'");
    }

    @FXML
    void handleFacturasClick() {
        System.out.println("Clic en el label 'Facturas'");
    }

    @FXML
    void handleHistorialClick() {
        System.out.println("Clic en el label 'Historial'");
    }

    @FXML
    void handleInventarioClick() {
        System.out.println("Clic en el label 'Inventario'");
    }

    @FXML
    void handleProveedoresClick() {
        System.out.println("Clic en el label 'Proveedores'");
    }

    @FXML
    void handleProductoClick() {
        System.out.println("Clic en el label 'Producto'");
    }

    @FXML
    void handleBuscarClick() {
        // Lógica para buscar productos
    }

    @FXML
    void initialize() {
        // Initialize the product table
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        precioMaximoColumn.setCellValueFactory(new PropertyValueFactory<>("precioMaximo"));
        precioMinimoColumn.setCellValueFactory(new PropertyValueFactory<>("precioMinimo"));
        codigoColumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        categoriaColumn.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tablaProductos.setItems(listaProductos);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initialize();

        // Load products
        listaProductos.addAll(productoRepo.findAll());

        // Set click handlers
        inventarioLabel.setOnMouseClicked(event -> handleInventarioClick());
        actualizarLabel.setOnMouseClicked(event -> handleActualizarClick());
        historialLabel.setOnMouseClicked(event -> handleHistorialClick());
        facturasLabel.setOnMouseClicked(event -> handleFacturasClick());
        proveedoresLabel.setOnMouseClicked(event -> handleProveedoresClick());
        productoLabel.setOnMouseClicked(event -> handleProductoClick());
        empleadosLabel.setOnMouseClicked(event -> handleEmpleadosClick());
        clientesLabel.setOnMouseClicked(event -> handleClientesClick());
        eliminarLabel.setOnMouseClicked(event -> handleEliminarClick());
        buscarLabel.setOnMouseClicked(event -> handleBuscarClick());
    }

}

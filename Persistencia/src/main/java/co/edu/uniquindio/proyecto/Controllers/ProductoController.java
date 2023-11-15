package co.edu.uniquindio.proyecto.Controllers;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Empleado;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
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
import java.util.ResourceBundle;

@Component
public class ProductoController implements Initializable {

    @Autowired
    SceneController sceneController;
    @Autowired
    ProductoRepo productoRepo;

    ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

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
    private Label eliminarLabel;

    @FXML
    private Label buscarLabel;
    @FXML
    private Label CrearLabel;

    @FXML
    private ComboBox<String> CategoriaFind;

    @FXML
    private TextField idField;

    @FXML
    private TextField nombreField;

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, String> nombreColumn;

    @FXML
    private TableColumn<Producto, Double> precioMaximoColumn;

    @FXML
    private TableColumn<Producto, Double> precioMinimoColumn;

    @FXML
    private TableColumn<Producto, Integer> codigoColumn;

    @FXML
    private TableColumn<Producto, String> categoriaColumn;

    @FXML
    private TableColumn<Producto, Integer> stockColumn;

    @FXML
    void handleActualizarClick(MouseEvent event
                               ) {

        String codigoText = idField.getText();
        Integer codigo = null;
        try {
            if (!codigoText.isEmpty()) {
                codigo = Integer.parseInt(codigoText);
                Producto producto = productoRepo.findById(codigo).orElse(null);
                if(producto != null){
                    sceneController.cambiarAVentanaActualizarProducto(event,empleadoLogin,producto);
                }
            }
        } catch (NumberFormatException e) {
            // Maneja la excepción si el código no es un número válido
            mostrarAlerta("El código debe ser un número válido.", "Error de entrada", Alert.AlertType.ERROR);
            return;
        }
    }

    @FXML
    void handleClientesClick(MouseEvent event   ) {
        if(!empleadoLogin.getNombre().equalsIgnoreCase("ADMIN")){
            mostrarAlerta("No tiene permisos para acceder a esta ventana", "Error de entrada", Alert.AlertType.ERROR);
        }else{
            abrirVentanaClientes(event, empleadoLogin);
        }
        System.out.println("Clic en el label 'Clientes'");
    }

    @FXML
    private void handleEliminarClick() {
        String nombre = nombreField.getText();
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
        if (codigoText.isEmpty()) {
            mostrarAlerta("Ingrese el código del producto a eliminar", "Error", Alert.AlertType.ERROR);
        } else {
            Producto producto = productoRepo.findById(codigo).orElse(null);

            if (producto == null) {
                mostrarAlerta("El producto con el código proporcionado no existe", "Error", Alert.AlertType.ERROR);
            } else {
                productoRepo.delete(producto);
                mostrarAlerta("Producto eliminado:)", "CONFIRMATION", Alert.AlertType.CONFIRMATION);
                listaProductos.clear();
                listaProductos.addAll(productoRepo.findAll());
            }
        }
    }


    @FXML
    void handleEmpleadosClick(MouseEvent event) {
        if(!empleadoLogin.getNombre().equalsIgnoreCase("ADMIN")){
            mostrarAlerta("No tiene permisos para acceder a esta ventana", "Error de entrada", Alert.AlertType.ERROR);
        }else{
            abrirVentanaEmpleados(event, empleadoLogin);
            empleadosLabel.getScene().getWindow().hide();
        }
        System.out.println("Clic en el label 'Empleados'");
    }

    @FXML
    void handleFacturasClick(MouseEvent event) {
        abrirVentanaFacturas(event, empleadoLogin);
        facturasLabel.getScene().getWindow().hide();
        System.out.println("Clic en el label 'Facturas'");
    }

    @FXML
    void handleHistorialClick(MouseEvent event) {
        abrirVentanaHistorial(event, empleadoLogin);
        historialLabel.getScene().getWindow();
        System.out.println("Clic en el label 'Historial'");
    }

    @FXML
    void handleInventarioClick(MouseEvent event ) {
        abrirVentanaInventario(event, empleadoLogin);
        inventarioLabel.getScene().getWindow().hide();
        System.out.println("Clic en el label 'Inventario'");
    }

    @FXML
    void handleProveedoresClick(MouseEvent event) {
        abrirVentanaProveedores(event, empleadoLogin);
        proveedoresLabel.getScene().getWindow().hide();
        System.out.println("Clic en el label 'Proveedores'");
    }

    @FXML
    void handleProductoClick(MouseEvent event) {
        abrirVentanaProducto(event, empleadoLogin);
        productoLabel.getScene().getWindow().hide();
        System.out.println("Clic en el label 'Producto'");
    }
    @FXML
    void handleCrearClick(MouseEvent event){
        sceneController.cambiarAVentanaCrearProducto(event,empleadoLogin);
    }

    @FXML
    private void handleBuscarClick() {
        String nombre = nombreField.getText();
        String codigoText = idField.getText();
        String categoria = CategoriaFind.getSelectionModel().getSelectedItem();

        // Intenta convertir el código a Integer, maneja una posible excepción NumberFormatException
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

        if (nombre.isEmpty() && idField.getText().isEmpty() && categoria != null) {
            // Lógica para buscar por categoría
            listaProductos.clear();
            cargarProductosPorCategoria(categoria);
        } else if (!nombre.isEmpty() && idField.getText().isEmpty() && categoria == null) {
            // Lógica para buscar por nombre
            listaProductos.clear();
            cargarProductosPorNombre(nombre);
        } else if (nombre.isEmpty() && !idField.getText().isEmpty() && categoria == null) {
            // Lógica para buscar por código
            listaProductos.clear();
            cargarProductosPorCodigo(codigo);
        } else if (!nombre.isEmpty() && !idField.getText().isEmpty() && categoria!= null) {
            // Lógica para buscar por nombre, código y categoría
            listaProductos.clear();
            cargarProductosPorTodo(nombre, codigo, categoria);
        } else if (!nombre.isEmpty() && !idField.getText().isEmpty() && categoria == null) {
            // Lógica para buscar por nombre y código
            listaProductos.clear();
            cargarProductosPorNombreyCodigo(nombre, codigo);
        } else if (!nombre.isEmpty() && idField.getText().isEmpty() && categoria!= null) {
            // Lógica para buscar por nombre y categoría
            listaProductos.clear();
            cargarProductosPorNombreyCategoria(nombre, categoria);
        } else if (nombre.isEmpty() && !idField.getText().isEmpty() && categoria!= null) {
            // Lógica para buscar por código y categoría
            listaProductos.clear();
            cargarProductosPorCodigoyCategoria(codigo, categoria);
        } else if (nombre.isEmpty() && idField.getText().isEmpty() && categoria == null) {
            // Lógica para mostrar todos los productos si no se especifica ninguna búsqueda
            listaProductos.clear();
            listaProductos.addAll(productoRepo.findAll());
        } else {
            mostrarAlerta("ha ocurrido un error", "Error de entrada", Alert.AlertType.ERROR);
        }
    }
    public Categoria Traduciropciones(String opcion) {
        switch (opcion) {
            case "MAQUILLAJE":
                return Categoria.MAQUILLAJE;
            case "CUIDADO_CABELLO":
                return Categoria.CUIDADO_CABELLO;
            case "CUIDADO_PIEL":
                return Categoria.CUIDADO_PIEL;
            case "FRAGANCIAS":
                return Categoria.FRAGANCIAS;
            case "CUIDADO_UNAS":
                return Categoria.CUIDADO_UNAS;
            case "ACCESORIOS_BELLEZA":
                return Categoria.ACCESORIOS_BELLEZA;
            case "CATEGORIA_1":
                return Categoria.CATEGORIA_1;
            case "CATEGORIA_2":
                return Categoria.CATEGORIA_2;
            case "CATEGORIA_3":
                return Categoria.CATEGORIA_3;
            default:
                // Manejar el caso por defecto si la opción no coincide con ninguna categoría

                return  null;
        }
    }
    private void cargarProductosPorCategoria(String categoria) {
         Categoria categoria1 = Traduciropciones (categoria);
        listaProductos.addAll(productoRepo.findAllByCategoria(categoria1));
    }

    private void cargarProductosPorCodigo(Integer codigo) {
        listaProductos.addAll(productoRepo.findAllByCodigo(codigo));
    }

    private void cargarProductosPorNombreyCodigo(String nombre, Integer codigo) {
        listaProductos.addAll(productoRepo.findAllByNombreAndCodigo(nombre, codigo));
    }

    private void cargarProductosPorNombre(String nombre) {
        listaProductos.addAll(productoRepo.findAllByNombre(nombre));
    }

    private void cargarProductosPorTodo(String nombre, Integer codigo, String categoria) {
        listaProductos.addAll(productoRepo.findAllByNombreAndCodigoAndCategoria(nombre, codigo, categoria));
    }

    private void cargarProductosPorNombreyCategoria(String nombre, String categoria) {
        listaProductos.addAll(productoRepo.findAllByNombreAndCategoria(nombre, categoria));
    }

    private void cargarProductosPorCodigoyCategoria(Integer codigo, String categoria) {
        listaProductos.addAll(productoRepo.findAllByCodigoAndCategoria(codigo, categoria));
    }


    private void mostrarAlerta(String mensaje, String titulo, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null); // Puedes establecer un encabezado si lo deseas
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        // Initialize the product table
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        precioMaximoColumn.setCellValueFactory(new PropertyValueFactory<>("precio_maximo"));
        precioMinimoColumn.setCellValueFactory(new PropertyValueFactory<>("precio_minimo"));
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
        inventarioLabel.setOnMouseClicked(event -> handleInventarioClick(event));
        actualizarLabel.setOnMouseClicked(event -> handleActualizarClick(event));
        historialLabel.setOnMouseClicked(event -> handleHistorialClick(event));
        facturasLabel.setOnMouseClicked(event -> handleFacturasClick(event));
        proveedoresLabel.setOnMouseClicked(event -> handleProveedoresClick(event));
        productoLabel.setOnMouseClicked(event -> handleProductoClick(event));
        empleadosLabel.setOnMouseClicked(event -> handleEmpleadosClick(event));
        clientesLabel.setOnMouseClicked(event -> handleClientesClick(event));
        CrearLabel.setOnMouseClicked(event -> handleCrearClick(event));
        eliminarLabel.setOnMouseClicked(event -> handleEliminarClick());
        buscarLabel.setOnMouseClicked(event -> handleBuscarClick());
        ObservableList<String> opciones = FXCollections.observableArrayList("MAQUILLAJE",
                "CUIDADO_CABELLO",
                "CUIDADO_PIEL",
                "FRAGANCIAS",
                "CUIDADO_UNAS",
                "ACCESORIOS_BELLEZA",
                "CATEGORIA_1",
                "CATEGORIA_2",
                "CATEGORIA_3");
        CategoriaFind.setItems(opciones);
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
    public void displayEmployeeIDUsername(Empleado empleado){
        empleadoLogin = empleado;
        nombreUsuarioLabel.setText(empleado.getNombre());
        fechaLabel.setText("Fecha: " + java.time.LocalDate.now());
    }

}

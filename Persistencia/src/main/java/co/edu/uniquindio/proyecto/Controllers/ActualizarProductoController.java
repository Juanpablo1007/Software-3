package co.edu.uniquindio.proyecto.Controllers;


import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Proveedor;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
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
import java.util.ResourceBundle;

@Component
public class ActualizarProductoController implements Initializable {
    @Autowired
    ProductoRepo productoRepo;

    Producto producto;




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
    private Label stockLabel;




    @FXML
    private TextField stockField1;



    @FXML
    private TextField PrecioMaximoField;

    @FXML
    private TextField PrecioMinimoField;
    @FXML
    private ComboBox<String> CategoriaFind;

    @FXML
    public void initialize() {


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

    @FXML
    private void handleInventarioClick() {
        // Lógica cuando se hace clic en el label de inventario
        System.out.println("Inventario label clicado");
    }
    @FXML
    private void handleActualizarClick() {
        if (PrecioMaximoField.getText().isEmpty() || PrecioMinimoField.getText().isEmpty() || stockField1.getText().isEmpty()) {
            mostrarAlerta("No deje campos vacíos", "Error", Alert.AlertType.ERROR);
        } else if (!isNumeric(PrecioMaximoField.getText()) || !isNumeric(PrecioMinimoField.getText()) || !isNumeric(stockField1.getText())) {
            mostrarAlerta("No llene con letras los campos que son números .__.", "Error", Alert.AlertType.ERROR);
        } else {

            Double precioMax = Double.parseDouble(PrecioMaximoField.getText());
            Double precioMin = Double.parseDouble(PrecioMinimoField.getText());

            Integer stock = Integer.parseInt(stockField1.getText());
            if (precioMin > precioMax) {
                mostrarAlerta("El precio máximo no puede ser menor al mínimo", "Error", Alert.AlertType.ERROR);
            } else if (stock < 0) {
                mostrarAlerta("El stock debe ser mayor a 0", "Error", Alert.AlertType.ERROR);
            } else {
                producto.setPrecio_maximo(precioMax);
                producto.setPrecio_minimo(precioMin);
                producto.setCategoria(Traduciropciones(CategoriaFind.getSelectionModel().getSelectedItem()));
                producto.setStock(stock);

                productoRepo.save(producto);
                mostrarAlerta("Producto actualizado :)", "CONFIRMATION", Alert.AlertType.CONFIRMATION);
                // Puedes agregar acciones adicionales aquí después de guardar el producto
            }
        }
    }
    @FXML
    public static boolean isNumeric(String str) {
        // Verifica si el String es nulo o está vacío
        if (str == null || str.isEmpty()) {
            return false;
        }

        // Verifica si cada caracter es un dígito
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        // Si todos los caracteres son dígitos, retorna true
        return true;
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
    private void mostrarAlerta(String mensaje, String titulo, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null); // Puedes establecer un encabezado si lo deseas
        alert.setContentText(mensaje);
        alert.showAndWait();
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
}

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


    private void handleInventarioClick() {
        // Lógica cuando se hace clic en el label de inventario
        System.out.println("Inventario label clicado");
    }

    private void  handleActualizarClick() {
        if( PrecioMaximoField.getText().isEmpty() || PrecioMinimoField.getText().isEmpty()|| stockField1.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "No deje campos vacios");
        }else if(!isNumeric(PrecioMaximoField.getText() )||!isNumeric(PrecioMinimoField.getText() ) || !isNumeric(stockField1.getText() ) ) {
            JOptionPane.showMessageDialog(null, "No llene con letras los campos que son numeros .__.");
        }  else {

Double precioMax = Double.parseDouble(PrecioMaximoField.getText()) ;
Double precioMin = Double.parseDouble(PrecioMinimoField.getText());

Integer Stock = Integer.parseInt( stockField1.getText());
if(precioMin>precioMax){
    JOptionPane.showMessageDialog(null, "el precio maximo no puede ser menor al minimo");
} else if (Stock < 0 ){
    JOptionPane.showMessageDialog(null, "El stock debe ser mayor a 0");
} else{
 producto.setPrecio_maximo(precioMax);
 producto.setPrecio_minimo(precioMin);
 producto.setCategoria(Traduciropciones(CategoriaFind.getSelectionModel().getSelectedItem()));
 producto.setStock(Stock);


    productoRepo.save(producto);
    JOptionPane.showMessageDialog(null, "Producto creado :)");
           }

        }

    }
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

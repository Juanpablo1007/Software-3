package co.edu.uniquindio.proyecto.Controllers;



import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Empleado;
import co.edu.uniquindio.proyecto.entidades.Tipo_Documento;
import co.edu.uniquindio.proyecto.repositorios.EmpleadoRepo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.net.URL;
import java.util.ResourceBundle;
@Component
public class LoginController  {
    @Autowired
    EmpleadoRepo empleadoRepo;
    Empleado empleado;
    Administrador administrador;

    @FXML
    private Label IngresarLabel ;
    @FXML
    private Label RegistrarLabel;

    @FXML
    private TextField ContraseñaField ;

    @FXML
    private TextField  CorreoField  ;



    @FXML
    private void initialize() {

        IngresarLabel.setOnMouseClicked(event -> handleIngresarClick());
        RegistrarLabel.setOnMouseClicked(event ->  handleRegistrarClick());
    }
    @FXML
    private void handleIngresarClick() {
        if (CorreoField.getText().isEmpty() || ContraseñaField.getText().isEmpty()) {
            mostrarMensaje("No deje campos vacíos", "Error", Alert.AlertType.ERROR);
        } else {
            empleado = empleadoRepo.findByCorreoAndContrasenia(CorreoField.getText(), ContraseñaField.getText()).orElse(null);
            if (empleado != null) {
                mostrarMensaje("Ingresando...", "CONFIRMATION", Alert.AlertType.CONFIRMATION);
                // función para ir a las pantallas de empleado con argumento (empleado)
            } else if ("yutu6d1@hotmail.com".equals(CorreoField.getText()) && "12345".equals(ContraseñaField.getText())) {
                mostrarMensaje("Ingresando...", "CONFIRMATION", Alert.AlertType.CONFIRMATION);
                // función para ir a las pantallas de admin
            } else {
                mostrarMensaje("No hay usuarios registrados con esas credenciales", "Error", Alert.AlertType.ERROR);
            }
        }
    }
    private void mostrarMensaje(String mensaje, String titulo, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null); // Puedes establecer un encabezado si lo deseas
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @FXML
    private void  handleRegistrarClick() {
// funcion para ir a la pantalla crear empleado
    }
}

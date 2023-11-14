package co.edu.uniquindio.proyecto.Controllers;



import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Empleado;
import co.edu.uniquindio.proyecto.entidades.Tipo_Documento;
import co.edu.uniquindio.proyecto.repositorios.EmpleadoRepo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
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
if(CorreoField.getText().isEmpty() || ContraseñaField.getText().isEmpty()){
    JOptionPane.showMessageDialog(null, "No deje campos vacios");
}else{
    empleado = empleadoRepo.findByCorreoAndAndContrasenia(CorreoField.getText(), ContraseñaField.getText()).orElse(null);
    if(empleado != null){
        //funcion para ir a las pantallas de empleado con argumento (empleado)
    } else if (administrador.getCorreo().equals(CorreoField.getText()) && administrador.getContrasenia().equals(ContraseñaField.getText())) {
        //funcion para ir a las pantallas de admin
    } else {
        JOptionPane.showMessageDialog(null, "No hay usuarios registrados con esas credenciales");
    }
}
    }

    @FXML
    private void  handleRegistrarClick() {
// funcion para ir a la pantalla crear empleado
    }
}

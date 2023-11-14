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
public class CrearEController implements Initializable {
@Autowired
    EmpleadoRepo empleadoRepo;
Administrador administrador = new Administrador();


    @FXML
    private Label CrearLabel;

    @FXML
    private Label RegresarLabel;

    @FXML
    private TextField telefonoField;

    @FXML
    private TextField ContraseñaAdminField;

    @FXML
    private TextField direccionField;

    @FXML
    private TextField ApellidoField;

    @FXML
    private TextField cedulaField;

    @FXML
    private TextField nombreField1;

    @FXML
    private TextField contraseniaField;

    @FXML
    private TextField contraseniaRepField;
    @FXML
    private TextField CorreoField;

    @FXML
    private void initialize() {

        CrearLabel.setOnMouseClicked(event -> handleCrearClick());
        RegresarLabel.setOnMouseClicked(event ->  handleRegresarClick());
    }



    @FXML
    private void handleCrearClick() {
        if(ContraseñaAdminField.getText().isEmpty() || nombreField1 .getText().isEmpty() || cedulaField.getText().isEmpty() ||direccionField.getText().isEmpty()|| ApellidoField.getText().isEmpty()|| telefonoField.getText().isEmpty() || contraseniaField.getText().isEmpty() ||contraseniaRepField.getText().isEmpty() || CorreoField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "No deje campos vacios");
        } else if (!ContraseñaAdminField.getText().equalsIgnoreCase(administrador.getContrasenia())){
            JOptionPane.showMessageDialog(null, "la contraseña del administrados no conincide");
        } else if (contraseniaField.getText().equals(contraseniaRepField.getText())){
            JOptionPane.showMessageDialog(null, "las contraseñas no coninciden");
        }else if (empleadoRepo.findByCorreo(CorreoField.getText()).isPresent()){
            JOptionPane.showMessageDialog(null, "este correo ya se encuentra registrado");
        } else{
            Empleado empleado = new Empleado(cedulaField.getText(),nombreField1 .getText(),ApellidoField.getText(),direccionField.getText(),CorreoField.getText() ,telefonoField.getText(), contraseniaField.getText(), Tipo_Documento.CEDULA_CIUDADANIA);
       empleadoRepo.save(empleado);
            JOptionPane.showMessageDialog(null, "empleado registrado con exito");
        }

    }

    @FXML
    private void handleRegresarClick() {
        // Lógica cuando se hace clic en el botón Regresar
        System.out.println("Botón Regresar clicado");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

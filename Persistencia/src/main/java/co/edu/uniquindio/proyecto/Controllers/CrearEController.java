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
import javafx.stage.Stage;
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
    private Empleado empleadoLogin;

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

    }



    @FXML
    private void handleCrearClick() {
        if (ContraseñaAdminField.getText().isEmpty() || nombreField1.getText().isEmpty() || cedulaField.getText().isEmpty() || direccionField.getText().isEmpty() || ApellidoField.getText().isEmpty() || telefonoField.getText().isEmpty() || contraseniaField.getText().isEmpty() || contraseniaRepField.getText().isEmpty() || CorreoField.getText().isEmpty()) {
            mostrarAlerta("No deje campos vacíos", "Error", Alert.AlertType.ERROR);
        } else if (!ContraseñaAdminField.getText().equalsIgnoreCase("12345")) {
            mostrarAlerta("La contraseña del administrador no coincide", "Error", Alert.AlertType.ERROR);
        } else if (!contraseniaField.getText().equals(contraseniaRepField.getText())) {
            mostrarAlerta("Las contraseñas no coinciden", "Error", Alert.AlertType.ERROR);
        } else if (empleadoRepo.findByCorreo(CorreoField.getText()).isPresent()) {
            mostrarAlerta("Este correo ya se encuentra registrado", "Error", Alert.AlertType.ERROR);
        } else {
            Empleado empleado = new Empleado(cedulaField.getText(), nombreField1.getText(), ApellidoField.getText(), direccionField.getText(), CorreoField.getText(), telefonoField.getText(), contraseniaField.getText(), Tipo_Documento.CEDULA_CIUDADANIA);
            empleadoRepo.save(empleado);
            mostrarAlerta("Empleado registrado con éxito", "CONFIRMATION", Alert.AlertType.CONFIRMATION);
            // Puedes agregar acciones adicionales aquí después de guardar el empleado
        }
    }
    private void mostrarAlerta(String mensaje, String titulo, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null); // Puedes establecer un encabezado si lo deseas
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @FXML
    private void handleRegresarClick() {
        Stage stage = (Stage) RegresarLabel.getScene().getWindow();

        // Cerramos la ventana
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        CrearLabel.setOnMouseClicked(event -> handleCrearClick());
        RegresarLabel.setOnMouseClicked(event -> handleRegresarClick());

    }
    public void displayEmployeeIDUsername(Empleado empleado){
        //no tiene campos de fecha ni nombre usuario
    }
}

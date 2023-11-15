package co.edu.uniquindio.proyecto.Controllers;

import co.edu.uniquindio.proyecto.entidades.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Getter
@Setter
@Component
public class SceneController {

    @Autowired
    private ConfigurableApplicationContext springContext;

    public void cambiarAVentanaActualizarCliente(MouseEvent event, Empleado empleadoLogueado, Cliente clientell) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/actualizarC.fxml"));
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();

            ActualizarCController controlador = loader.getController();
            controlador.displayEmployeeIDUsername(empleadoLogueado);
            controlador.displayclienteIDUsername(clientell);

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Multibelleza del quindio");
            stage.setMinHeight(700);
            stage.setMinWidth(1100);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void cambiarAVentanaActualizarEmpleado(MouseEvent event, Empleado empleadoLogueado) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/actualizarE.fxml"));
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();

            ActualizarEController controlador = loader.getController();
            controlador.displayEmployeeIDUsername(empleadoLogueado);

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Multibelleza del Quindio");
            stage.setMinHeight(700);
            stage.setMinWidth(1100);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void cambiarAVentanaActualizarProveedor(MouseEvent event, Empleado empleadoLogueado) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/actualizarPr.fxml"));
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();

            ActualizarPrController controlador = loader.getController();
            controlador.displayEmployeeIDUsername(empleadoLogueado);

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Multibelleza del Quindio");
            stage.setMinHeight(700);
            stage.setMinWidth(1100);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void cambiarAVentanaActualizarProducto(MouseEvent event, Empleado empleadoLogueado) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ActualizarProducto.fxml"));
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();

            ActualizarProductoController controlador = loader.getController();
            controlador.displayEmployeeIDUsername(empleadoLogueado);

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Multibelleza del Quindio");
            stage.setMinHeight(700);
            stage.setMinWidth(1100);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void cambiarAVentanaCrearCliente(MouseEvent event, Empleado empleadoLogueado) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/CrearC.fxml"));
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();

            CrearCController controlador = loader.getController();
            controlador.displayEmployeeIDUsername(empleadoLogueado);

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Multibelleza del Quindio");
            stage.setMinHeight(700);
            stage.setMinWidth(1100);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void cambiarAVentanaCrearEmpleado(MouseEvent event) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/CrearE.fxml"));
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();

            CrearEController controlador = loader.getController();


            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Multibelleza del Quindio");
            stage.setMinHeight(700);
            stage.setMinWidth(1100);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void cambiarAVentanaCrearProveedor(MouseEvent event, Empleado empleadoLogueado) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/CrearPr.fxml"));
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();

            CrearPrController controlador = loader.getController();
            controlador.displayEmployeeIDUsername(empleadoLogueado);

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Multibelleza del Quindio");
            stage.setMinHeight(700);
            stage.setMinWidth(1100);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void cambiarAVentanaCrearProducto(MouseEvent event, Empleado empleadoLogueado) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/CrearProducto.fxml"));
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();

            CrearProductoController controlador = loader.getController();
            controlador.displayEmployeeIDUsername(empleadoLogueado);

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Multibelleza del Quindio");
            stage.setMinHeight(700);
            stage.setMinWidth(1100);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
    public void cambiarAVentanaCliente(MouseEvent event, Empleado empleadoLogueado) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Cliente.fxml"));
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();

            ClienteController controlador = loader.getController();
            controlador.displayEmployeeIDUsername(empleadoLogueado);

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Multibelleza del Quindio");
            stage.setMinHeight(700);
            stage.setMinWidth(1100);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
    public void cambiarAVentanaEmpleado(MouseEvent event, Empleado empleadoLogueado) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Empleado.fxml"));
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();

            EmpleadoController controlador = loader.getController();
            controlador.displayEmployeeIDUsername(empleadoLogueado);

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Multibelleza del Quindio");
            stage.setMinHeight(700);
            stage.setMinWidth(1100);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
    public void cambiarAVentanaInventario(MouseEvent event, Empleado empleadoLogueado) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Inventario.fxml"));
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();

            InventarioController controlador = loader.getController();
            controlador.displayEmployeeIDUsername(empleadoLogueado);

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Multibelleza del Quindio");
            stage.setMinHeight(700);
            stage.setMinWidth(1100);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
    public void cambiarAVentanaProducto(MouseEvent event, Empleado empleadoLogueado) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Producto.fxml"));
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();

            ProductoController controlador = loader.getController();
            controlador.displayEmployeeIDUsername(empleadoLogueado);

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Multibelleza del Quindio");
            stage.setMinHeight(700);
            stage.setMinWidth(1100);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
    public void cambiarAVentanaProveedor(MouseEvent event, Empleado empleadoLogueado) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Proveedor.fxml"));
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();

            ProveedorController controlador = loader.getController();
            controlador.displayEmployeeIDUsername(empleadoLogueado);

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Multibelleza del Quindio");
            stage.setMinHeight(700);
            stage.setMinWidth(1100);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
    public void cambiarAVentanaFactura(MouseEvent event, Empleado empleadoLogueado) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/factura.fxml"));
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();

            FacturaController controlador = loader.getController();
            controlador.displayEmployeeIDUsername(empleadoLogueado);

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Multibelleza del Quindio");
            stage.setMinHeight(700);
            stage.setMinWidth(1100);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

}

package co.edu.uniquindio.proyecto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static javafx.application.Application.launch;

@SpringBootApplication
public class PersistenciaApplication   extends Application {
    public static final ConfigurableApplicationContext context = SpringApplication.run(PersistenciaApplication.class);
    public static void main(String[] args)  {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
try {
    //primaryStage.getIcons().add(new Image(PersistenciaApplication.class.getResourceAsStream("views/images/logo.png")));
    primaryStage.setTitle("Multibelleza");
    FXMLLoader loader = new FXMLLoader(PersistenciaApplication.class.getResource("views/login.fxml"));
    loader.setControllerFactory(context::getBean);
    BorderPane rootLayout = (BorderPane) loader.load();
    Scene scene = new Scene(rootLayout);
    primaryStage.setScene(scene);
    primaryStage.show();
}catch (Exception  e){
e.printStackTrace();
}
    }
    @Override
    public void stop() {
        System.exit(0);
    }
}
